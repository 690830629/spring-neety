package com.wanglei.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket accept = serverSocket.accept();


        new Thread(() -> System.out.println("hahah")).start();

    }

    class BusinessHandler implements Runnable {

        private Socket socket;

        public BusinessHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String context;
                while((context=bufferedReader.readLine())!=null){

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
