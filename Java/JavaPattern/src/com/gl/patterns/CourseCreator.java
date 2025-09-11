package src.com.gl.patterns;

public class CourseCreator {
    public static void main(String[] args) {
        Course c1 =new Course.CourseBuilder().setName("Java").build();
        c1.display();
        Course c2 =new Course.CourseBuilder().setName("Python").setTrainer("Sundar").build();
        c2.display();
        Course c3 =new Course.CourseBuilder().setFee(500).setTrainer("Sundar").build();
        c3.display();
        
        

    }


}
