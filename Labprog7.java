package java_basics.proj6.porgram7;

public class Labprog7 {

    static class IllegalArgumentException extends Exception {
        public IllegalArgumentException(String msg) {
            super(msg);
            System.out.println(msg);
        }
    }

    static class SingletonBank {
        private static final SingletonBank instance = new SingletonBank();
        private double balance;

        private SingletonBank() {
            this.balance = 0.0;
        }

        public static synchronized SingletonBank getInstance() {
            return instance;
        }

        public synchronized void credit(double amount) throws IllegalArgumentException {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            balance += amount;
            System.out.println("Credited " + amount + ", new balance: " + balance);
        }

        public synchronized void debit(double amount) throws IllegalArgumentException {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            if (balance < amount) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            balance -= amount;
            System.out.println("Debited " + amount + ", new balance: " + balance);
        }

        public synchronized double getBalance() {
            return this.balance;
        }
    }

    static class CreditThread extends Thread {
        private final SingletonBank account;
        private final double amount;

        CreditThread(SingletonBank account, double amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            try {
                account.credit(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    static class DebitThread extends Thread {
        private final SingletonBank account;
        private final double amount;

        DebitThread(SingletonBank account, double amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            try {
                account.debit(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        SingletonBank account = SingletonBank.getInstance();
        Thread t1 = new CreditThread(account, 1000);
        Thread t2 = new DebitThread(account, 500);
        Thread t3 = new CreditThread(account, 1000);
        Thread t4 = new DebitThread(account, 500);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
