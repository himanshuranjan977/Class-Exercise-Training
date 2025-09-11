package com.gl.collection.example;

import java.util.Map;
import java.util.TreeMap;

public class HashMap3 {
    public static void main(String[] args) {
        TreeMap<Integer, String> names =new TreeMap<>();

        names.put(1,"Kavin");
        names.put(2,"Ravi");
        names.put(4,"Ram");
        names.put(3,"Balu");
        names.put(4,"Santosh");
        System.out.println(names);

        for(Map.Entry<Integer ,String >temp :names.entrySet()){
            System.out.println(temp);
        }

        System.out.println("Assending order : " + names);
        System.out.println("Decending order : " + names.descendingKeySet());

        System.out.println("First Key : " +names.firstKey());
        System.out.println("Last Key : " +names.lastKey());

        System.out.println("First Value : " + names.get(names.firstKey()));
    }


}
