import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Current balance: $" + account.getBalance());
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Current balance: $" + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                withdraw(amount);
            } else if (choice == 2) {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                deposit(amount);
            } else if (choice == 3) {
                checkBalance();
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

public class task3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // starting with an initial balance of $1000
        ATM atm = new ATM(account);
        atm.start();
    }
}
