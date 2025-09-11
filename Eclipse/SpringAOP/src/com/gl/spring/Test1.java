package com.gl.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");

        Animal animal = context.getBean(Animal.class);

        animal.eat();
        animal.sleep();

        try {
            animal.run();
        } catch (Exception e) {
            System.out.println("Main caught exception: " + e.getMessage());
        }

        context.close();
    }
}

