package com.wanglei.business.innerclass;

public class MyStaticInnerClass {

    private String name;

    private static int age;

    public int getAge() {
        return A.wight;
    }

    private static class A {

        private static int wight;

        private int hight;

        public void getOutClassAge() {
            System.out.println(age);
        }

    }

    public static void main(String[] args) {

    }
}
