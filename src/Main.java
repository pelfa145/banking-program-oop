public class Main {
    static InputHandler input = new InputHandler();
    static BankHandler bankHandler = new BankHandler();
    public static void main(String[] args) {
//        Bank Account System
//
//                BankAccount
//        deposit / withdraw / balance
//        private fields
//                validation
//        constructors
//
//        Gap filled: "What belongs inside a class?"
        //start here →
        showMenu();

    }
    static void showMenu(){
        int choice = -1;
        while(choice != 3) {
            System.out.print("BANKING PROGRAM OOP\n\n1. Make Account\n2. Open Account\n3. Exit\n");
            System.out.print("Input your choice: ");
            choice = input.returnInt();
            switch (choice) {
                case 1 -> bankHandler.makeInsertAcc();
                case 2 -> {}
                case 3 -> System.out.print("Bye.");
            }
        }
    }
}
