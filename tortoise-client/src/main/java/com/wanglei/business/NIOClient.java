package com.wanglei.business;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIOClient {

    private static final int PORT = 8888;


    public static void initClient() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(PORT);
        socketChannel.bind(inetSocketAddress);
        socketChannel.connect(inetSocketAddress);
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String context = scanner.nextLine();
            byteBuffer.put(context.getBytes());
            socketChannel.write(byteBuffer);
        }


    }

    public static void main(String[] args) throws IOException {
        ByteBuffer mappedByteBuffer = MappedByteBuffer.allocate(10000);
        NIOClient.initClient();
    }
}
