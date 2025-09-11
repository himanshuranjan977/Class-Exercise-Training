package com.gl.collection.example;

import java.util.TreeSet;
public class TreeSet1 {
    public static void main(String[] args) {
        TreeSet<String> names =new TreeSet<>();
        names.add("Zaheer");
        names.add("Rahul");
        names.add("Ashok");
        names.add("bala");
        names.add("Sachin");
        names.add("Ashok");
        names.add("Bala");

        System.out.println(names);
        System.out.println(names.first());
        System.out.println(names.last());
        System.out.println(names.size());
        System.out.println(names.contains("Sachin"));
        System.out.println(names.isEmpty());
        System.out.println(names.higher("Rahul"));
        System.out.println(names.lower("Rahul"));
        System.out.println(names.lower("Ashok"));
        System.out.println(names.descendingSet());






    }

}
