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
        double balanceNew = amount + this.balance;
        String convert = Double.toString(balanceNew);
        String result = convert.replace("-", "");
        balanceNew = Double.parseDouble(result);
        this.balance += balanceNew;
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
