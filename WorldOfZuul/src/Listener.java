import javax.swing.*;
import item.Inventory;
import item.Item;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
/**
 * This class allows creating a functionnal counter using the external listeners.
 * 
 * @author 
 * @version 
 */
public class Listener extends MouseAdapter 
{
    //attributes
    private InventoryInterface inventory;
    
    /**
     * The Constructor for the listener
     */
    public Listener(InventoryInterface c)
    {
    	inventory = c;
    }
    /**
     * This class allow 
     */
     public void mouseEntered(MouseEvent evt) {
    	 
     }

     /**
     * This class allow 
     */
     public void mousePressed(MouseEvent evt) {
         if(evt.getSource() == inventory.back)
        {

        }
        else if(evt.getSource() == inventory.pineappleButton)
        {
        	
        }
        else if(evt.getSource() == inventory.eggplantButton)
        {

        }
        else if(evt.getSource() == inventory.briocheButton)
        {
        	
        }
        else if(evt.getSource() == inventory.breadButton)
        {

        }
        else if(evt.getSource() == inventory.cookiesButton)
        {

        }
        else if(evt.getSource() == inventory.potionButton)
        {

        }
        else if(evt.getSource() == inventory.axeButton)
        {

        }
        else if(evt.getSource() == inventory.bowButton)
        {

        }
        else if(evt.getSource() == inventory.mincingMachineButton)
        {

        }
        else if(evt.getSource() == inventory.swordButton)
        {

        }
        else if(evt.getSource() == inventory.key1Button)
        {
        	
        }
        else if(evt.getSource() == inventory.key2Button)
        {

        }              
    }  
}