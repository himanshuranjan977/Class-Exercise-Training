package com.gl.collection.example;


import java.util.ArrayDeque;

public class Queue1 {
    public static void main(String[] args) {
        ArrayDeque<String> animals = new ArrayDeque<>();
        animals.add("Dog");
        animals.add("Lion");
        animals.add("Tiger");
        System.out.println(animals);// FIFO - Queue

        animals.push("Elephant");
        
        System.out.println(animals);// LIFO - Stack
        System.out.println(animals.peek());// first element
        System.out.println(animals.peekFirst());//first element
        System.out.println(animals.peekLast());//last element
    }

}
