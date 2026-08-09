import java.util.ArrayList;
public class Database {
    ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    int findAccount(int AccountNumber){

        for (int i = 0; i < bankAccounts.size(); i++) {
            if(bankAccounts.get(i).getAccNumber()==AccountNumber){
                return i;
            }
        }

        return 0;
    }
}
