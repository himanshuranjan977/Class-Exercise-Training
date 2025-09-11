public class BasicCalc implements Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return 0; // Or throw an exception
        }
        return a/b;
    }
    public static void main(String[] args) {
        BasicCalc calc = new BasicCalc();

        System.out.println("Addition: " + calc.add(10, 5));
        System.out.println("Division: " + calc.divide(10, 2));
        System.out.println("Division by zero test: " + calc.divide(10, 0));
    }




}