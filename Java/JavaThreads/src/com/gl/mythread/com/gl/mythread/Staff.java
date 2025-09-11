package com.gl.mythread;

public class Staff {
    public static void main(String[] args) {
        
    
    Printer doc1 =new Printer(10, 20, "Document1");
    Printer doc2 =new Printer(20, 50, "Document2");
    Printer doc3 =new Printer(10, 50, "Document1");

    Thread t1 =new Thread(doc1);
    Thread t2 =new Thread(doc2);
    Thread t3 =new Thread(doc3);

    t1.start();
    t2.start();
    t3.start();
    }


}
