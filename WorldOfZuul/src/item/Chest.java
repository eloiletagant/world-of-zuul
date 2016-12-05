package item;

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
	 * By default the inventory has no item. 
	 */
	public Chest(String aName, String aDescription, int maxItems, int golds, Lock aLock)
	{
		super(maxItems,golds);
		if (aDescription.isEmpty())
		{
			aDescription="This object seems strange.";
		}
		if (aName.isEmpty())
		{
			aName="Unidentified object";
			aDescription="This object seems strange and come from nowhere";
		}
		name=aName;
		description=aDescription;
		lock = aLock;
	}
	
	/**
	 * This method returns the name of the chest.
	 * @return String name of chest
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method returns the description of the chest.
	 * @return String description of chest
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
	 * This method opens the inventory if the key you try to use is the good one
	 * @param key Key : the key you want to try
	 * @return True if it is the correct key and false if it is a wrong key
	 * 
	 */
	public boolean openChest(Key key)
	{
		if (lock.unlock(key) == true)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
     * This method allow to add or remove money (by minus int) from the inventory
     * @param money the money you try to add
     * @return If the money can be add or not : depending if the chest is open or not
     */
    public boolean manageGold(int money) 
    {
        if(lock.getLock() == false)
        {
        	return super.manageGold(money);
        }
        else
        {
        	return false;
        }
    }
    
    /**
     * This method deletes one item in a chest.
     * New method for chest : test if the chest is open or not
     * @param item: The item deleted to the inventory
     * @return True if it works or false if it don't (chest close)
     */
    public boolean deleteItem(Item itemToDelete) {
    	if(lock.getLock() == false)
        {
        	super.deleteItem(itemToDelete);
        	return true;
        }
        else
        {
        	return false;
        }
    }
}
