package item;
import java.util.ArrayList;

/**
 * This class manages all items of a character in a inventory.
 * @author Group4
 * @version 10/11/2016
 *
 */
public class Inventory
{
	private ArrayList<Item> items;
	private int gold;
	
	/**
	 * Constructor of an inventory
	 */
	public Inventory()
	{
		gold = 1000;	
	}
	
	/**
	 * This method returns a list of item from the inventory.
	 */
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	/**
	 * This method returns gold from the inventory of a character
	 */
	public int getGold()
	{
		return gold;
	}
	
	/**
	 * This method deletes the content of an inventory.
	 */
	private void resetInventory()
	{
		
	}
	
	/**
	 * This method deletes an item of an inventory.
	 */
	private void deleteItem()
	{
		
	}
	
	/**
	 * This method adds an item in an inventory.
	 */
	private void addItem()
	{
		
	}
	
}
