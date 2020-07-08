package com.wanglei.netty_rpc.consumer.proxy;

import com.wanglei.netty_rpc.protocal.InvokerProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcProxy {
    public static <T> T create(Class<?> clazz) {
        MethodProxy proxy = new MethodProxy(clazz);
        T result = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, proxy);
        return result;
    }

    // 将本地调用通过代理的方式变成网络调用
    private static class MethodProxy implements InvocationHandler {

        private Class<?> clazz;


        public MethodProxy(Class<?> clazz) {

            this.clazz = clazz;

        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            } else {
                return rpcInvoker(proxy, method, args);
            }
        }

        private Object rpcInvoker(Object proxy, Method method, Object[] args) {
            // 先要构造一个协议的内容，消息
            InvokerProtocol msg = new InvokerProtocol();
            msg.setClassName(this.clazz.getName());
            msg.setMethodName(method.getName());
            msg.setPrames(method.getParameterTypes());
            msg.setValues(args);

            final RpcProxyHandler proxyHandler = new RpcProxyHandler();

            //发起网络请求
            EventLoopGroup workgroup = new NioEventLoopGroup();
            try {
                Bootstrap client = new Bootstrap();
                client.group(workgroup)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                // 在netty 把所有的业务逻辑处理全部归总到了一个队列中
                                // 这个对列中包含了各种各样的处理逻辑 对这些处理逻辑在netty有一个封装
                                // 封装成了一个对象 无锁化串行任务对列
                                // Pipline
                                ChannelPipeline pipeline = ch.pipeline();
                                // 就是对处理逻辑的封装
                                // 对于自定义协议的内容就行编码 解码

                                //自定义解码
                                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));

                                // 自定义编码器
                                pipeline.addLast(new LengthFieldPrepender(4));

                                // 实参处理
                                pipeline.addLast("encoder", new ObjectEncoder());
                                pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));

                                // 前面编解码完成数据的解析
                                // 最后一步 执行属于自己的逻辑
                                // 1  注册 给每个对象起个名字 对外提供服务的名字
                                // 2  服务的位置做一个登记
                                pipeline.addLast(new RpcProxyHandler());
                            }
                        });

                ChannelFuture future = client.connect("localhost", 8080).sync();
                future.channel().writeAndFlush(msg).sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                workgroup.shutdownGracefully();
            }

            return proxyHandler.getResponse();
        }
    }
}
