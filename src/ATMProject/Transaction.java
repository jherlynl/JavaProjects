package ATMProject;

import java.util.Date;

public class Transaction {
    private double amount;
    private Date timestamp;
    private String note;
    private Account inAccount;


    public Transaction(double amount, Account inAccount) {
        this.amount=amount;
        this.inAccount=inAccount;
        this.timestamp=new Date();
        this.note="";

    }

    public Transaction(double amount, String note, Account inAccount) {
        this(amount, inAccount);
        this.note = note;
    }
}
