package com.wanglei.business.spring;

import com.wanglei.business.model.Desk;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyInitializingBean implements InitializingBean {

    @Autowired
    private MyPostProcessorBean processorBean;

    @Autowired
    private Desk desk;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyPostProcessorBean被调用了" + processorBean.getCount() + "次");
        System.out.println("执行了InitializingBean");
        System.out.println(desk);
    }

}