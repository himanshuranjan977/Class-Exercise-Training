package com.gl.mythread;

public class Luggage extends  Thread {
    int fromFloor;
    int toFloor;
    Elevator elevator;
    String luggageName;

    public Luggage(int fromFloor, int toFloor, Elevator elevator, String name) {
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
        this.elevator = elevator;
        this.luggageName = name;
    }

    @Override
    public void run() {
        elevator.move(fromFloor, toFloor, luggageName);
    }


}
