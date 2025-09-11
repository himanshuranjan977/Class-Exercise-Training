public class UPI extends Payment{

    public UPI(double amount){
        super(amount);
    }

    @Override
    public void pay(){
        System.out.println("Payments of " + amount +" done using UPI. ");

}
}
