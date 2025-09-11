package com.gl.collection.example;

import java.util.HashSet;

//1. There is not Duplicate
//2. Insertion order is not maintained [ np specific order]
public class HasSet1 {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        names.add("jack");
        names.add("jack");
        names.add("King");
        names.add("Queen");
        names.add(null);
        names.add(null);
        names.add("qeen");

        System.out.println(names);
        names.remove("jack");
        System.out.println("King Exicts or not : " + names.contains("King"));
        System.out.println(names.size());
        names.clear();

    }

}
