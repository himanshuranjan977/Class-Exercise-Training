package com.gl.collection.example;

import java.util.ArrayList;
import java.util.List;

public class Try2 {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        marks.add(10);
        marks.add(20);
        marks.add(30);
        System.out.println(marks);

        marks.add(1,40);
        System.out.println(marks);
        System.out.println(marks.get(1));

        marks.set(0,100);
        System.out.println(marks.get(0));

        marks.remove(0);
        System.out.println(marks);
    }

}
