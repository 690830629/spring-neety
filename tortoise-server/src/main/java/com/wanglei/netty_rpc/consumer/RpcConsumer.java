package com.wanglei.netty_rpc.consumer;

import com.wanglei.netty_rpc.api.IRpcHelloService;
import com.wanglei.netty_rpc.api.IRpcService;
import com.wanglei.netty_rpc.consumer.proxy.RpcProxy;
import com.wanglei.netty_rpc.provider.RpcHelloServiceImpl;
import com.wanglei.netty_rpc.provider.RpcServiceImpl;

public class RpcConsumer {

    public static void main(String[] args) {
        // 这个是本地调用
//        IRpcHelloService helloService = new RpcHelloServiceImpl();
        IRpcHelloService helloService = RpcProxy.create(IRpcHelloService.class);
        System.out.println(helloService.hello("wanglei"));
//        IRpcService service = new RpcServiceImpl();
        IRpcService service = RpcProxy.create(IRpcService.class);
        System.out.println("8+2=" + service.add(8, 2));
        System.out.println("8-2=" + service.sub(8, 2));
        System.out.println("8*2=" + service.mult(8, 2));
        System.out.println("8/2=" + service.div(8, 2));

        service.add(8, 2);
    }
}
