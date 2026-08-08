public class BankAccount {

    private double balance;
    private String first;
    private String last;
    private int accNumber;

    BankAccount(String first, String last, int accNumber, double balance){
        this.first = first;
        this.last = last;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    //getters
    String getName(){return this.first+ " " + this.last;}
    int getAccNumber(){return this.accNumber;}
    double getBalance(){return balance;}

}
