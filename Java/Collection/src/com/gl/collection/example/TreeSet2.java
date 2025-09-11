package com.gl.collection.example;

import java.util.TreeSet;

public class TreeSet2 {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(120);
        numbers.add(60);
        numbers.add(70);

        System.out.println(numbers);
        System.out.println(numbers.first());
        System.out.println(numbers.last());
        System.out.println(numbers.size());
        
        
        System.out.println(numbers.higher(40));
        
        System.out.println(numbers.lower(35));
        System.out.println(numbers.contains(42));
        System.out.println(numbers.tailSet(30));
        System.out.println(numbers.headSet(30));

        System.out.println(numbers.subSet(20, 50));

        


    }

}
