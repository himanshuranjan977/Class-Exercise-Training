package com.gl.collection.example;
// Wraped Class
import java.util.ArrayList;
import java.util.List;
public class Try6 {
    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(40);
        int t=0;
        

        for(int i:l){
            
            t+=i;
        }
        System.out.println("Total Marks : " + t);
        System.out.println("Average Marka : " + t/l.size());
    
    }


}
