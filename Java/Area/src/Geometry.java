

public class Geometry {
    public static void main(String[] args) {
        Shape c= new Circle(5);
        Shape r = new Rectangle(4, 6);
        Shape t = new Triangle(3,8);

        System.out.println("Area of Circle : " +c.CalculateArea());
        System.out.println("Area of Rectangle : " +r.CalculateArea());
        System.out.println("Area of Triangle : " +t.CalculateArea());
    }

}
