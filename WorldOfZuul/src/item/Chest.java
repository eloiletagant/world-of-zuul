package item;
import java.util.ArrayList;

public class Chest extends Inventory
{
	private String name;
	private String description;
	private Lock lock;
	
	/**
	 * Constructor of the class (with a lock to use like a locked chest)
	 * @param name String : name of the item
	 * @param description String : description of the item and it's effects
	 * @param maxItmes int : number max of items in the inventory
	 * @param lock Lock : Locked of the inventory
	 * By default the inventory has any item. 
	 */
	public Chest(String aName, String aDescription, int maxItems, int golds, Lock aLock)
	{
		super(maxItems,golds);
		name=aName;
		description=aDescription;
		lock = aLock;
	}
	
	/**
	 * This method returns the name of the chest.
	 * @return String	name of chest
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method returns the description of the chest.
	 * @return String	description of chest
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * Access to the chest locket
	 * @return Lock : chest locket 
	 */
	public Lock getLock()
	{
		return lock;
	}

	/**
	 * This method open the inventory if it's locked
	 *  if the key you try to use is the good one
	 * @param key Key : the key you want to try
	 * @return: return true if is the correct key and false if is the false key
	 * 
	 */
	public boolean openInventory(Key key)
	{
		return lock.unlock(key);
	}
}
