import java.util.Arrays;

public class BankHandler {
    static Database data = new Database();
    static InputHandler input = new InputHandler();

    void makeInsertAcc() {
        System.out.print("Enter name: ");
        String[] nameParts = input.returnString().split(" ");
        System.out.println(Arrays.toString(nameParts));
        String first;
        String last;
        if (nameParts.length > 2) {
            first = nameParts[0] + " " + nameParts[1];
            last = nameParts[2];
            //outputs index out of bounds exception. fix please
            System.out.println(first+last);
        } else {
            first = nameParts[0];
            last = nameParts[1];
        }
        int accID = generateAccNumber();
        try{data.bankAccounts.add(new BankAccount(first, last, accID, 0));
            System.out.println("Added "+first+"!, your Bank Account number is : "+accID);
        }catch(Exception e){
            System.out.println("Something went wrong please try again.");
        }

    }

    static int generateAccNumber() {
        if ((data.bankAccounts.get(0).getAccNumber()) == 0) {
            return 2026000;
        } else {
            int lastID = data.bankAccounts.getLast().getAccNumber();
            return lastID + 1;
        }
    }
}
