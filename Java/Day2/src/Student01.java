public class Student01 {
    public static void main(String[] args) {
        // Create student object using constructor
        Student s1 = new Student("DAV Public School", "Himanshu Ranjan", 18, "Male");
        Student s2 = new Student("Kendriya Vidyalaya", "Anjali Sharma", 17, "Female");

        // Display student details
        s1.displayInfo();
        s2.displayInfo();
    }


}
