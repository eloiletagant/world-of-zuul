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
    private int i;
    
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
    	 i=0;
    	 if (evt.getSource() != inventory.getBack() || evt.getSource() != inventory.getUse() || evt.getSource() != inventory.getSell())
		 {
    		 for (Item item : items)
    		 {
    			 if (evt.getSource() == inventory.getItemToDisplay(i))
    			 {
    				 inventory.getItemToDisplay(i).setToolTipText(item.getName());
    			 }
    			 i+=1;
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
    	 i=0;
    	 if(evt.getSource() == inventory.getBack())
         {
    		 inventory.exitInventory();
         }
    	 else if(evt.getSource()==inventory.getUse())
         {
         	//penser à appliquer les effets avant de supprimer
         	myItem=inventory.searchItemDisplayed();
         	inventory.getInventory().deleteItem(myItem);
         	inventory.exitInventory();
         }
         else if(evt.getSource()==inventory.getSell())
         {
         	//ouvrir la boîte d'échange (package trade)
         }
    	 else
         {
    		 for (Item item : items)
        	 {
        		 if (evt.getSource() == inventory.getItemToDisplay(i))
        		 {
        			 inventory.displayItem(inventory.searchItem(item.getName()));        			 
        		 }
        		 i+=1;
        	 }
         }
    }  
}