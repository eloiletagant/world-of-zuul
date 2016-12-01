import java.util.Scanner;

/**
 * This parser reads user input and return a string.
 *
 * @author Group 4
 * @version 25/11/2016
 */
public class Parser {
	
    /**
     * @return The next command from the user.
     */
    public static void scanWords(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Input: ");
        String str = reader.nextLine();
        System.out.println("Your input is: " + str);
        reader.nextLine(); //empty line
    }
}
