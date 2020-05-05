package com.wanglei.business.Configuration;

import com.wanglei.business.model.Desk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Desk getDesk() {

        Desk desk = new Desk();
        desk.setColor("red");
        return desk;

    }

}
