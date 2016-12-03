import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import item.Inventory;
import item.Item;

/**
 * This class allows creating a functional counter using the external listeners.
 * 
 * @author 
 * @version 
 */
public class InventoryInterfaceListener extends MouseAdapter 
{
    //attributes
    private InventoryInterface inventory;
    private ArrayList<Item> items;
    private Item myItem;
    
    /**
     * The Constructor for the listener
     */
    public InventoryInterfaceListener(InventoryInterface c)
    {
    	inventory = c;
    }
    /**
     * action to do when the mouse flies on buttons
     * This method displays the name of the item in the inventory
     */
     public void mouseEntered(MouseEvent evt)
     {
    	 items = inventory.getInventory().getItems();
    	 for (Item item : items)
    	 {
    		 if (evt.getSource() == inventory.getJButton(item))
    		 {
    			 inventory.getJButton(item).setToolTipText(item.getName());
    		 }
    	 }
     }

     /**
      * action to do when the mouse clicks on buttons
      * 
      */
     public void mousePressed(MouseEvent evt)
     {
    	 items = inventory.getInventory().getItems();
    	 if(evt.getSource() == inventory.back)
         {
    		 inventory.exitInventory();
         }
    	 else if(evt.getSource()==inventory.use)
         {
         	//penser à appliquer les effets avant de supprimer
         	myItem=inventory.searchItemDisplayed();
         	inventory.getInventory().deleteItem(myItem);
         	inventory.exitInventory();
         }
         else if(evt.getSource()==inventory.sell)
         {
         	//ouvrir la boîte d'échange (package trade)
         }
         else
         {
        	 for (Item item : items)
        	 {
        		 if (evt.getSource() == inventory.getJButton(item))
        		 {
        			 inventory.displayItem(inventory.searchItem(item.getName()));
        		 }
        	 }
         }
    }  
}