public class Car extends Automobile {

    public String color;

    // Constructor
    public Car(String color, String type, int wheelCount) {
        super(type, wheelCount);     // Call parent constructor
        this.color = color;          // Assign color
    }
    public void switchOnAc(){
        System.out.println("AC is ON");
    }

    public static void main(String[] args) {
        Car c1 = new Car("Red", "SUV", 4);

        System.out.println("Car Details:");
        System.out.println("Color: " + c1.color);
        System.out.println("Type: " + c1.type);
        System.out.println("Wheels: " + c1.wheelCount);
        

        c1.switchOnAc();
        c1.start();
        c1.moveForward();
        c1.moveBackward();
    }
}
