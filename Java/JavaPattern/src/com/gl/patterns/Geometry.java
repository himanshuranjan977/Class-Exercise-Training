package src.com.gl.patterns;

public class Geometry {
    public static void main(String[] args) {
        ShapeCreator shapeCreator =new ShapeCreator();
        Shape circle =shapeCreator.getShape("Circle");
        Shape rectangle =shapeCreator.getShape("Rectangle");
        
        Shape triangle =shapeCreator.getShape("triangle");
        circle.draw();
        rectangle.draw();
        triangle.draw();

    }

}
