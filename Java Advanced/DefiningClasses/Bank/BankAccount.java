package DefiningClasses.Bank;

public class BankAccount {
    private static final double DEFAULT_RATE = 0.02;

    private static double interestRate = DEFAULT_RATE;
    private static int accountsCount = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = accountsCount;
        accountsCount++;
        this.balance = 0;
    }

    public double getInterestRate(int years) {
        return years * interestRate * this.balance;
    }

    public static void setInterestRate(double interestRate) {

        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
