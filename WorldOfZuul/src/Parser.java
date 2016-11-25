import java.util.Scanner;

/** * 
 * This parser reads user input and return a string.
 * 
 * @author  Group 4
 * @version 25/11/2016
 */
public class Parser 
{  
    /**
     * @return The next command from the user.
     */
    public static void scanWords(String[] args){
    	Scanner reader = new Scanner(System.in);
        System.out.println("Saisissez une chaîne : ");
        String str = reader.nextLine();
        System.out.println("Vous avez saisi le mot : " + str);
        reader.nextLine(); //empty line
    }
}
