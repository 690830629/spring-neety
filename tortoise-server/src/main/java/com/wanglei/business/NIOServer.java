package com.wanglei.business;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    private static final int PORT = 8888;


    public static void initServer() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(),PORT);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(inetSocketAddress);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeySet.iterator();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeyIterator.next();
                if (selectionKey.isAcceptable()) {
                    System.out.println("客户端发起了连接");
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()) {
                    System.out.println("客户端说了啥");
                }
                selectionKeyIterator.remove();

            }

        }

    }


    public static void main(String[] args) throws IOException {
        NIOServer.initServer();
    }


}
