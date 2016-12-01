package event;

import java.lang.Math;

import character.*;
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
    public Trade(String description, Item item, Player player, NPC trader) {
        super(description, item, player, trader);
    }

    /**
     * method to buy an item to a NPC
     * @param player
     * @param trader
     * @param item
     * @param price
     * @return True = the trade works, False = the trade didn't works
     */
    public boolean buy(Player player, NPC trader, Item item, int price) {
    	if(price >= player.getInventory().getGold() && player.getInventory().getItems().size() < player.getInventory().getMaxItems())
    	{
            //for the player
            player.getInventory().manageGold(-price);
            player.getInventory().addItem(item);
            //for the NPC
            trader.getInventory().deleteItem(item);
            return true;
    	}
    	return false;
    }

    /**
     * method to sell an item for 80% of the price to a NPC
     * @param player
     * @param trader
     * @param item
     * @param price
     */
    public void sell(Player player, NPC trader, Item item, int price) {
        //for the player
        player.getInventory().manageGold(Math.round((price * 8) / 10));
        player.getInventory().deleteItem(item);
        //for the NPC 
        trader.getInventory().addItem(item);
    }
}
