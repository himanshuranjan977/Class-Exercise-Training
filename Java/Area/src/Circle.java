public class Circle extends Shape {
    public double radius;
    public Circle(double radius){
        this.radius=radius;

    }
    @Override
    public double CalculateArea(){
        return  Math.PI * radius * radius;
    }

}
