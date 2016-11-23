package item;
import java.util.ArrayList;

import room.Lock;

/**
 * This class manages all items of a character in an inventory.
 * @author Group4
 * @version 22/11/2016
 *
 */
public class Inventory
{
	// an array of items
	private ArrayList<Item> items;
	// money of a player
	private int gold;
	// number maximum of items in the inventory
	private int maxItems;
	private String name;
	private String description;
	private Lock lock;
	
	/**
	 * Constructor of the class
	 * @param name String : name of the item
	 * @param description String : description of the item and it's effects
	 * @param maxItmes int : number max of items in the inventory
	 * @param lock Lock : Locked of the inventory
	 * By default the inventory has any item. 
	 */
	public Inventory(String name, String description, int maxItems, Lock lock) {
		this.name = name;
		items = new ArrayList<Item>();
		this.maxItems = maxItems;
		this.lock = lock;
	}
	
	/**
	 * Constructor of the class
	 * @param name String : name of the item
	 * @param description String : description of the item and it's effects
	 * @param maxItmes int : number max of items in the inventory
	 * By default the inventory has any item. 
	 */
	public Inventory(String name, String description, int maxItems) {
		this.name = name;
		items = new ArrayList<Item>();
		this.maxItems = maxItems;
	}
	
	
	/**
	 * This method returns a list of item from the inventory - simple accessor
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * This method returns gold from the inventory of a character - simple accessor
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * This method allow to add or remove money (by minus int) from the inventory
	 */
	public void manageGold(int money)
	{
		gold += money;
	}
	
	
	/**
	 * This method deletes all items in an inventory.
	 */
	public void resetInventory()
	{
		items.clear();
	}
	
	/**
	 * This method deletes one item in an inventory.
	 * @param item: The item deleted to the inventory
	 */
	public void deleteItem(Item itemToDelete)
	{
		items.remove(itemToDelete);
	}
	
	/**
	 * This method adds one item in an inventory.
	 * @param item: The item added to the inventory
	 */
	public void addItem(Item itemToAdd)
	{
		items.add(itemToAdd);
	}
	
	/**
	 * This method open the inventory if it's locked
	 *  if the key you try to use is the good one
	 * @param key Key : the key you want to try
	 * @return: return true if is the correct key and false if is the false key
	 * 
	 */
	public boolean openInventory(Key key) {
		boolean done = false;
		
		return done;
	}
}
