import java.util.ArrayList;

public class BankHandler {
    static Database data = new Database();
    static InputHandler input = new InputHandler();

    void makeInsertAcc() {
        String first = "";
        String last = "";
        boolean valid = false;
        while(!valid){
        System.out.print("Enter name: ");
        try{String inputs = input.returnString();
            String[] inputz = inputs.split(" ");
            ArrayList<String> nameParts = new ArrayList<>();
            for (String string : inputz){
                nameParts.add(string);
            }
        valid = true;
            if (nameParts.size() > 2) {
                first = nameParts.get(0) + " " + nameParts.get(1);
                last = nameParts.get(2);
            } else {
                first = nameParts.get(0);
                last = nameParts.get(1);
            }}
        catch (IndexOutOfBoundsException e){
            System.out.println("Retry only name please.");
            return;
        }}


        int accID = generateAccNumber();
        try{data.bankAccounts.add(new BankAccount(first, last, accID, 0));
            System.out.println("Added "+first+"!, your Bank Account number is : "+accID);
        }catch(Exception e){
            System.out.println("Something went wrong please try again.");
        }

    }

    static int generateAccNumber() {
        if (data.bankAccounts.isEmpty()) {
            return 2026000;
        } else {
            int lastID = data.bankAccounts.getLast().getAccNumber();
            return lastID + 1;
        }
    }
}
