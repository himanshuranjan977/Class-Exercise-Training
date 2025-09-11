public class ProductDemo {

    public static void main(String[] args) {
        // Example 1: Integer price, Double discount, Integer unit
        Product<Integer, Double, Integer> apple = new Product<>("Apple", 100, 10.5, 5);
        System.out.println("Product: " + apple.getName());
        System.out.println("Total: " + apple.getTotal());

        // Example 2: Double price, Integer discount, Float unit
        Product<Double, Integer, Float> rice = new Product<>("Rice", 80.75, 5, 2.0f);
        System.out.println("Product: " + rice.getName());
        System.out.println("Total: " + rice.getTotal());

    }

}
