package com.wanglei.reactor;

import java.util.ArrayList;
import java.util.List;

public class AcceptorHandler implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        while(true){
            List<Integer>  integerList=new ArrayList<>();
            integerList.add(new Integer(1));
        }
    }
}
