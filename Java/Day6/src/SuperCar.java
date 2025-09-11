public class SuperCar extends Car {

    public String fuelType;

    // Constructor
    public SuperCar(String fuelType, String color, String type, int wheelCount) {
        super(color, type, wheelCount); // Call constructor of Car
        this.fuelType = fuelType;       // Set fuelType correctly
    }

    public static void main(String[] args) {
        SuperCar sc1 = new SuperCar("Petrol", "Red", "SUV", 4);

        System.out.println("SuperCar Details:");
        System.out.println("Color: " + sc1.color);
        System.out.println("Type: " + sc1.type);
        System.out.println("Wheels: " + sc1.wheelCount);
        System.out.println("Fuel: " + sc1.fuelType);

        sc1.start();
        sc1.moveForward();
        sc1.moveBackward();
    }
}
