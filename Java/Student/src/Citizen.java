public class Citizen {
    public String name;
    public String gender;
    public Pan pan;
    public String bankNumber; // ✅ New field added

    public Citizen(String name, String gender, Pan pan, String bankNumber) {
        this.name = name;
        this.gender = gender;
        this.pan = pan;
        this.bankNumber = bankNumber;
    }

    public static void main(String[] args) {
        Pan p1 = new Pan("123", "Himanshu");
        Citizen c1 = new Citizen("Himanshu", "Male", p1, "111122223333");

        System.out.println("Name: " + c1.name);
        System.out.println("Gender: " + c1.gender);
        System.out.println("Pan Number: " + c1.pan.panNumber);
        System.out.println("Bank Number: " + c1.bankNumber);

        Citizen c2 = new Citizen("Ram", "Male", new Pan("456", "Ram"), "444455556666");

        System.out.println("\nName: " + c2.name);
        System.out.println("Gender: " + c2.gender);
        System.out.println("Pan Number: " + c2.pan.panNumber);
        System.out.println("Bank Number: " + c2.bankNumber);
    }
}
