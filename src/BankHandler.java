import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;

public class BankHandler {
    static Database data = new Database();
    static InputHandler input = new InputHandler();

    static BankAccount CurrOpenedAcc;

    void makeInsertAcc() {
        String first = "";
        String last = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter name: ");
            try {
                String inputs = input.returnString();
                String[] inputz = inputs.split(" ");
                ArrayList<String> nameParts = new ArrayList<>(Arrays.asList(inputz));
                valid = true;
                if (nameParts.size() > 2) {
                    first = nameParts.get(0) + " " + nameParts.get(1);
                    last = nameParts.get(2);
                } else {
                    first = nameParts.get(0);
                    last = nameParts.get(1);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Retry only name please.");
                return;
            }
        }


        int accID = generateAccNumber();
        try {
            data.bankAccounts.add(new BankAccount(first, last, accID, 0));
            System.out.println("Added " + first + "!, your Bank Account number is : " + accID);
        } catch (Exception e) {
            System.out.println("Something went wrong please try again.");
        }

    }

    void openAcc() {
        System.out.print("Enter bank account number: ");
        int bankAccNum = input.returnInt();
        if (!data.bankAccounts.isEmpty()) {
            for (int i = 0; i < data.bankAccounts.size(); i++) {
                System.out.println(data.bankAccounts.get(i).getAccNumber());
            }
        } else {
            System.out.println("No bank accounts found. Please create one first");
            return;
        }
        int index = data.findAccount(bankAccNum);
        if(index==-1){
            System.out.println("Bank account not found.");
            return;
        }
        int choice;
        BankAccount openedAccount = data.bankAccounts.get(index);
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
            }
        } while (choice != 4);
    }

    static int generateAccNumber() {
        if (data.bankAccounts.isEmpty()) {
            return 2026000;
        } else {
            int lastID = data.bankAccounts.getLast().getAccNumber();
            return lastID + 1;
        }
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
