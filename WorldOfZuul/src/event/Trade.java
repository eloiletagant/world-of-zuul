package event;

import character.Character;
import character.NPC;
import item.Item;
import item.Inventory;


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

    private Character trader;

    /**
     * Constructor of a trade
     */
    public Trade(String description, Item item, Character player, NPC trader) {
        super(description, item, player);
        this.trader = trader;
    }

    private void buy(Character player, NPC trader, Item item, int price) {
        player.getInventory().manageGold(price);
        Inventory.addItem(Inventory.item);
    }

    private void sell() {
        Inventory.addGold(Item.getPrice());
        Inventory.deleteItem(Inventory.item);
    }

}
