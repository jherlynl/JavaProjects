import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Exercise1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/Jherlyn Luzuriaga/Downloads/dictionary.txt");
        Scanner f = new Scanner(file);
        System.out.println("Palindromes:");
        while (f.hasNextLine())
        {
            String line = f.nextLine();
            Palindromes(line);
        }
        System.out.println("---------------");
        System.out.println("All words starting with letters B to M: ");
        printBThruM();
        System.out.println("---------------");
        printLongestWord();
        System.out.println("---------------");
        vowelsTotals();
        System.out.println("---------------");
        groupWordsByLetter();
    }

    //1. Find all the palindromes in the dictionary and print them
    public static void Palindromes(String pal) {
        String reverseWord = "";
        String firstHalf = pal.substring(0, pal.length()/2);
        for (int i = pal.length() - 1; i >= pal.length()/2; i--) {
            reverseWord += pal.charAt(i);
        }
        if (firstHalf.equals(reverseWord))
            System.out.println(pal);
    }

    //2. Find all the words starting with letter b to m
    public static void printBThruM() throws FileNotFoundException {
        String letters = "bcdefjhijklmBCDEFGHIJKLM";
        File file = new File("/Users/Jherlyn Luzuriaga/Downloads/dictionary.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            for (int i = 0; i < letters.length(); i++) {
                if (line.startsWith(String.valueOf(letters.charAt(i)))) System.out.println(line);
            }
        }
    }

    //      Find the longest word and print it
    public static void printLongestWord() throws FileNotFoundException {
        String check = "BCDEFGHIJKLMbcdefjhijklm";
        File file = new File("/Users/Jherlyn Luzuriaga/Downloads/dictionary.txt");
        Scanner input = new Scanner(file);
        String longestWord = "";
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.length() >= longestWord.length() && check.contains(String.valueOf(line.charAt(0)))) {
                longestWord = line;
            }
        }
        System.out.println("The longest word is: " + longestWord);
    }

    //      Count the total number of vowels and print it
    public static void vowelsTotals() throws FileNotFoundException {
        String check = "BCDEFGHIJKLMbcdefjhijklm";
        File file = new File("/Users/Jherlyn Luzuriaga/Downloads/dictionary.txt");
        Scanner input = new Scanner(file);
        int vowelTotal = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (check.contains(String.valueOf(line.charAt(0)))) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u' || line.charAt(i) == 'y' || line.charAt(i) == 'A' || line.charAt(i) == 'E' || line.charAt(i) == 'I' || line.charAt(i) == 'O' || line.charAt(i) == 'U') {
                        vowelTotal++;
                    }
                }
            }
        }
        System.out.println("The total number of vowels are: " + vowelTotal);
    }

// 3. Write function that group words by the first letter
    public static void groupWordsByLetter() throws FileNotFoundException {

        HashMap<String, ArrayList<String>> words = new HashMap<>();
        File file = new File("/Users/Jherlyn Luzuriaga/Downloads/dictionary.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String l = input.nextLine();
            if (words.containsKey(String.valueOf(l.charAt(0)))) {
                words.get(String.valueOf(l.charAt(0))).add(l);
            } else {
                words.put(String.valueOf(l.charAt(0)), new ArrayList<String>());
                words.get(String.valueOf(l.charAt(0))).add(l);
            }
        }
        int mostWord = 0;
        int group = 0;
        for (char i = 97 ; i <= 122; i++){
            if (words.get(String.valueOf(i)).size() >= mostWord){
                mostWord = words.get(String.valueOf(i)).size();
                group = i;
            }

        }
        System.out.println("The group beginning with the letter \"" + (char) group + "\" is the largest group. Group " + (char) group + " contains " + mostWord + " words.");
    }
}

