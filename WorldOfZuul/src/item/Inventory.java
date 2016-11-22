package item;
import java.util.ArrayList;

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
	
	/**
	 * Constructor of an inventory.
	 * By default the inventory has any item and 1000 gold. 
	 */
	public Inventory()
	{
		gold = 1000;	
	}
	
	/**
	 * This method returns a list of item from the inventory - simple accessor
	 */
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	/**
	 * This method returns gold from the inventory of a character - simple accessor
	 */
	public int getGold()
	{
		return gold;
	}
	
	/**
	 * This method deletes all items in an inventory.
	 */
	private void resetInventory()
	{
		
	}
	
	/**
	 * This method deletes one item in an inventory.
	 */
	private void deleteItem()
	{
		
	}
	
	/**
	 * This method adds one item in an inventory.
	 */
	private void addItem()
	{
		
	}
	
}
