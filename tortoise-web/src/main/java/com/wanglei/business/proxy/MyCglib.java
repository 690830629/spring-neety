package com.wanglei.business.proxy;

import com.wanglei.business.model.User;
import org.springframework.cglib.proxy.Enhancer;

public class MyCglib {
//    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        //设置目标类的字节码文件
//        enhancer.setSuperclass(User.class);
//        //设置回调函数
//        enhancer.setCallback(new MyMethodInterceptor());
//
//        //这里的creat方法就是正式创建代理类
//        User proxyDog = (User)enhancer.create();
//        //调用代理类的eat方法
//        proxyDog.getUser1Name();
//    }
}
