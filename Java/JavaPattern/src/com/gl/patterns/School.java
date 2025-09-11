package src.com.gl.patterns;



public class School {
    public static void main(String[] args) {
        /*Principal p1 =Principal.getInstance("Ashok", "BE");
        System.out.println("Name : " + p1.name + " education " + p1.education);

        Principal p2 =Principal.getInstance("Priya", "ME");
        System.out.println("Name : " + p2.name + " education " + p2.education);
        */
        Student defaultStudent =new Student(5, "Student name");
        Student s1 =new Student(10, "Kumar");
        Student s2 =defaultStudent.clone();
        Student s3 =defaultStudent.clone();
        Student s4 = defaultStudent;
        s1.display();
        s3.display();
        s4.display();
        s2.display();


        
        }

}
