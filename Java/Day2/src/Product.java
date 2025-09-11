public class Product {
    // Properties
    String name;
    double price;
    int unit;

    // Constructor
    /*public Product(String name, double price, int unit) {
        this.name = name;
        this.price = price;
        this.unit = unit;
    }*/

    // Method to calculate and print total
    public void printTotal() {
        double total = price * unit;
        System.out.println("Product Name: " + name);
        System.out.println("Unit Price: " + price);
        System.out.println("Quantity: " + unit);
        System.out.println("Total Price: " + total);
        System.out.println("--------------------------");
    }
}
