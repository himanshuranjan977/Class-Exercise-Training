package com.gl.collection.example;

import java.util.PriorityQueue;

public class Queue2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> admissionNumbers = new PriorityQueue<>();
        admissionNumbers.add(12);
        admissionNumbers.add(22);
        //admissionNumbers.add(10);
        admissionNumbers.add(5);
        admissionNumbers.add(50);
        System.out.println(admissionNumbers);
    }
}
