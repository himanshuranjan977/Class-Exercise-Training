package com.gl.collection.example;

import java.util.ArrayList;
import java.util.List;

public class Try3 {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        marks.add(10);
        marks.add(20);
        marks.add(30);
        marks.add(10);
        marks.add(20);
        System.out.println(marks);

        System.out.println( marks.indexOf(10)); //0
        System.out.println( marks.lastIndexOf(10)); //3

        System.out.println("Emptyness of the list : " +marks.isEmpty());// false
        System.out.println("No of Element / size of the list : " + marks.size());

        //marks.clear();// remove all the data in the list
        System.out.println("After Clear Emptyness of the list : " +marks.isEmpty());// true
        
        System.out.println("*********************");
        marks.forEach(x ->{
            System.out.println(x);
        });
    }

}
