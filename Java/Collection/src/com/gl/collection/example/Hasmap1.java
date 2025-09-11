package com.gl.collection.example;

import java.util.HashMap;
import java.util.LinkedList;

public class Hasmap1 {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        LinkedList<Integer> ages = new LinkedList<>();
        HashMap<String,Integer> marks =new HashMap<>();

        marks.put("English",95);
        marks.put("Maths",75);
        marks.put("Science",85);
        marks.put("Maths",90);

        System.out.println(marks);
        System.out.println("Science Marks : " +marks.get("Science"));
        System.out.println("List of Subjects or Key we have : " + marks.keySet());
        System.out.println("Check whether maths is given : " +marks.containsKey("Maths"));
        System.out.println("Check whether mats is given : " +marks.containsKey("Computer Science"));
        marks.remove("English");
        System.out.println(marks);
    }  

}
    