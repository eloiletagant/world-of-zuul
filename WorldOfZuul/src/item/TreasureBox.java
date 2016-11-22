package item;

import room.Lock;

/**
 * The TreasureBox class stand for an box which contains item's player
 * <p> to this class, the player can to : </p>
 * <ul>
 * <li> open the box <li>
 * <li> CHeck the items which are in the box <li>
 * <li> Obtains the padlock <li>
 *  </ul>
 * @author Group4
 * @version 22/11/2016
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
	 * @param aLock Lock : Locked of the chest
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
	 * @return: return true if is the correct key and false if is the false key
	 * 
	 */
	public boolean open(Key aKey)
	{
		return true;
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
