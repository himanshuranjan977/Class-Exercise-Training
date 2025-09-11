package com.gl.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Container.class);

        // get bean with id "getCounter" defined in Container.java
        Counter c1 = context.getBean("getCounter", Counter.class);
        c1.increaseCount();
        c1.increaseCount();

        Counter c2 = context.getBean("getCounter", Counter.class);
        c2.increaseCount();
        c2.increaseCount();

        context.close();
    }
}