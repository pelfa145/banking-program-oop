import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;

public class BankHandler {
    static InputHandler input = new InputHandler();
    static BankAccount CurrOpenedAcc;
    static Database data = new Database();
    void openAcc() {

        System.out.print("Enter bank account number: ");
        int bankAccNum = input.returnInt();
        if (!data.getAccount().isEmpty()) {
            for (int i = 0; i < data.getAccount().size(); i++) {
            }
        } else {
            System.out.println("No bank accounts found. Please create one first");
            return;
        }

        int index = Database.findAccount(bankAccNum);

        if(index==-1){
            System.out.println("Bank account not found.");
            return;
        }

        int choice;
        BankAccount openedAccount = data.getAccount().get(index);
        CurrOpenedAcc = openedAccount;

        do {
            System.out.println("1. Deposit\n2. Withdraw\n3. Show Balance\n4. Return to menu");
            System.out.print("Enter your choice: ");
            choice = input.returnInt();
            switch (choice) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> openedAccount.BankAccountDetails();
                case 4 -> System.out.println("Okay");
                default -> System.out.println("Choose from options 1-4.");
            }
        } while (choice != 4);
    }


    private static void deposit(){
        System.out.print("Deposit an amount: ");
        double amount = input.returnInt();
        String convert = Double.toString(amount);
        String result = convert.replace("-", "");
        amount = Double.parseDouble(result);
        CurrOpenedAcc.setBalance(amount);

    }
    private static void withdraw(){
        System.out.print("Withdraw an amount: ");
        double amount = input.returnInt();
        if(amount > CurrOpenedAcc.getBalance()){
            System.out.println("Your withdrawal amount exceeds your balance.");
            return;
        }
        double newAmount = -amount;
        CurrOpenedAcc.setBalance(newAmount);

    }
}
