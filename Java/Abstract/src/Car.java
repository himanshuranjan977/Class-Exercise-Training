public class Car extends Vehicle {

    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped.");
    }

    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.displayWelcomeMessage();  // From Vehicle
        myCar.startEngine();            // Overridden in Car
        myCar.stopEngine();             // Overridden in Car
    }

}
