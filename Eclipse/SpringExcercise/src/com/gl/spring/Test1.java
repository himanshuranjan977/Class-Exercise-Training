package com.gl.spring;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");

        //System.out.println("------ Student1 ------");
        //Student s1 = context.getBean("studentBean", Student.class);
        //System.out.println("name: " + s1.getName());
       // System.out.println("examNumber: " + s1.getExamNumber());
        //System.out.println("gender: " + s1.getGender());
        //System.out.println("age: " + s1.getAge());

        // Student 2
       // System.out.println("------ Student2 ------");
        //Student s2 = context.getBean("studentBean2", Student.class);
        //System.out.println("name: " + s2.getName());
        //System.out.println("examNumber: " + s2.getExamNumber());
        //System.out.println("gender: " + s2.getGender());
        //System.out.println("age: " + s2.getAge());

        // Student 3
        //System.out.println("------ Student3 ------");
        //Student s3 = context.getBean("studentBean3", Student.class);
        //System.out.println("name: " + s3.getName());
        //System.out.println("examNumber: " + s3.getExamNumber());
        //System.out.println("gender: " + s3.getGender());
       // System.out.println("age: " + s3.getAge());
       
        System.out.println("------ Student1 ------");
        Student s1 = context.getBean("studentBean", Student.class);
        s1.printDetails();

        System.out.println("------ Student2 ------");
        Student s2 = context.getBean("studentBean2", Student.class);
        s2.printDetails();

        System.out.println("------ Student3 ------");
        Student s3 = context.getBean("studentBean3", Student.class);
        s3.printDetails();
        
        
    }
}

