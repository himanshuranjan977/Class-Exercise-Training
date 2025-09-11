package com.gl.mythread;
public class launch {
    public static void main(String[] args) {
        /*Counter rocketlaunch = new Counter("Rocket", 10);
        Counter shipLaunch = new Counter("Ship", 20);*/
        Thread rocketlaunch =new Thread(new Counter("Rocket", 10));
        Thread shipLaunch =new Thread(new Counter("Ship", 20));

        //rocketlaunch.run();
        //shipLaunch.run();
        rocketlaunch.start();
        shipLaunch.start();
    }


}
