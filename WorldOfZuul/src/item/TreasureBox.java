package item;

import room.Lock;

/**
 * The TreasureBox class stand for an box which contains item's player
 * <p> to this class, the player can to : </p>
 * <ul>
 * <li> open the box </li>
 * <li> CHeck the items which are in the box </li>
 * <li> Obtains the padlock </li>
 * </ul>
 * @author Group4
 * @version 22/11/2016
 * 
 */
public class TreasureBox extends Item{
	
	private Inventory inventory;
	private Lock lock;
	
	/**
	 * Constructor of the class
	 * @param name String : name of the item
	 * @param description String : description of the item and it's effects
	 * @param price Int : price of the item
	 * @param canBeSold Boolean : is the item sellAble
	 * @param aLock Lock : Locked of the chest
	 */
	public TreasureBox(String name, String description, int price, boolean sellAble, Lock lock)
	{
		super(name, description, price, sellAble);
		inventory = new Inventory();
		this.lock = lock;
	}
	
	/**
	 * This method open the chest if the key you try to use is the good one
	 * @param key Key : the key you want to try
	 * @return: return true if is the correct key and false if is the false key
	 * 
	 */
	public boolean openTreasureBox(Key key) {
		boolean done = false;
		//code here
		return done;
	}
	
	/**
	 * add the item in the inventory
	 * @param item
	 */
	public void addToInventory(Item item) {
		//add an item
	}
	
	/**
	 * remove from the inventory
	 */
	public void removeFromInventory(Item item) {
		//remove the item
	}
	
	/**
	 * This method return the chest inventory if the chest is open
	 * @return the chest inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * Access to the chest locket
	 * @return Lock : chest locket 
	 */
	public Lock getLock() {
		return lock;
	}
}
