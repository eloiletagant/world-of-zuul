import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import item.*;
import room.*;

/**
 * This class allows to interact with buttons which are in the inventory.
 * It does an action according to the event.
 * 
 * @author 
 * @version 
 */
public class InventoryInterfaceListener extends MouseAdapter 
{
    //inventory attributes
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
    	 int i=0;
    	 if (evt.getSource() != inventory.getBack())
		 {
    		 //if the equip button is disabled, a message is displayed to explain
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
    		//if the sell button is disabled, a message is displayed to explain
    		 else if(evt.getSource() == inventory.getSell())
    		 {
    			 if (inventory.getSell().isEnabled()==false)
    			 {
    				 inventory.getSell().setToolTipText("You can not sell this item.");
    			 }
    		 }
    		//if the use button is disabled, a message is displayed to explain
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
    			//when the mouse flies on items, a message with the name of object is displayed
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
    	 //back button closes the inventory
    	 if(evt.getSource() == inventory.getBack())
         {
    		 inventory.manageInventory();
         }
    	//back2 button closes the item view
    	 else if(evt.getSource() == inventory.getBack2())
         {
    		 inventory.manageInventory();
         }
    	//use button does lots of things depending on type of object
    	 else if(evt.getSource()==inventory.getUse())
         {
    		 myItem=inventory.searchItemDisplayed();
    		 if (inventory.getUse().isEnabled()==true)
        	 {
    			 //if consumable, this function applies effect of the object
    			 if (myItem instanceof Consumable)
    			 {
    				 if (((Consumable) myItem).getCare()>0)
    				 {
    					 inventory.getPlayer().manageHealth(((Consumable) myItem).getCare());
    					 inventory.getGame().getHealthBar().setValue(inventory.getPlayer().getHealth());
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
    				 }
    				 inventory.getInventory().deleteItem(myItem);
        			 inventory.manageInventory();
    			 }
    			 //if key, this function tries to open the door or chest
    			 else if (myItem instanceof Key) 
    	         {
    				 doors=inventory.getPlayer().getLocation().getDoors();
    	    		 for (Map.Entry<String,Door> door : doors.entrySet())
    	    		 {
    	    			 if (door.getValue().isLocked()==true)
    	    			 {
    	    				 if (door.getValue().getLock().unlock((Key) myItem)==true)
    	    				 {
    	    				 	 inventory.getGame().setText("You have unlocked the door.");
    	    				 	 inventory.getInventory().deleteItem(myItem);
    	    					 break; 
    	    				 }
    	    				 else
    	    				 {
    	    					 inventory.getGame().setText("This key does not work, please try another key.");
    	    				 }
    	    			 }
    	    		 }
    	    		 if (inventory.getPlayer().getLocation().hasChest()==true)
    	    		 {
    	    			 Chest aChest=inventory.getPlayer().getLocation().getChest();
    	    			 if (aChest.getLock().unlock((Key) myItem)==true)
    	    			 {
    	    				 
    	    				 inventory.getGame().setText("You have unlocked the chest.");
	    				 	 inventory.getInventory().deleteItem(myItem);
	        	             inventory.manageInventory();
    	    			 }
    	    			 else
	    				 {
	    					 inventory.getGame().setText("This key does not work, please try another key.");
	    				 }
    	    				 
    	    		 }
    	         }
        	 }
         }
    	 //equip button equips the weapon to the player
    	 else if(evt.getSource()==inventory.getEquip())
         {
    		 myItem=inventory.searchItemDisplayed();
    		 if (inventory.getEquip().isEnabled()==true)
        	 {
        		 if (myItem instanceof Weapon)
        		 {
        			 ((Weapon) myItem).equip();
        			 inventory.manageInventory();
        		 }
        	 }
         }
    	//unequip button unequips the weapon from the player
    	 else if(evt.getSource()==inventory.getUnequip())
         {
    		 myItem=inventory.searchItemDisplayed();
    		 if (myItem instanceof Weapon)
    		 {
    			 ((Weapon) myItem).equip();
    		 }
    		 inventory.manageInventory();
         }
    	//sell button sells the item, gives money to player and deletes this item in the inventory
         else if(evt.getSource()==inventory.getSell())
         {
        	 if (inventory.getSell().isEnabled()==true)
        	 {
        		 myItem=inventory.searchItemDisplayed();
            	 inventory.getInventory().manageGold(myItem.getPrice());
              	 inventory.getInventory().deleteItem(myItem);
              	 inventory.manageInventory();
        	 }
         }
    	 else
         {
    		//item button displays item view
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