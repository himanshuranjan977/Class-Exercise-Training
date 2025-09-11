public class BankAccount1 {
    String accountName;
    String accountNumber;
    String accountType;
    double balance;

    public BankAccount1(String accountName,String accountNumber,String accountType, double  balance){
        this.accountName=accountName;
        this.accountNumber=accountNumber;
        this.accountType=accountType;
        this.balance=balance;


    }
    @Override
    public String toString(){
        return "Account name: " +accountName + "\nAccount Number: "+ accountNumber + "\nAccount Type: " +accountType+ "\nbalance: " + balance;
    }

}
