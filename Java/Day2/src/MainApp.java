public class MainApp {
    public static void main(String[] args) {
        // Create an object of Employee
        Employee e1 = new Employee();
        Employee e2 = new Employee();


        // Assign values to object
        e1.empId = 101;
        e1.empName = "Himanshu Ranjan";
        e1.age = 22;
        e1.salary = 45000.00;

        e2.empId = 102;
        e2.empName = "Ashutosh Ranjan";
        e2.age = 25;
        e2.salary = 55000.00;

        // Call method to display employee details
        e1.displayInfo();
        e2.displayInfo();

    }

}
