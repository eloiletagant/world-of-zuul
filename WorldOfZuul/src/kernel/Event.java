package kernel;
/**
 * This class will create an event (enigma, fight, or trade)
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class Event
{
	private String description;
	private Item loot;
	
	/**
	 * Constructor of the class event.
	 */
	public Event()
	{
			
	}

	/**
	 * This method will give an item to the character after a win event.
	 */
	public Item getLoot() {
		return loot;
	}
	
	/**
	 * This method will set a new item for the event loot.
	 */
	public Item setLoot(Item loot) {
	}

}