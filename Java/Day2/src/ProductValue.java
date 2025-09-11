public class ProductValue {
     public static void main(String[] args) {
        // Create product objects
        /*Product p1 = new Product("Pen", 10.5, 3);
        Product p2 = new Product("Notebook", 45.0, 2);
        Product p3 = new Product("Pencil", 5.0, 5);*/
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        p1.name ="Pen";
        p1.price= 10.5;
        p1.unit= 3;

        p2.name="Notebook";
        p2.price=45.0;
        p2.unit =2;

        p3.name="Pencil";
        p3.price=5.0;
        p3.unit=5;

        // Display total for each product
        p1.printTotal();
        p2.printTotal();
        p3.printTotal();
    }


}
