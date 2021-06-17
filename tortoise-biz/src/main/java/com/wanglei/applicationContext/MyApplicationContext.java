package com.wanglei.applicationContext;

        import com.wanglei.config.Config;
        import com.wanglei.business.Car;
        import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplicationContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Car car = (Car) applicationContext.getBean("mycar");
        System.out.println(car);
        applicationContext.refresh();
        System.out.println("落后一地点");
    }
}
