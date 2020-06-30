package com.wanglei.netty_rpc.registry;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.nio.channels.ServerSocketChannel;

public class RpcRegistry {

    private int port;

    public RpcRegistry(int port) {
        this.port = port;

    }

    public void start() {

        // ServerSocketChannel ServerSocket

        // 类似线程池 主线程池初始化 Selector
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        // 子线程池初始化 具体对应客户端的处理逻辑
        EventLoopGroup workGroup = new NioEventLoopGroup();


        ServerBootstrap server = new ServerBootstrap();
        // 基于nio实现
        // Selector 主线程 Work线程
        server.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

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
                        pipeline.addLast(new RegistryHandler());


                    }
                }).option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        ChannelFuture future = null;
        try {
            // 正式启动服务 相当于用一个死循环开始轮训
            future = server.bind(this.port).sync();
            System.out.println("GP RPC Registru start listen at" + this.port);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new RpcRegistry(8080).start();
    }

}
