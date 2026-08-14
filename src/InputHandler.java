import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {
    static Scanner input = new Scanner(System.in);
    static Database data = new Database();

    int returnInt() {
        int Int = input.nextInt();
        input.nextLine();
        return Int;
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
            int accID = data.generateAccNumber();
            data.InsertAcc(first, last, accID);
            System.out.println("Added " + first + "!, your Bank Account number is : " + accID);
        } catch (Exception e) {
            System.out.println("Something went wrong please try again.");
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
