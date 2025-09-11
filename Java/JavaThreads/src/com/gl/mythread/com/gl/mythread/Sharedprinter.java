package com.gl.mythread;

public class Sharedprinter {

    //synchronized - shared resource
    //any thread - stand in queue
    

    public synchronized void printmyDocument(String content,int pageCount){
       
        for(int i=1;i<pageCount;i++){
            System.out.println(Thread.currentThread().getName());
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
