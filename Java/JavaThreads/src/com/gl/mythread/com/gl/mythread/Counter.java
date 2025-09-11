package com.gl.mythread;

public class Counter  implements Runnable{

    
    String name;
    int max;

    public Counter(String name,int max) {
        this.name=name;
        this.max=max;
    }
    
    @SuppressWarnings("override")
    public void run(){
        try{
        int count =1;
        while(count<=this.max){
            System.out.println("Count is " +count + "( " +name+ " )");
            if(count==5){
                System.out.println(name+ " thread is going to sleep for 5 seconds");
                Thread.sleep(5000);//1000 milli  seconds = 1 sec
            }
            count++;
        }
    }catch(InterruptedException e){
        System.out.println("Thread " +name + "interrupted");

    }
    }



}
