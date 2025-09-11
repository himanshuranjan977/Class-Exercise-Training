package com.gl.mythread;

public class Manager {
    public static void main(String[] args) {
        Theatre movie1 = new Theatre("Inception", 60);
        Theatre movie2 = new Theatre("Interstellar", 70);
        Theatre movie3 = new Theatre("Dune", 55);

        movie1.start();
        movie2.start();
        movie3.start();

    }

}
