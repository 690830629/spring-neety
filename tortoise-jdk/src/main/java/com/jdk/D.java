package com.jdk;

public class D {
    public static void main(String[] args) {

        A a=new  C ();
        if(a instanceof A){
            System.out.println("是A的实例");
        }
        if(a instanceof B){
            System.out.println("是B的实例");
        }
        if(a instanceof C){
            System.out.println("是C的实例");
        }

    }
}
