package com.gl.spring;

import org.springframework.stereotype.Component;

@Component
public class Animal {

    public void eat() {
        System.out.println("Animal is eating...");
    }

    public void sleep() {
        System.out.println("Animal is sleeping...");
    }

    public void run() {
        System.out.println("Animal is running...");
        throw new RuntimeException("Animal got tired while running!");
    }
}

