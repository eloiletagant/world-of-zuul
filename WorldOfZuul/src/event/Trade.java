package event;

import java.lang.Math;

import character.Character;
import character.NPC;
import item.Item;


/**
 * This class manages a trade between two characters.
 * It is possible to :
 * sell an item
 * buy an item
 * get an item
 *
 * @author Group4
 * @version 10/11/2016
 */
public class Trade extends Event {

    /**
     * Constructor of a trade
     */
    public Trade(String description, Item item, Character player, NPC trader) {
        super(description, item, player, trader);
    }

    /**
     * method to buy an item to a NPC
     * @param player
     * @param trader
     * @param item
     * @param price
     */
    private void buy(Character player, NPC trader, Item item, int price) {
        //for the player
        player.getInventory().manageGold(-price);
        player.getInventory().addItem(item);
        //for the NPC
        trader.getInventory().deleteItem(item);
    }

    /**
     * method to sell an item for 80% of the price to a NPC
     * @param player
     * @param trader
     * @param item
     * @param price
     */
    private void sell(Character player, NPC trader, Item item, int price) {
        //for the player
        player.getInventory().manageGold(Math.round((price * 8) / 10));
        player.getInventory().deleteItem(item);
        //for the NPC
        trader.getInventory().addItem(item);
    }
}
