package src.com.gl.patterns;

public class ShapeCreator {
    public Shape getShape(String shapeType){
        if(shapeType==null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("Circle")){
            return  new Circle();
        }
        else if (shapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("TRIANGLE")){
            return new Triangle();
        }
        else{
            return null;
        }
    }

}
