public class Intern implements Human {

    @Override
    public void eat() {
        System.out.println("Breakfast - Lunch");
    }

    @Override
    public String tellYourName() {
        return "My Name (Intern)";
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
