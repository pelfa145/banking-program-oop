import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    private static final ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    static InputHandler input = new InputHandler();

    int findAccount(int AccountNumber) {
        for (int i = 0; i < bankAccounts.size(); i++) {
                return i;
        }
        return -1;
    }

    void InsertAcc(String first, String last, int accID) {
        bankAccounts.add(new BankAccount(first, last, accID, 0));
    }

    int generateAccNumber() {
        if (bankAccounts.isEmpty()) {
            return 2026000;
        } else {
            int lastID = bankAccounts.getLast().getAccNumber();
            return lastID + 1;
        }
    }

    ArrayList<BankAccount> getAccount() {
        return bankAccounts;
    }

    String deleteAccount(int index) {
        String removedAccount = bankAccounts.get(index).getName();
        bankAccounts.remove(index);
        return removedAccount;
    }

}
