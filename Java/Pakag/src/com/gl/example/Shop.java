package com.gl.example;

// Make sure Shop and Fruit are in the same package

public class Shop {
    public static void main(String[] args) {
        Fruit apple = new Fruit(); // No import needed since same package
        apple.name = "Apple";
        apple.color = "Red";

        Fruit.Seed appleSeed = apple.new Seed(); // Inner class
        appleSeed.count = 4;
        appleSeed.color = "Brown";

        apple.printDetails();
        appleSeed.printDetails();
    }
}
