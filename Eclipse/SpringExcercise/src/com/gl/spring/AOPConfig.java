package com.gl.spring;



import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

@Aspect
public class  AOPConfig {

    @Before("execution(* com.gl.spring.Student.printDetails(..))")
    public void beforeAdvice() {
        System.out.println("[AOP Before] About to print student details...");
    }

    @After("execution(* com.gl.spring.Student.printDetails(..))")
    public void afterAdvice() {
        System.out.println("[AOP After] Finished printing student details.");
    }
}

