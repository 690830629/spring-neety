package com.jdk;

public class MyArray {
    public static void main(String[] args) {

        int c[] ={1,2};
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
        swap3(c,0,1);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }

    public static void swap(int a[] ,int c,int b){

        int  temp=a[c];
        a[c]=a[b];
        a[b]=temp;
    }

    public  static void swap1(int a[] ,int index1,int index2){

        a[index1]=a[index1]^a[index2];
        a[index2]=a[index1]^a[index2];
        a[index1]=a[index1]^a[index2];
    }

    public static void swap3(int a[] ,int c,int b){

       a[c]=a[c]+a[b];
       a[b]=a[c]-a[b];
       a[c]=a[c]-a[b];
    }

}
