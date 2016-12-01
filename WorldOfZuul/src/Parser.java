import java.util.Scanner;

/**
 * This parser reads user input and return a string.
 *
 * @author Group 4
 * @version 25/11/2016
 */
public class Parser {

    private Scanner reader;         // source of command input
    
    public Parser() 
    {
        reader = new Scanner(System.in);
    }
    
    /**
     * @return The next command from the user.
     */
    public String getCommand() 
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Input: ");
        String str = reader.nextLine();
        
        return str;
    }

}
