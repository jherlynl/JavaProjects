package Banking;

public class BankingAccount {

    //Create my account
    double balance;
    String name = "Jherlyn Luzuriaga";
    int accNumber = 1;
    double interestRate = 0.05;
        public void Account(String n, double amount) {
        name = n;
        balance = amount;
    }

    //Set account balance start to 0
    public void Account(String n, int a) {
        name = n;
        accNumber = a;
        balance = 0.00;
    }
    //Deposit an amount into the account
    public void Deposit(double amount) {
        if(amount<=0) {
            System.out.println("System cannot deposit negative amounts. Please enter an amount above zero.");
        } else {
            this.balance += amount;
            System.out.println(amount + " has been deposited into account.");
        }
    }

    //withdraw
    public void withdraw(double amount) {
        if (amount <= this.balance)
        {
            this.balance -= amount;
            System.out.println(amount + " has been withdrawn from account.");
        } else {
            System.out.println("Cannot process transaction due to insufficient funds.");
        }
    }

    //get balance
    public double getBalance() {
        System.out.print("Your account balance is: $");
        return balance;
    }
    public void printAccInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
            return "Account Name: " + this.name + ", Acccount Number: " + this.accNumber + ", Account Balance: $" + this.balance;
    }

    //calculate interest(5% interest rate)
    public void calculateInterest(){
        if (balance <= 0)
        {
            System.out.println("Cannot calculate interest due to negative or zero account balance. Please deposit funds.");
        } else {
            System.out.println("This month's interest earnings is: $" + this.balance*interestRate);
        }
    }
}
