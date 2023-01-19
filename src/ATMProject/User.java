package ATMProject;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    String  firstName;
    String lastName;
    private String UUID;
    byte[] pinHash;

    ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank theBank) throws NoSuchAlgorithmException {
        this.firstName = firstName;
        this.lastName = lastName;

        MessageDigest md = MessageDigest.getInstance("MD5");
        this.pinHash = md.digest(pin.getBytes());

        this.UUID= theBank.getNewUserUUID();

        this.accounts = new ArrayList<Account>();
        System.out.printf("New user %s %s with ID %s created.\n", firstName, lastName, this.UUID);

    }
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    public String getUUID(){
        return this.UUID;
    }

    public boolean validatePin(String aPin) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
    }
}
