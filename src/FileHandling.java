import java.io.*;
public class FileHandling {

    static FileWriter fileWriter;

    static void saveFile(){
        try{
            fileWriter = new FileWriter("bankAccounts.txt");
            for (int i = 0; i < Database.getAccount().size(); i++) {
                BankAccount account = Database.getAccount().get(i);
                fileWriter.write(account.getAccNumber()+"|"+account.getFirst()+"|"+account.getLast()+"|"+ account.getBalance());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void loadFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("bankAccounts.txt"))){
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length < 4) {
                    System.err.println("Skipping incomplete record: " + line);
                    continue;
                }

                try {
                    int accNum = Integer.parseInt(data[0].trim());
                    String first = data[1].trim();
                    String last = data[2].trim();
                    double balance = Double.parseDouble(data[3].trim());

                    Database.InsertAcc(first, last, accNum, balance);

                } catch (NumberFormatException e) {
                    System.err.println("Skipping record due to invalid numeric data: " + line);
                }
            }
        } catch (IOException e) {
            try{
                fileWriter = new FileWriter("bankAccounts.txt");
                fileWriter.write("Bank Accounts");
                fileWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
