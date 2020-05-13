package com.wanglei.config;

import com.wanglei.business.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "mycar")
    public Car getCar() {
        System.out.println("初始化了carBean");
        Car car = new Car();
        return car;
    }
}
