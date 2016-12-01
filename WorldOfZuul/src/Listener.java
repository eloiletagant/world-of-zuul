import javax.swing.*;
import item.Inventory;
import item.Item;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.*;

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
    private ArrayList<Item> items;
    
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
     public void mousePressed(MouseEvent evt)
     {
    	 items = inventory.getInventory().getItems();
    	 if(evt.getSource() == inventory.back)
        {

        }
        else if(evt.getSource() == inventory.pineapple)
        {
        	inventory.searchItem("Pineapple");
        	inventory.displayItem(item);
        }
        else if(evt.getSource() == inventory.eggplant)
        {

        }
        else if(evt.getSource() == inventory.brioche)
        {
        	
        }
        else if(evt.getSource() == inventory.bread)
        {

        }
        else if(evt.getSource() == inventory.cookies)
        {

        }
        else if(evt.getSource() == inventory.potion)
        {

        }
        else if(evt.getSource() == inventory.axe)
        {

        }
        else if(evt.getSource() == inventory.bow)
        {

        }
        else if(evt.getSource() == inventory.mincingMachine)
        {

        }
        else if(evt.getSource() == inventory.sword)
        {

        }
        else if(evt.getSource() == inventory.key1)
        {
        	
        }
        else if(evt.getSource() == inventory.key2)
        {

        }              
    }  
}