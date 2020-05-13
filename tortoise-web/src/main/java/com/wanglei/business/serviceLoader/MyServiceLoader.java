package com.wanglei.business.serviceLoader;

import java.util.ServiceLoader;

public class MyServiceLoader {
    public static void main(String[] args) {
        ServiceLoader<ILoaderTest> load = ServiceLoader.load(ILoaderTest.class);
        for(ILoaderTest iLoaderTest:load){
            iLoaderTest.getName();
        }
    }
}
