import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import item.*;

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
    	 if (evt.getSource() != inventory.getBack())
		 {
    		 if (evt.getSource() == inventory.getEquip())
    		 {
    			 if (inventory.getEquip().isEnabled()==false)
    			 {
    				 for (Item item : items)
    				 {
    					 if (item instanceof Weapon)
    	        		 {
    	        			 if (((Weapon) item).getEquiped()==true)
    	        			 {
    	        				 myItem=item;
    	        				 inventory.getEquip().setToolTipText("You can not equip this weapon. You have to unequip your current weapon ("+myItem.getName()+").");
    	        			 }
    	        		 }
    				 }
    			 }
    		 }
    		 else if(evt.getSource() == inventory.getSell())
    		 {
    			 if (inventory.getSell().isEnabled()==false)
    			 {
    				 inventory.getSell().setToolTipText("You can not sell this item.");
    			 }
    		 }
    		 else
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
    	 else if(evt.getSource()==inventory.getEquip())
         {
    		 if (inventory.getEquip().isEnabled()==true)
        	 {
    			 myItem=inventory.searchItemDisplayed();
        		 if (myItem instanceof Weapon)
        		 {
        			 ((Weapon) myItem).equip();
        			 inventory.exitInventory();
        		 }
        	 }
         }
    	 else if(evt.getSource()==inventory.getUnequip())
         {
    		 myItem=inventory.searchItemDisplayed();
    		 if (myItem instanceof Weapon)
    		 {
    			 ((Weapon) myItem).equip();
    		 }
    		 inventory.exitInventory();
         }
         else if(evt.getSource()==inventory.getSell())
         {
        	 if (inventory.getSell().isEnabled()==true)
        	 {
        		 myItem=inventory.searchItemDisplayed();
            	 inventory.getInventory().manageGold(myItem.getPrice());
              	 inventory.getInventory().deleteItem(myItem);
              	 inventory.exitInventory();
        	 }
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