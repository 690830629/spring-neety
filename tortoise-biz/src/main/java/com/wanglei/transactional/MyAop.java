package com.wanglei.transactional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyAop {
    @Pointcut("execution(* *.printB(..))")
    public void test()

    {

    }

    @Before("test()")
    public void beforeTest(){
        System.out.println("printB()beforeTest");
    }
    @After(("test()"))
    public void afterTest(){
        System.out.println("printB()afterTest");
    }
    @Around("test()")
    public List<Integer> aroundTest(ProceedingJoinPoint p) {
        System.out.println("进入了aop的环绕通知");
        Object result = null;
        try {
            result = p.proceed();
            System.out.println("已经执行了printB的目标方法");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return (List<Integer>) result;
    }


}
