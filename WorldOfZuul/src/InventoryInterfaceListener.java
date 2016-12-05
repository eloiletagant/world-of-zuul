import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import item.*;
import room.*;

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
    private HashMap<String,Door> doors;
    
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
    	 Item anItem=inventory.searchItemDisplayed();
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
    		 else if(evt.getSource() == inventory.getUse())
    		 {
    			 if (inventory.getUse().isEnabled()==false)
    			 {
    				 if (anItem instanceof Consumable)
    				 {
        				 inventory.getUse().setToolTipText("You have to equip a weapon before using this item.");

    				 }
    				 else if (anItem instanceof Key)
    				 {
        				 inventory.getUse().setToolTipText("You can not use a key at the moment.");
    				 }
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
    		 myItem=inventory.searchItemDisplayed();
    		 if (inventory.getUse().isEnabled()==true)
        	 {
    			 if (myItem instanceof Consumable)
    			 {
    				 if (((Consumable) myItem).getCare()>0)
    				 {
    					 inventory.getPlayer().manageHealth(((Consumable) myItem).getCare());
    				 }
    				 else if (((Consumable) myItem).getDamage()>0)
    				 {
    					 if (((Consumable) myItem).getWeapon()==false)
    					 {
    						 inventory.getPlayer().manageBonusDamages(((Consumable) myItem).getDamage());
    					 }
    					 else
    					 {
    						 for (Item item : items)
    						 {
    							 if (item instanceof Weapon)
    							 {
    								 if (((Weapon) item).getEquiped()==true)
    								 {
    									 ((Weapon) item).addDamages(((Consumable) myItem).getDamage());
    								 }
    							 }
    						 }
    					 }
    					 inventory.getInventory().deleteItem(myItem);
            			 inventory.exitInventory();
    				 }
    			 }
    			 else if (myItem instanceof Key)
    	         {
    				 //utilisé uniquement quand y a un chest ou une doorlocked dans la pièce où l'on est
    	    		 doors=inventory.getPlayer().getLocation().getDoors();
    	    		 for (Map.Entry<String,Door> door : doors.entrySet())
    	    		 {
    	    			 if (door.getValue().isLocked()==true)
    	    			 {
    	    				 if (door.getValue().getLock().unlock((Key) myItem)==true)
    	    				 {
    	    				 	 inventory.getGame().manageDirectionButtons();
    	    				 	 inventory.getGame().setText("You have unlocked the door.");
    	    				 	 inventory.getInventory().deleteItem(myItem);
    	        	             inventory.exitInventory();
    	    					 break; 
    	    				 }
    	    				 else
    	    				 {
    	    					 inventory.getGame().setText("This key does not work, please try another key.");
    	    				 }
    	    			 }
    	    		 }
    	         }
        	 }
         }
    	 else if(evt.getSource()==inventory.getEquip())
         {
    		 myItem=inventory.searchItemDisplayed();
    		 if (inventory.getEquip().isEnabled()==true)
        	 {
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