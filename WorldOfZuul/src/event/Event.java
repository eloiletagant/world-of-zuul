package event;

import item.Item;
import character.Character;
import character.NPC;

/**
 * This class will create an event (enigma, fight, or trade)
 *
 * @author Group 4
 * @version 10/11/2016
 */
public class Event {
    private String description;
    private Item item;
    private Character player;
    private NPC npc;

    /**
     * Constructor of the class event.
     */
    public Event(String description, Item item, Character player, NPC npc) {
        this.description = description;
        this.item = item;
        this.player = player;
        this.npc = npc;
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
    public Character getPlayer() {
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
    public void setItem(Item item) {
        this.item = item;
    }


}