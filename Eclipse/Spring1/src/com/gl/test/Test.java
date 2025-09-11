package com.gl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String args[]) {
        // load the context file
    	System.out.println("-----Context 1------");
        ApplicationContext context1 = new ClassPathXmlApplicationContext("AppCounter.xml");

        System.out.println("-----C1------");

        // We are asking Spring to give us a bean called "myCounter"
        Counter c1 = context1.getBean("myCounter", Counter.class);

        c1.increaseCount();
        c1.increaseCount();

        System.out.println("------C2------");

        Counter c2 = context1.getBean("myCounter", Counter.class);
        c2.increaseCount();
        c2.increaseCount();
        System.out.println("-----Context 2------");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("AppCounter.xml");

        System.out.println("-----C3------"); 
        Counter c3 = context2.getBean("myCounter", Counter.class);
        c3.increaseCount();
        c3.increaseCount();
        
        System.out.println("-----C4------"); 
        Counter c4 = context2.getBean("myCounter", Counter.class);
        c4.increaseCount();
        c4.increaseCount();
    }
}
