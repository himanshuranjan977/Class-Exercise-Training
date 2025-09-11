public class Student {
    // Properties
    String schoolName;
    String name;
    int age;
    String gender;

    // Constructor
    public Student(String schoolName, String name, int age, String gender) {
        this.schoolName = schoolName;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("School Name: " + schoolName);
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("------------------------");
    }
}
