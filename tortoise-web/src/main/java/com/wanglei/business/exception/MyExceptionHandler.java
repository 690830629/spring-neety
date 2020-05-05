package com.wanglei.business.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ModelAndView handlerException(Exception e) {
        e.printStackTrace();
        System.out.println("进入了异常处理器");
        return null;

    }
}
