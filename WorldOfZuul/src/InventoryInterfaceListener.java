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
    		 inventory.exitInventory();
    		 //game mettre à true mais je sais pas comment faire now
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
        	inventory.displayItem(inventory.searchItem("Nu-Clef-ère"));     	
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
        	//le delete marche pas mais je sais pas pourquoi
        }
        else if(evt.getSource()==inventory.sell)
        {
        	//ouvrir la boîte d'échange (package trade)
        }
    }  
}