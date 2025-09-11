package com.gl.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPConfig {

    // Before advice for all Animal methods
    @Before("execution(* com.gl.spring.Animal.*(..))")
    public void beforeAnyMethod() {
        System.out.println("[AOP] Before calling Animal method...");
    }

    // AfterThrowing advice only for run()
    @AfterThrowing(pointcut = "execution(* com.gl.spring.Animal.run(..))", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("[AOP] Exception caught in run(): " + ex.getMessage());
    }
}

