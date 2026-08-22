import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    private static final ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    static int findAccount(int AccountNumber) {
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getAccNumber() == AccountNumber) {
                return i;
            }
        }
        return -1;
    }

    static void InsertAcc(String first, String last, int accID) {
        bankAccounts.add(new BankAccount(first, last, accID, 0));
    }
    static void InsertAcc(String first, String last, int accID, double balance) {
        bankAccounts.add(new BankAccount(first, last, accID, balance));
    }

    static int generateAccNumber() {
        if (bankAccounts.isEmpty()) {
            return 2026000;
        } else {
            int lastID = bankAccounts.getLast().getAccNumber();
            return lastID + 1;
        }
    }

    static ArrayList<BankAccount> getAccount() {
        return bankAccounts;
    }

    static String deleteAccount(int index) {
        String removedAccount = bankAccounts.get(index).getName();
        bankAccounts.remove(index);
        return removedAccount;
    }

}
