package com.gl.mythread;

public class Communication2 extends Thread{
    String mode;      // e.g., whatsapp, sms, mail
    String message;
    int timeTaken;

    Communication2(String mode, String message, int timeTaken) {
        this.mode = mode;
        this.message = message;
        this.timeTaken = timeTaken;
    }

    @Override
    public void run() {
        int count = 0;
        while (count <= timeTaken) {
            System.out.println("Sending message via " + mode + ": " + message);
            count++;
            
        }
    }

    


}
