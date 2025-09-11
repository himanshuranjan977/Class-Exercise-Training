public class CarCustomer {
    public static void main(String[] args) {
        //Car car1 = new Car();
       /*  car1.model = "Tesla";
        car1.color = "Black";
        car1.price = 8000000;*/

        // Create car object 2 and assign values manually
        /*Car car2 = new Car();
        car2.model = "Tesla";
        car2.color = "Blue";
        car2.price = 6000000;*/

        Car car1 = new Car("Model S", "Red", 9500000);
        Car car2 = new Car("Model 3", "White", 5500000);

        // Displaying their details
        car1.displayDetails();
        car2.displayDetails();
    }

}
