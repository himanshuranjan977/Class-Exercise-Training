public class Courier {
    public static void main(String[] args) {
        Package<Integer, Double, Float> myPackage = new Package<>();

        myPackage.setHeight(10);      // Integer
        myPackage.setWidth(4.5);      // Double
        myPackage.setLength(3.0f);    // Float

        System.out.println("Height: " + myPackage.getHeight());
        System.out.println("Width: " + myPackage.getWidth());
        System.out.println("Length: " + myPackage.getLength());

        System.out.println("Volume of Package: " + myPackage.getVolume());
    }
}