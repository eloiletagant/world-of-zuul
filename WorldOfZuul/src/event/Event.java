package event;

import item.Item;

/**
 * This class will create an event (enigma, fight, or trade)
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class Event
{
	protected String description;
	protected Item loot;
	protected Character player;
	
	/**
	 * Constructor of the class event.
	 */
	public Event(String description, Item loot, Character player) {
		this.description = description;
		this.loot = loot;
		this.player = player;
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
	public void setLoot(Item loot) {
	
	}

}