package com.wanglei.business.spring;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyPostProcessorBean implements BeanPostProcessor {

    private volatile  int count=0;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        count++;

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
