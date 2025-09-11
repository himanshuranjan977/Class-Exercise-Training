package com.gl.collection.example;

import java.util.HashMap;

public class HasMap2 {
    public static void main(String[] args) {
        /*HashMap<Integer,String> numberSystem =new HashMap<>();
        numberSystem.put(1,"One");
        numberSystem.put(2,"Two");
        numberSystem.put(44,"Fourty Four");
        numberSystem.put(24,"Twenty Five");
        System.out.println(numberSystem);*/
        HashMap<Integer , Student> students =new HashMap<>();
        students.put(1, new Student("Jack",10));
        students.put(2, new Student("Jill",10));
        students.put(3, new Student("John",10));

        for(Integer key : students.keySet()){
            System.out.println(students.get(key).name);
        }
        System.out.println("Size of the map : " +students.size());

    }

}
