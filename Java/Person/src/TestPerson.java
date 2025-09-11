public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person();

        try {
            p1.setName("Himanshu Ranjan");
            p1.setAge(25); // This will throw InvalidAge
            p1.setGender("Male"); // This will throw InvalidGender
            p1.printDetails();
        } catch (InvalidAge e) {
            System.out.println("InvalidAge Exception: " + e.getMessage());
        } catch (InvalidGender e) {
            System.out.println("InvalidGender Exception: " + e.getMessage());
        }
    }
}
