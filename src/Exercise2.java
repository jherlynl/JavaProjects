import java.util.Scanner;
import java.util.regex.*;
public class Exercise2 {

    public static void main(String[] args) {

    do {
        System.out.print("Please enter a number (n): ");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        if (n>0) {
           String(n);
        } else {
            //System.out.println("Goodbye!");
            break;
        }
    } while (false);
    }
private String sS;
    public static void String(int num) {
        String str = null;
        for (int i = 0; i < num; i++) {
            System.out.print("Enter a String: ");
            Scanner input = new Scanner(System.in);
            str = input.nextLine();

            Pattern emailPattern = Pattern.compile("(^[a-zA-Z]+)@([a-zA-Z]+\\.[a-zA-Z]{3})$");
            Pattern phonePattern = Pattern.compile("(\\(?\\d{3}+\\)?)[-.\\s]?\\d{3}+[-.\\s]?\\d{4}+");
            Pattern addressPattern = Pattern.compile("^([1-9][0-9]{1,5}+)\\s?([a-zA-Z]+\\s*)([A-Za-z]+|[1-9]+)\\s[A-Za-z]+(\\.)?$");
            Matcher emailMatcher = emailPattern.matcher(str);
            Matcher phoneMatcher = phonePattern.matcher(str);
            Matcher addressMatcher = addressPattern.matcher(str);

            if (emailMatcher.matches()) {
                String username = emailMatcher.group(1);
                System.out.println("It's " + username + "'s email.");
            } else if (phoneMatcher.matches()) {
                String areaCode = (phoneMatcher.group(1));
                System.out.println("It's a phone number with area code " + areaCode +".");
            } else if (addressMatcher.matches()) {
                System.out.println("It's an address.");
            } else {
                System.out.println("No Match.");
            }
        }
    }
}

