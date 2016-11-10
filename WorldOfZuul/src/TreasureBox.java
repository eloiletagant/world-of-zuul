/**
 * 
 * @author gp4
 * This class manage treasure boxes. Boxes contains mmany items and are protected by a Lock
 *
 */
public class TreasureBox extends Item{
	
	private Inventory theItems;
	private Lock blockingLock;
	
	/**
	 * Constructor of the class
	 * @param newName String : name of the item
	 * @param desc String : description of the item and it's effects
	 * @param pric Int : price of the item
	 * @param sell Boolean : is the item sellAble
	 * @param aLock Lock : Locket of the chest
	 */
	public TreasureBox(String newName, String desc, int pric, boolean sell, Lock aLock)
	{
		super(newName, desc, pric, sell);
		theItems = new Inventory();
		blockingLock = aLock;
	}
	
	/**
	 * This method open the chest if the key you try to use is the good one
	 * @param aKey Key : the key you want to try
	 */
	public void open(Key aKey)
	{
		
	}
	
	/**
	 * This method return the chest inventory if the chest is open
	 * @return the chest inventory
	 */
	public Inventory getInventory()
	{
		return theItems;
	}
	
	/**
	 * Access to the chest locket
	 * @return Lock : chest locket
	 */
	public Lock getLock()
	{
		return blockingLock;
	}
}
