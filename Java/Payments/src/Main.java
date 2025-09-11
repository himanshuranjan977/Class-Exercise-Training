public class Main {
    public static void main(String[] args) {
        Payment payments;

        
        payments= new CreditCard(500.00);
        payments.pay();

        payments= new UPI(1800.00);
        payments.pay();

        payments= new Netbankinf(2500.00);
        payments.pay();
    }

}
