package emailapp;

import java.util.Random;
import java.util.Scanner;
public class Email {
    private String firstName;
    private String lastName;
    private String dept;
    private static String email;
    private String Password;
    private int passwordLength = 8;
    private int mailCapacity = 500;

    public static void emailName() {
        Scanner fn = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = fn.nextLine();

        Scanner ln = new Scanner(System.in);
        System.out.print("Enter your last name: ");
        String lastName = ln.nextLine();
        System.out.println("Employee name: " + firstName + " " + lastName);

        //department();

        //combine name & dept to create email address
        email = firstName.toLowerCase() + lastName.toLowerCase() + "." + department().toLowerCase() + "@yearup.org";
        System.out.println("Your email is: " + email);
    }

    public static String department() {
        Scanner dep = new Scanner(System.in);
        System.out.println("Enter your Department: \n1 for Software Development \n2 for IT");
        int depChoice = dep.nextInt();
        if (depChoice == 1) {
            return "Development";
        } else if (depChoice == 2) {
            return "IT";
        } else {
            return "";
        }
    }

    //method to generate random password
    //private String password;
    static String randomPassword(int length) {
        Random r = new Random();
        String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklnmopqrstuvwxyz1234567890!&#%?@$";
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + passwordChars.charAt(r.nextInt(passwordChars.length()));
        }
        return password;
    }

    //have mailbox capacity
    public void setMailCapacity(int capacity) {
        this.mailCapacity = capacity;
    }
//change password
    public void changePassword(String Password){
        this.Password = Password;
    }

}



