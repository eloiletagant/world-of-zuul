package event;

import item.Item;
import character.*;
import character.NPC;

/**
 * This class will create an event (enigma, fight, or trade)
 *
 * @author Group 4
 * @version 10/11/2016
 */
public abstract class Event {
    private String description;
    private Item item;
    private Player player;
    private NPC npc;

    /**
     * Constructor of the class event.
     *
     * @param description String description of the event
     * @param item        Item which can be get by the player, or trade
     * @param player      Character the player of the game
     * @param npc         NPC which is involved in the event
     */
    public Event(String aDescription, Item anItem, Player aPlayer, NPC aNpc) 
    {
    	if(aDescription.isEmpty())
    	{
    		aDescription = "You have no idea about what's happening";
    	}
        description = aDescription;
        item = anItem;
        player = aPlayer;
        npc = aNpc;
    }

    /**
     * This method will give the description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method will give an item to the character after a win event.
     */
    public Item getItem() {
        return item;
    }

    /**
     * This method will give the player involved in the event.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * This method will give the npc involved in the event.
     */
    public NPC getNpc() {
        return npc;
    }

    /**
     * This method will set a new item for the event item.
     */
    public void setItem(Item newItem) {
        item = newItem;
    }


}