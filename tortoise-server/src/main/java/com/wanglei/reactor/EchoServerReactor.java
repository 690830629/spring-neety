package com.wanglei.reactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoServerReactor implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {


                selector.select();


                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    void dispatch(SelectionKey sk) {
        Runnable handler = (Runnable) sk.attachment();
        if (handler != null) {
            handler.run();
        }
    }

    class AcceptorHandler implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
