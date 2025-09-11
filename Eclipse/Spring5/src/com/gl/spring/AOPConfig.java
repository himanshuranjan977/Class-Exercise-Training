package com.gl.spring;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AOPConfig {

    @Before("execution(public * com.gl.spring.Counter.addAge(..))")
    public void logBeforeAddAge() {
        System.out.println("Add age is about to be called");
    }
    
    @After("execution(public * com.gl.spring.Counter.addAge(..))")
    public void logAfterAddAge() {
        System.out.println("Add age is called");
    }
    @Before("execution(public * com.gl.spring.Counter.*(..))")
    public void logBeforeALL() {
        System.out.println("I am called before all functions under counter class");
    }
    @After("execution(public * com.gl.spring.Counter.*(..))")
    public void logAfterALL() {
        System.out.println("I am called after all functions under counter class");
    }
    @AfterThrowing("execution(public * com.gl.spring.Counter.*(..))")
    public void logErrorThrown() {
        System.out.println("I am called if error happens  under counter class");
    }
    @Around("execution(public * com.gl.spring.Counter.*(..))")
    public void logBothTimes() {
        System.out.println("I am called called two times for each function under counter class");
    }
}