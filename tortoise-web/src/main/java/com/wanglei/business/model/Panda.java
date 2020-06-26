package com.wanglei.business.model;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
public class Panda {
    private long age;

    private String name;

    public static void main(String[] args) {

        Panda panda=new Panda();
        panda.setAge(1);
        panda.setName("熊猫1");
        Panda panda3=new Panda();
        panda3.setAge(3);
        panda3.setName("熊猫3");
        Panda panda2=new Panda();
        panda2.setAge(2);
        panda2.setName("熊猫2");
        List<Panda> pandaList= Lists.newArrayList();
        pandaList.add(panda);
        pandaList.add(panda3);
        pandaList.add(panda2);
        System.out.println(pandaList.toString());

        Collections.sort(pandaList, Comparator.comparingLong(Panda::getAge));
        System.out.println(pandaList.toString());

    }
}
