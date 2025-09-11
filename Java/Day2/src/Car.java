public class Car {
    // Properties
    String model;
    String color;
    double price;

    // Constructor
    public Car(String model, String color, double price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    // Method to display car info
    public void displayDetails() {
        System.out.println("Tesla Car Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
        System.out.println("--------------------------");
    }
}
