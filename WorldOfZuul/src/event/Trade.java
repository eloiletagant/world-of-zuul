package event;
import item.Item;
import item.Inventory;
import character.NPC;

/**
 * This method manages a trade between a character and a NPC.
 * @author Group4
 * @version 10/11/2016
 *   
 */
public class Trade extends Event
{
	private NPC aSeller;
	
	/**
	 * Constructor of a trade
	 */
	public Trade()
	{ 
		
	}
	
	private void buy()
	{
		Inventory.removeGold(Item.getPrice());
		addItem(Inventory.item);
	}
	
	private void sell ()
	{
		addGold(Item.getPrice);
		deleteItem(Inventory.item);
	}

}
