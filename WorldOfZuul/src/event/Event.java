package event;

import item.Item;
import character.Character;

/**
 * This class will create an event (enigma, fight, or trade)
 *
 * @author Group 4
 * @version 10/11/2016
 */
public class Event {
    protected String description;
    protected Item item;
    protected Character player;

    /**
     * Constructor of the class event.
     */
    public Event(String description, Item item, Character player) {
        this.description = description;
        this.item = item;
        this.player = player;
    }

    /**
     * This method will give an item to the character after a win event.
     */
    public Item getItem() {
        return item;
    }

    /**
     * This method will set a new item for the event item.
     */
    public void setItem(Item item) {
        this.item = item;
    }

}