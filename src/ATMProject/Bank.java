package ATMProject;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getNewUserUUID(){
        StringBuilder UUID;
        Random rng = new Random();
        int len = 8;
        boolean nonUnique;
        do {
            UUID = new StringBuilder();
            for (int i = 0; i < len; i++) {
                UUID.append(((Integer) rng.nextInt(10)).toString());
            }
            nonUnique=false;
            for(User u : this.users) {
                if (UUID.toString().compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return UUID.toString();
    }

    public String getNewAccountUUID(){
    StringBuilder UUID;
    Random rng = new Random();
    int len = 10;
    boolean nonUnique;
    do {
        UUID = new StringBuilder();
        for (int i = 0; i < len; i++) {
            UUID.append(((Integer) rng.nextInt(10)).toString());
        }
        nonUnique=false;
        for(Account a : this.accounts) {
            if (UUID.toString().compareTo(a.getUUID()) == 0) {
                nonUnique = true;
                break;
            }
        }
    } while (nonUnique);
    return UUID.toString();

    }

    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    public User addUser(String firstName, String lastName, String pin) throws NoSuchAlgorithmException {
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);
        return newUser;
    }

    public User userLogin(String userID, String pin) throws NoSuchAlgorithmException {
        for(User u : this.users){
            if (u.getUUID().compareTo(userID)==0 && u.validatePin(pin)){
                return u;
            }
        }
        return null;
    }
    public String getName(){
        return this.name;
    }
}
