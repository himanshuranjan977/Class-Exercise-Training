import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Office1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        ArrayList<Person1> persons = new ArrayList<>();

        persons.add(new Person1("Himanshu", new BankAccount1("Himanshu", "123456", "Savings", 10000), "Delhi", "9999999999"));
        persons.add(new Person1("Ravi", new BankAccount1("Ravi", "234567", "Current", 20000), "Mumbai", "8888888888"));
        persons.add(new Person1("Anjali", new BankAccount1("Anjali", "345678", "Savings", 15000), "Kolkata", "7777777777"));
        persons.add(new Person1("Neha", new BankAccount1("Neha", "456789", "Salary", 30000), "Chennai", "6666666666"));
        persons.add(new Person1("Amit", new BankAccount1("Amit", "567890", "Fixed", 50000), "Bangalore", "5555555555"));

        try {
            FileWriter writer = new FileWriter("Persons.txt");
            for (Person1 person : persons) {
                writer.write(person.toString());
                writer.write("\n--------------------------\n");
            }
            writer.close();
            System.out.println("Person details saved to Persons.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
       }
   }
}
