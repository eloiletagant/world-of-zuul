/**
 * This parser reads user input and return a string.
 *
 * @author Group 4
 * @version 25/11/2016
 */

import java.awt.event.*;
import javax.swing.*;
 
public class Parser extends JFrame implements KeyListener, ActionListener {
     

	private static final long serialVersionUID = 1L;
	private String output;
	private Game game;
	
     
    public Parser(Game g) {
        g = game;
    }
     
     
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("test parser");
        }   
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
        	output = game.getTypingArea().getText();
            game.setTextEvent(output);
            System.out.println("test parser");
            game.setVisible(false);
            game.setVisible(true);
        }   
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("test parser");
        }   
    }
     
    /** Handle the button click : to clear the fields */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
        //typingArea.setText("");
        //Return the focus to the typing area.
        //typingArea.requestFocusInWindow();
    }
     
}