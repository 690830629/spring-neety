package com.wanglei.netty_rpc.consumer.proxy;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

public class RpcProxyHandler extends ChannelInboundHandlerAdapter {

    private Object response;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        response = msg;
        System.out.println("客户端获取的结果" + response);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client is exception");
    }

    public Object getResponse() {
        return response;
    }
}
