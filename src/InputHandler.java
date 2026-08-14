import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {
    static Scanner input = new Scanner(System.in);

    int returnInt() {
        int Int = input.nextInt();
        input.nextLine();
        return Int;
    }

    Double returnDouble(){
        Double dbl = input.nextDouble();
        input.nextLine();
        return dbl;
    }

    String returnString() {
        return input.nextLine();
    }

    void AskUserInput() {
        String first = "";
        String last = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter name: ");
            String inputs = returnString();
            String[] inputz = inputs.split("\\s+");
            try {

                ArrayList<String> nameParts = new ArrayList<>(Arrays.asList(inputz));

                if (nameParts.size() > 2) {
                    first = nameParts.get(0) + " " + nameParts.get(1);
                    last = nameParts.get(2);
                } else {
                    first = nameParts.get(0);
                    last = nameParts.get(1);
                }
                valid = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Retry only name please.");
            }

        }

        try {
            int accID = Database.generateAccNumber();
            Database.InsertAcc(first, last, accID);
            System.out.println("Added " + first + "!, your Bank Account number is : " + accID);
        } catch (Exception e) {
            System.out.println("Something went wrong please try again.");
        }
    }



    void DeleteUser(){
        boolean valid = false;
        while(!valid) {
            System.out.print("Enter the account number you want deleted: ");
            int rawInput = returnInt();
            int index = Database.findAccount(rawInput);
            if (index == -1) {
                System.out.println("Bank account not found.");
                continue;
            }
            valid = true;

            String removedAcc = Database.deleteAccount(index);
            System.out.println("Removed " + removedAcc + "'s account.");

        }
    }
}


class InputValidation {

    int ValidateAge(int age) {

        if (age <= 100 && age > 0) {

            return age;

        } else {

            System.out.println("Age Invalid");

        }

        return 0;
    }
}
