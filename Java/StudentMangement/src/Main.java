public class Main {
    public static void main(String[] args) {
        // Using different constructors
        Studet s1 = new Studet(); // default
        Studet s2 = new Studet("Ananya", 16); // name, age
        Studet s3 = new Studet("Himanshu", 18, 95, 110, -10); // full info with invalid marks

        // Setting values manually
        s1.setName("Rahul");
        s1.setAge(17);
        s1.setMark1(85);
        s1.setMark2(90);
        s1.setMark3(75);

        // Printing details
        s1.printDetails();
        s2.printDetails();
        s3.printDetails();
    }


}
