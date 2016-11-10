
public class TreasureBox extends Item{
	
	private Inventory theItems;
	private Lock blockingLock;
	
	public TreasureBox(String newName, String desc, int pric, boolean sell, Lock aLock)
	{
		super(newName, desc, pric, sell);
		theItems = new Inventory();
		blockingLock = aLock;
	}
	
	public void open()
	{
		
	}
	
	public Inventory getInventory()
	{
		return theItems;
	}
	
	public Lock getLock()
	{
		return blockingLock;
	}
}
