package com.wanglei.reactor;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class MyReactor implements Runnable {

    Selector selector;

    ServerSocketChannel serverSocket;


    void EchoServerReactor() throws ClosedChannelException {
        SelectionKey sk = serverSocket.register(selector, SelectionKey.OP_ACCEPT);

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {


        }

    }
}
