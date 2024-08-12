class BankAccount {
    private int accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(int accountNumber, double initialBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount " + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount " + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number:" + accountNumber);
        System.out.println("Account Holder:" + accountHolderName);
        System.out.println("Balance:" + balance);
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(12345, 1000.0, "Halil");
        BankAccount account2 = new BankAccount(54321, 500.0, "hayyat");

        account1.deposit(500.0);
        account2.withdraw(200.0);

        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }
}

