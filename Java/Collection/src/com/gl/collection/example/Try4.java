package com.gl.collection.example;

import java.util.ArrayList;
import java.util.List;

public class Try4 {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        marks.add(10);
        marks.add(20);
        marks.add(30);
        marks.add(20);

        marks.remove(Integer.valueOf(20));
        System.out.println(marks);
    }

}

