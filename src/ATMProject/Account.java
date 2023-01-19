package ATMProject;

import java.util.ArrayList;

public class Account {
    private String name;
    private double balance;
    private String UUID;
    private User holder;
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;
        this.UUID = theBank.getNewAccountUUID();
        this.transactions = new ArrayList<Transaction>();
        ;
    }
    public String getUUID(){
        return this.UUID;
    }
}
