public class Fruit {

    
    String name;
    double price;
    String colour;
    final static String location = "Fruit Market";

    public Fruit(String name, double price, String colour) {
        this.name = name;
        this.price = price;
        this.colour = colour;
    }

    public void printDetails() {
        System.out.println("----- Fruit Details -----");
        System.out.println("Name     : " + name);
        System.out.println("Price    : " + price);
        System.out.println("Colour   : " + colour);
        System.out.println("Location : " + location);
        System.out.println("--------------------------");
    }


}
