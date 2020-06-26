package com.wanglei.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class EchoHandler implements Runnable {
    private Selector selector;
    private SocketChannel socketChannel;

    private SelectionKey sk;
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    static final int RECIEVING = 0, SENDING = 1;

    int state = RECIEVING;

    public EchoHandler(Selector se, SocketChannel sc) throws IOException {
        this.selector = se;
        this.socketChannel = sc;
        socketChannel.configureBlocking(false);
        SelectionKey sk = socketChannel.register(selector, SelectionKey.OP_READ);
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();

    }

    @Override
    public void run() {
        try {
            if (state == SENDING) {

                socketChannel.write(byteBuffer);
                byteBuffer.clear();
                sk.interestOps(SelectionKey.OP_READ);
            } else if (state == RECIEVING) {
                int length=0;
                while((length=socketChannel.read(byteBuffer))>0){

            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
