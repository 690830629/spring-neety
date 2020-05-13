package com.wanglei.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration

@ImportResource(value = {"classpath:config/spring/applicationContext-client.xml"})
public class MyConfig {

}
