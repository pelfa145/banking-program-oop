public class Main {
    static InputHandler input = new InputHandler();
    static BankHandler bankHandler = new BankHandler();
    static Database data = new Database();
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
        while(choice != 4) {
            System.out.print("BANKING PROGRAM OOP\n\n1. Make Account\n2. Open Account\n3. Delete account\n4. Exit\n");
            System.out.print("Input your choice: ");
            choice = input.returnInt();
            switch (choice) {
                case 1 -> data.makeInsertAcc();
                case 2 -> bankHandler.openAcc();
                case 3 -> data.deleteAccount();
                case 4 -> System.out.print("Bye.");
                default -> System.out.println("Choose through options 1-4.");
            }
        }
    }
}
