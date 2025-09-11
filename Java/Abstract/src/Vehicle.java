public abstract class Vehicle {

    // Abstract methods
    public abstract void startEngine();
    public abstract void stopEngine();

    // Concrete (regular) method
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Vehicle System!");
    }
}
