import java.util.Scanner;

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void withdraw(double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.withdraw(amount);
            System.out.println("You have successfully withdrawn $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("You have successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

public class main {
    public static void main(String[] args) {
        // Initial balance can be set to any value for testing purposes
        BankAccount userAccount = new BankAccount(1000.00);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
