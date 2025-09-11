package com.gl.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        // Load Spring configuration file
        ApplicationContext context1 = new ClassPathXmlApplicationContext("AppContext.xml");

        System.out.println("******* A1 ************");
        Automobile a1 = context1.getBean("auto1", Automobile.class);
        System.out.println("color: " + a1.color);
        System.out.println("mileage: " + a1.mileage);

        System.out.println("******* A2 ************");
        Automobile a2 = context1.getBean("auto2", Automobile.class);
        System.out.println("color: " + a2.color);
        System.out.println("mileage: " + a2.mileage);

        System.out.println("******* A3 ************");
        Automobile a3 = context1.getBean("auto3", Automobile.class);
        System.out.println("color: " + a3.color);
        System.out.println("mileage: " + a3.mileage);
    }
}
