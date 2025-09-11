public class Calculator {
    //Attributes
    int num1;
    int num2;

    //Controctors
    public Calculator(int num1, int num2){
        this.num1 =num1;
        this.num2 =num2;

    }

    //functions
    public void add(){
        int sum = num1+num2;
        System.out.println("Sum : " +sum);
    }
    
    //void - i am not returning anything
    //we must send the output to the CalculatorUser class
    //We must not print the output inside this function
    public int multiply(){
        int product = num1*num2;
        System.out.println("diff : " + product);
        return product;
    }

    public int Subtract(){
        int sub = num1- num2;
        System.out.println("Sum : " +sub);
        return sub;
    }
    public void findBiggest() {
        if (num1 > num2) {
            System.out.println(num1 + " is bigger than " + num2);
        } else if (num2 > num1) {
            System.out.println(num2 + " is bigger than " + num1);
        } else {
            System.out.println("Both numbers are equal: " + num1);
        }

    }

}
