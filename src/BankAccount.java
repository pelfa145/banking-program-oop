public class BankAccount {
static Database data = new Database();
static InputHandler input = new InputHandler();
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
    double getBalance(){return this.balance;}
    void BankAccountDetails(){
        System.out.println(this.first+"'s Balance is: "+this.balance+"$");
    }
    //setters
    void deposit(){
        System.out.print("Deposit an amount: ");
        double amount = input.returnInt();
        String convert = Double.toString(amount);
        String result = convert.replace("-", "");
        amount = Double.parseDouble(result);
        this.balance += amount;
    }
    void withdraw(){
        System.out.print("Withdraw an amount: ");
        double amount = input.returnInt();
        if(amount > this.balance){
            System.out.println("Your withdrawal amount exceeds your balance.");
            return;
        }
        this.balance -= amount;
    }
}
