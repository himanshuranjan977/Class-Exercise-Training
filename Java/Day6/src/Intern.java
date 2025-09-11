public class Intern extends Developer {
    public String education;

    // Constructor
    public Intern(String name, int empNo, String gender, int experience, double salary, String education) {
        super(name, empNo, gender, experience, salary); // Call Developer constructor
        this.education = education;
    }

    // Display Intern Info
    public void displayInfo() {
        System.out.println("Intern Details:");
        System.out.println("Name: " + name);
        System.out.println("Emp No: " + empNo);
        System.out.println("Gender: " + gender);
        System.out.println("Experience: " + experience + " years");
        System.out.println("Salary: " + salary);
        System.out.println("Education: " + education);
    }

    public static void main(String[] args) {
        Intern i1 = new Intern("Himanshu", 101, "Male", 0, 10000.0, "B.Tech in ECE");
        i1.displayInfo();
    }
}
