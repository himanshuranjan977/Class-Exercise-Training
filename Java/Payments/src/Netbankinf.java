public class Netbankinf extends Payment{

    public Netbankinf(double amount){
        super(amount);
    }
    @Override

    public void pay(){
        System.out.println("Payments of " + amount +" done by using netbanking.");
    }

}
