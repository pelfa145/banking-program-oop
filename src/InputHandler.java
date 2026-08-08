import java.util.Scanner;
public class InputHandler {
    static Scanner input = new Scanner(System.in);

    int returnInt(){
        int Int = input.nextInt();
        input.nextLine();
        return Int;
    }
    String returnString(){
        return input.nextLine();
    }

}
