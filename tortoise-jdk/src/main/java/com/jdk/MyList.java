package com.jdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(9);
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer next = iterator.next();
//            if(3==next){
//                iterator.remove();
//            }
//        }
//        System.out.println(list.toString());
//        for(Integer integer:list){
//            if(3==integer){
//                list.remove(list.indexOf(3));
//            }
//        }
//        System.out.println(list.toString());
        System.out.println(list.subList(0,5));

    }
}
