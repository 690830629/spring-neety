package com.wanglei.netty_rpc.provider;

import com.wanglei.netty_rpc.api.IRpcService;
import com.wanglei.nettys.RPCServer;

public class RpcServiceImpl implements IRpcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mult(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
