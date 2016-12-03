/**
 * This parser reads user input and return a string.
 *
 * @author Group 4
 * @version 25/11/2016
 */

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
 
public class Parser extends JFrame implements KeyListener, ActionListener {
     
    //Uncomment this if you wish to turn off focus
    //traversal.  The focus subsystem consumes
    //focus traversal keys, such as Tab and Shift Tab.
    //If you uncomment the following line of code, this
    //disables focus traversal and the Tab events will
    //become available to the key event listener.
    //typingArea.setFocusTraversalKeysEnabled(false);

     
    //getContentPane().add(typingArea, BorderLayout.PAGE_START);
    //getContentPane().add(button, BorderLayout.PAGE_END);
 
     
    public Parser(String name) {
        super(name);
    }
     
     
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
    }
     
    /** Handle the button click : to clear the fields */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
        //typingArea.setText("");
        //Return the focus to the typing area.
        //typingArea.requestFocusInWindow();
    }
     
}