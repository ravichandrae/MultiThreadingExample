public class BankingApp {
    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        fromAccount.debit(amount);
        toAccount.credit(amount);
    }
}
