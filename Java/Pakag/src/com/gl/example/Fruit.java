package com.gl.example;

public class Fruit {
    public String name;
    public String color;

    public class Seed {
        public int count;
        public String color;

        public void printDetails() {
            System.out.println("I have " + count + " seeds of color " + color);
        }
    }

    public void printDetails() {
        System.out.println("Fruit: " + name + ", Color: " +color);
    }
}