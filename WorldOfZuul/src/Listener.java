import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
/**
 * This class allows creating a functionnal counter using the external listeners.
 * 
 * @author 
 * @version 
 */
public class Listener extends MouseAdapter  implements ActionListener
{
    //attributes
    private InventoryInterface i;
    
    /**
     * The Constructor for the listener
     */
    public Listener(InventoryInterface c)
    {
        i = c;
    }
    
    /**
     * Action from buttons
     */
    public void actionPerformed(ActionEvent e)
    {

    }

     /**
     * This class allow 
     */
     public void mousePressed(MouseEvent evt) {
         if(evt.getSource() == i.back)
        {

        }
        else if(evt.getSource() == i.sellButton)
        {

        }
        else if(evt.getSource() == i.useButton)
        {

        }
        
    }
    
}