public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized void debit(double amount) {
        if(amount > getBalance()) {
            throw new RuntimeException("Insufficient balance");
        }
        balance = getBalance() - amount;
    }

    public synchronized void credit(double amount) {
        balance = getBalance() + amount;
    }

    public double getBalance() {
        return balance;
    }
}
