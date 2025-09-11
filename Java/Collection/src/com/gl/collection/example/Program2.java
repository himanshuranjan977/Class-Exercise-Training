package com.gl.collection.example;


import java.util.TreeSet;

public class Program2 {
    public static void main(String[] args) {
        TreeSet<Integer> ages = new TreeSet<>();
        ages.add(10);
        ages.add(12);
        ages.add(15);
        ages.add(16);
        ages.add(17);
        ages.add(18);
        ages.add(45);
        ages.add(56);
        ages.add(23);
        ages.add(19);

        System.out.println(ages);
        System.out.println(ages.descendingSet());
        for(int age : ages){
            if(age >18){
                System.out.println(age );
            }
           
        }

        

    
    }

}
