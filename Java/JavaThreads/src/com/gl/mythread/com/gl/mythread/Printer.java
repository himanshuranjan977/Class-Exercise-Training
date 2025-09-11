package com.gl.mythread;

public class Printer implements Runnable {
    int x,y;
    String name;
    public Printer(int x,int y,String name){
        this.x=x;
        this.y=y;
        this.name=name;
        
    }

    @Override
    public void run(){
        System.out.println("Started printing from " +x + " to " + y);
        for(int i=x;i<=y;i++){
            System.out.println(" prints: " +i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(" was interrupted");
            }
        }
        System.out.println(" Finished printing. \n");
    }

    


}
