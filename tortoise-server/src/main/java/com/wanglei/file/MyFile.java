package com.wanglei.file;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wanglei/Desktop/111.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        String context = "";
        byte[] bytes = new byte[2048];
        int fff;
        while ((fff = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,bytes.length-1));

        }
    }
}
