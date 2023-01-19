package Banking;

public class MainBank {
    public static void main(String[] args) {
        //create my account
        //check my balance, which is 0.00
        BankingAccount account1 = new BankingAccount();

        account1.printAccInfo();

        //System.out.println(account1.getBalance());

        //make a deposit
        account1.Deposit(100);
        System.out.println(account1.getBalance());

        //withdraw money
        account1.withdraw(50);
        System.out.println(account1.getBalance());

        account1.printAccInfo();
        account1.calculateInterest();
    }
}
