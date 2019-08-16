package DefiningClasses.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String[] data = sc.nextLine().split("\\s+");
        String command = data[0];
        String result = "";

        while (!command.equals("End")) {
            switch (command) {
                case "Create":
                    BankAccount acc = new BankAccount();
                    accounts.put(acc.getId(), acc);
                    result = "Account ID" + acc.getId() + " created";
                    break;
                case "Deposit":
                    int accID = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);

                    BankAccount currentAcc = accounts.get(accID);
                    if (currentAcc == null) {
                        result = "Account does not exist";
                        break;
                    }
                    currentAcc.deposit(amount);
                    accounts.put(accID, currentAcc);
                    result = String.format("Deposited %.0f to ID%d", amount, accID);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int accID2 = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    BankAccount currentAcc2 = accounts.get(accID2);
                    if (currentAcc2 == null) {
                        result = "Account does not exist";
                        break;
                    }
                    double currentRate = currentAcc2.getInterestRate(years);
                    result = String.format("%.2f", currentRate);
                    break;
            }
            if (!result.isEmpty()) {
                System.out.println(result);
                result = "";
            }
            data = sc.nextLine().split("\\s+");
            command = data[0];
        }
    }

}
