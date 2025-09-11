public class Shape {
    public static void main(String[] args) {
        Square<Integer> s1 =new Square<>();
        s1.setSide(10);
        System.out.println("Area of Square : " + s1.findArea());
        Square<Double> s2 =new Square<>();
        s2.setSide(24.56);
        System.out.println("Area of Square : " + s2.findArea());


    }

}
