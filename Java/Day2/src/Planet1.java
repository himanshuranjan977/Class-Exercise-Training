public class Planet1 {
    public static void main(String[] args) {
        Planet earth = new Planet();

        // Set planet properties using setters
        earth.setName("Earth");
        earth.setDiameter(12742);
        earth.setDistance(149.6);

        // Print planet details
        earth.printDetails();
    }


}
