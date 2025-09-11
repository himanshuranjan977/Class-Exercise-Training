package com.gl.spring;

public class Counter {
    private int count = 0;

    public void increaseCount() {
        count++;
        System.out.println("Counter : " + count);
    }
}
