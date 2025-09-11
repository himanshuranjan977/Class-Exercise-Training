import java.util.Arrays;

public class Student {
    String name;
    int age;
    String gender;
    int[] marks = new int[5];


    

    // Constructor
    public Student(String name, int age, String gender, int[] marks) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.marks = marks;
    }

    // Method to calculate total marks
    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate average marks
    public double getAverageMarks() {
        return getTotalMarks() / 5.0;
    }

    // Method to print student details
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.printf("Average Marks: %.2f\n", getAverageMarks());
        System.out.println("-------------------------");
    }
}
