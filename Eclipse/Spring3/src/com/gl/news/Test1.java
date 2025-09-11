package com.gl.news;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Singleton test
        Automobile auto1 = (Automobile) context.getBean("automobile");
        Automobile auto2 = (Automobile) context.getBean("automobile");
        System.out.println("Auto1: " + auto1);
        System.out.println("Auto2: " + auto2);
        System.out.println("Singleton? " + (auto1 == auto2));

        // Prototype test
        Animal animal1 = (Animal) context.getBean("animal");
        Animal animal2 = (Animal) context.getBean("animal");
        System.out.println("Animal1: " + animal1);
        System.out.println("Animal2: " + animal2);
        System.out.println("Prototype? " + (animal1 == animal2));
    }
}
