package com.wanglei.business.spring;

import com.wanglei.business.model.User;

public abstract class GetBeanTest {


    public String getName() {

        return this.getBean() .getUser1Name();

    }

    public abstract User getBean();


}
