import java.util.ArrayList;
import java.util.Arrays;
public class Database {
    private static final ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    static InputHandler input = new InputHandler();

    static int findAccount(int AccountNumber){
        for (int i = 0; i < bankAccounts.size(); i++) {
            if(bankAccounts.get(i).getAccNumber()==AccountNumber){
                return i;
            }
        }
        return -1;
    }
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
            int accID = generateAccNumber();
            try {
                bankAccounts.add(new BankAccount(first, last, accID, 0));
                System.out.println("Added " + first + "!, your Bank Account number is : " + accID);
            } catch (Exception e) {
                System.out.println("Something went wrong please try again.");
            }
        }
    }
    static int generateAccNumber() {
        if (bankAccounts.isEmpty()) {
            return 2026000;
        } else {
            int lastID = bankAccounts.getLast().getAccNumber();
            return lastID + 1;
        }
    }
    ArrayList<BankAccount> getAccount(){
        return bankAccounts;
    }
    void deleteAccount(){
        System.out.print("Enter the account number you want deleted: ");
        int rawInput = input.returnInt();
        int index = findAccount(rawInput);
        String removedAccount = bankAccounts.get(index).getName();
        bankAccounts.remove(index);
        System.out.println("Removed "+removedAccount+"'s account.");
    }

}
