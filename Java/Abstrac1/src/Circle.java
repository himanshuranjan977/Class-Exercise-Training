public class Circle extends Shape{
    @Override
    public double area(int radius){
        return Math.PI * radius*radius;
    }

    @Override 
    public double volume(int radius){
        return (4.0 /3.0)*Math.PI * radius*radius*radius;
    }

    public static void main(String[] args) {
        Circle circle= new Circle();
        int r=5;
        System.out.println("Area of Circle With radius " + r + " is : " +circle.area(r));
        System.out.println("Volume of Sphare With radius "+ r + " is : " + circle.volume(r));
        }


}
