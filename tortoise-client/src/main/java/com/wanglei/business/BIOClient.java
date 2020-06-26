package com.wanglei.business;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class BIOClient {
    public static void main(String[] args) throws IOException {
        SocketAddress socketAddress= new InetSocketAddress(7777);
        Socket socket=new Socket();
        socket.connect(socketAddress);
    }
}
