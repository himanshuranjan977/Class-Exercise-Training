package com.gl.collection.example;

import java.util.LinkedList;
public class LL2 {
    public static void main(String[] args) {
        LinkedList<String> animals =new LinkedList<>();
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Dog");

        System.out.println(animals.size());// no. of counts in the LL
        //animal.clear(); //remove all the elements in the LL
        animals.addLast("Elephant"); // [lion, Tiger,Dog, Elephant]
        animals.addFirst("Cow");//[Cow, Lion, Tiger, Dog, Elephant]
        System.out.println(animals);
        
        //animal.remove();
        animals.removeFirst();
        System.out.println(animals);

        animals.removeLast();
        System.out.println(animals);
        
        //to retrive the data from LL
        System.out.println(animals.getFirst());
        System.out.println(animals.getLast());
        System.out.println(animals.get(1));

    }



}
