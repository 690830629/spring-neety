package com.wanglei.netty_rpc.api;

public interface IRpcService {

    // 加
    int add(int a, int b);

    // 减
    int sub(int a, int b);


    int mult(int a, int b);

    int div(int a, int b);
}
