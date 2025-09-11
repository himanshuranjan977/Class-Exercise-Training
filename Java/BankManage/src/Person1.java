public class Person1<BankAccount> {

    String name;
    BankAccount bankAccount;  // One-to-One association
    String address;
    String mobile;

    public Person1(String name, BankAccount bankAccount, String address, String mobile) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.address = address;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nAddress: " + address +
               "\nMobile: " + mobile +
               "\nBank Details:\n" + bankAccount.toString() + "\n";
    }

}
