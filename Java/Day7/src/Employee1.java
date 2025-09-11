public class Employee1 implements Human, Worker {

    @Override
    public void eat() {
        System.out.println("Breakfast - Lunch - Dinner");
    }

    @Override
    public String tellYourName() {
        return "My Name (Employee)";
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public void makeEntry() {
        System.out.println("I make Attendance Entry");
    }
    public static void main(String[] args) {

        Employee1 e = new Employee1();
        e.eat();
        System.out.println(e.tellYourName());
        System.out.println(e.add(10, 20));
        e.makeEntry();

        System.out.println("-----------------------");

        Intern i = new Intern();
        i.eat();
        System.out.println(i.tellYourName());
        System.out.println(i.add(5, 7));
    }

}
