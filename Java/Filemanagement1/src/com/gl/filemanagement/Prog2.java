package com.gl.filemanagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


class Fruit{
    String name;
    int price;
    int unit;

    public Fruit(String name , int price , int unit){
        this.name=name;
        this.price=price;
        this.unit=unit;
    }
    public int getTotal(){
        return price * unit;

    }
}

public class Prog2 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", 100, 10));
        fruits.add(new Fruit("Banana", 20, 10));
        fruits.add(new Fruit("Mango", 100, 10));
        fruits.add(new Fruit("Papaya", 50, 20));

        try {
            FileWriter writer = new FileWriter("FruitsTotal.txt");
            for(Fruit f : fruits){
                writer.write(f.name + " - " + f.getTotal()+ "\n");
            }
            writer.close();
            System.out.println("Fruits details to FruitTotal.txt Successfully");
        } catch (IOException e) {
            System.out.println("An error occured while writing the file. ");
        }
        
    }

}
