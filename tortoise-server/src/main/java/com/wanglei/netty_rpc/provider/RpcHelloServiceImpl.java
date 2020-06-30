package com.wanglei.netty_rpc.provider;

import com.wanglei.netty_rpc.api.IRpcHelloService;

public class RpcHelloServiceImpl implements IRpcHelloService {
    @Override
    public String hello(String name) {
        return "hello"+name;
    }
}
