public class BankAccount {
    private double balance;
    private final String first;
    private final String last;
    private final int accNumber;

    BankAccount(String first, String last, int accNumber, double balance) {
        this.first = first;
        this.last = last;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    //getters
    String getName() {
        return this.first + " " + this.last;
    }

    int getAccNumber() {
        return this.accNumber;
    }

    double getBalance() {
        return this.balance;
    }

    String getFirst(){return this.first;}
    String getLast(){return this.last;}

    void BankAccountDetails() {
        System.out.println(this.first + "'s Balance is: " + this.balance + "$");
    }

    //setters
    void setBalance(double amount) {
        this.balance += amount;
    }
}
