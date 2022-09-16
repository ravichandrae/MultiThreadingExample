public class Test {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("A", 10000);
        BankAccount account2 = new BankAccount("B", 0);

        BankingApp app = new BankingApp();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    app.transfer(account1, account2, 1);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    app.transfer(account1, account2, 1);
                }
            }
        });

        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Account 1 Balance: " + account1.getBalance() +
                "\nAccount 2 Balance: " + account2.getBalance());
        System.out.println("Time Taken: " + (endTime - startTime));
    }
}
