package ATMProject;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        Bank theBank = new Bank("Bank of America");

        User aUser = theBank.addUser("Jherlyn", "Luzuriaga", "8888");

        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true) {
            curUser = ATM.mainMenuPrompt(theBank, sc);
            //ATM.printUserMenu(curUser, sc);
        }

    }

    public static User mainMenuPrompt(Bank theBank, Scanner sc) throws NoSuchAlgorithmException {
        String userID;
        String pin;
        User authUser;

        do {
            System.out.printf("\nWelcome to %s\n\n", theBank.getName());
            System.out.println("Enter user ID: ");
            userID = sc.nextLine();
            System.out.print("Enter pin:");
            pin = sc.nextLine();

            authUser = theBank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Invalid login information. Please try again.");
            }
        } while (authUser==null);
        return authUser;
    }
    /*public static void printUserMenu(User theUser, Scanner sc){
        theUser.printAccountSummary();
        int choice;
        do{
            System.out.println();
            theUser.getFirstName;
        }*/
    }

