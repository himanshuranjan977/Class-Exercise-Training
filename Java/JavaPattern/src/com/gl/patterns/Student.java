package src.com.gl.patterns;

public class Student implements  Cloneable {

    int age;
    String name;

    @SuppressWarnings("unused")
    Student(int age,String name) {
        this.name=name;
        this.age=age;
    }

    @SuppressWarnings("unused")
    void display(){
        System.out.println("Name : " + name + "Age : " +age);
    }
    @Override
    @SuppressWarnings({"CallToPrintStackTrace", "CloneDeclaresCloneNotSupported"})
    public Student clone(){
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;

        }
    }

    
}
