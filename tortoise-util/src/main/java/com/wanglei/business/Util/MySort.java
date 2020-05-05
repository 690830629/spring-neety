package com.wanglei.business.Util;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MySort {
    public static void main(String[] args) {
        List<Integer> integerList= Lists.newArrayList(8,2,4,7,1);

        Collections.sort(integerList, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

//                Collections.sort(integerList, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });

//                        Collections.sort(integerList, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return -1;
//            }
//        });

        System.out.println(integerList.toString());

    }
}
