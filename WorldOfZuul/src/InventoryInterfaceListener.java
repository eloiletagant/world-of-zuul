import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import item.Inventory;
import item.Item;

/**
 * This class allows creating a functionnal counter using the external listeners.
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
    	if(evt.getSource() == inventory.pineapple)
        {
        	inventory.pineapple.setToolTipText("Pineapple");
        }
        else if(evt.getSource() == inventory.eggplant)
        {
        	inventory.eggplant.setToolTipText("Eggplant");  
        }
        else if(evt.getSource() == inventory.brioche)
        {
        	inventory.brioche.setToolTipText("Brioche");
        }
        else if(evt.getSource() == inventory.bread)
        {
        	inventory.bread.setToolTipText("Bread");
        }
        else if(evt.getSource() == inventory.cookies)
        {
        	inventory.cookies.setToolTipText("Cookies");
        }
        else if(evt.getSource() == inventory.potion)
        {
        	inventory.potion.setToolTipText("Potion");
        }
        else if(evt.getSource() == inventory.axe)
        {
        	inventory.axe.setToolTipText("Axe");
        }
        else if(evt.getSource() == inventory.bow)
        {
        	inventory.bow.setToolTipText("Bow");
        }
        else if(evt.getSource() == inventory.mincingMachine)
        {
        	inventory.mincingMachine.setToolTipText("Butcher knife");
        }
        else if(evt.getSource() == inventory.sword)
        {
        	inventory.sword.setToolTipText("Sword");
        }
        else if(evt.getSource() == inventory.key1)
        {
        	inventory.key1.setToolTipText("Nu-Clef-ère");   	
        }
        else if(evt.getSource() == inventory.key2)
        {
        	inventory.key2.setToolTipText("Sésame");
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
        else if(evt.getSource() == inventory.pineapple)
        {
        	inventory.displayItem(inventory.searchItem("Pineapple"));
        }
        else if(evt.getSource() == inventory.eggplant)
        {
        	inventory.displayItem(inventory.searchItem("Eggplant"));
        }
        else if(evt.getSource() == inventory.brioche)
        {
        	inventory.displayItem(inventory.searchItem("Brioche"));
        }
        else if(evt.getSource() == inventory.bread)
        {
        	inventory.displayItem(inventory.searchItem("Bread"));
        }
        else if(evt.getSource() == inventory.cookies)
        {
        	inventory.displayItem(inventory.searchItem("Cookies"));
        }
        else if(evt.getSource() == inventory.potion)
        {
        	inventory.displayItem(inventory.searchItem("Potion"));
        }
        else if(evt.getSource() == inventory.axe)
        {
        	inventory.displayItem(inventory.searchItem("Axe"));
        }
        else if(evt.getSource() == inventory.bow)
        {
        	inventory.displayItem(inventory.searchItem("Bow"));
        }
        else if(evt.getSource() == inventory.mincingMachine)
        {
        	inventory.displayItem(inventory.searchItem("Butcher knife"));
        }
        else if(evt.getSource() == inventory.sword)
        {
        	inventory.displayItem(inventory.searchItem("Sword"));
        }
        else if(evt.getSource() == inventory.key1)
        {
        	inventory.displayItem(inventory.searchItem("Nu-Clef-ï¿½re"));     	
        }
        else if(evt.getSource() == inventory.key2)
        {
        	inventory.displayItem(inventory.searchItem("Sésame"));
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
    }  
}