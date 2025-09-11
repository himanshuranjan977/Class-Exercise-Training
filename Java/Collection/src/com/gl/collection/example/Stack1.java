package com.gl.collection.example;


import java.util.Stack;


public class Stack1 {

    public static void main(String[] args) {
        Stack<String> fruits =new Stack<>();

        fruits.push("watermelon");
        fruits.push("Apple");
        fruits.push("Orange");
        fruits.push("Banana");
        System.out.println(fruits);

        System.out.println("LIFO : "+ fruits.pop());// Pop- remove but the last element 
        System.out.println("Stack after pop : " +fruits);

        System.out.println("LIFO : " +fruits.peek());//peek- Display the last Element
        System.out.println("Stack Afer peek : " + fruits);

    }

}
