package com.gl.spring;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context1 = new ClassPathXmlApplicationContext("AppContext.xml");

        // Get Counter bean
        Counter bean1 = context1.getBean("counter1", Counter.class);

        // Call methods
        //bean1.addAge();
        //bean1.lessAge();
        //bean1.addAge();
        bean1.printAge();
        //bean1.addAge();

        // Print final age
        //System.out.println(bean1.getAge());
        
        //bean1.div(10, 0);
    }
}