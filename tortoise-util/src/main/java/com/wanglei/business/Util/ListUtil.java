package com.wanglei.business.Util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            a.add(i);
        }
        List<Integer> integerList = a.subList(0, 10);
        System.out.println(integerList.toString());

    }
}
