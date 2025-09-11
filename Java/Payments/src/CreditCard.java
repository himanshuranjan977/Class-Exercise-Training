public class CreditCard extends Payment{
    public CreditCard(double amount){
        super(amount);
    }


    @Override
    public void pay(){
        System.out.println("Payments of " + amount +" done by using Credit Card");
    }

}
