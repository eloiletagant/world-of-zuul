package event;

import character.Character;
import character.NPC;
import item.Item;

/**
 * This class manages a fight between a character and a NPC.
 *
 * @author Group4
 * @version 10/11/2016
 */
public class Fight extends Event {
    private boolean isWin;

    /**
     * Constructor of a fight
     *
     * @param description String description of the event
     * @param item        Item which can be get by the player, or trade
     * @param player      Character the player of the game
     * @param npc         NPC which is involved in the event
     */
    public Fight(String description, Item item, Character player, NPC npc) {
        super(description, item, player, npc);
        isWin = false;
    }

    //the methods will be created during the implementation of the game

}