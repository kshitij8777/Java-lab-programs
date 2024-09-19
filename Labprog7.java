package Lab7;
import java.util.Scanner;

class SingletonBank {
    private static SingletonBank instance;
    private double balance;

    private SingletonBank() {
        this.balance = 0.0;
    }

    public static synchronized SingletonBank getInstance() {
        if (instance == null) {
            instance = new SingletonBank();
        }
        return instance;
    }

    public synchronized void credit(double amount) {
        if (amount < 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        this.balance += amount;
        System.out.println("Credited: " + amount + ". New balance: " + this.balance);
    }

    public synchronized void debit(double amount) {
        if (amount < 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        this.balance -= amount;
        System.out.println("Debited: " + amount + ". New balance: " + this.balance);
    }

    public synchronized double getBalance() {
        return this.balance;
    }
}

public class Bank {
    public static void main(String[] args) {
        SingletonBank account = SingletonBank.getInstance();
        Scanner scanner = new Scanner(System.in);
       

        while (true) {
            System.out.println("1. Credit 2. Debit 3. Check Balance 4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    account.credit(creditAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    account.debit(debitAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                  	scanner.close();
                 		System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
