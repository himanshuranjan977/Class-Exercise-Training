package com.gl.collection.example;
import java.util.ArrayList;
import java.util.List;

public class Try5 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("orange");
        fruits.add("Watermelon");
        fruits.remove(1);
        fruits.remove("Apple");

        //List <Integer> ages = new ArrayList<>();
        //List<Integer> units = new ArrayList<>();
        //List<Integer> heights =new ArrayList<>();
        //List<Long> mobilenumbers =new ArrayList<>();
        //List<Boolean> nri = new ArrayList<>();

        // naming conversition - pulural form 
        fruits.forEach(fruit -> {
            System.out.println(fruit);

        });
    }

}
