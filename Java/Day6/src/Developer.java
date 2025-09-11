public class Developer extends Employee {
    public int experience;
    public double salary;

    // Constructor
    public Developer(String name, int empNo, String gender, int experience, double salary) {
        super(name, empNo, gender); // call Employee constructor
        this.experience = experience;
        this.salary =salary;
    }
}
