package item;

import java.util.ArrayList;

/**
 * This class manages all items of a character in an inventory.
 *
 * @author Group4
 * @version 22/11/2016
 */
public class Inventory {
    // an array of items
    private ArrayList<Item> items;
    // money of a player
    private int gold;
    // number maximum of items in the inventory
    private int maxItems;


    /**
     * Constructor by default of an inventory
     *
     * @param nbMaxItems int : number max of items in the inventory
     *                   By default the inventory has any item.
     */
    public Inventory(int nbMaxItems) {
        items = new ArrayList<Item>();
        gold = 100;
        maxItems = nbMaxItems;
    }

    /**
     * Constructor used only to create a chest
     *
     * @param nbMaxItems int : number max of items in the inventory
     * @param gold       int : number of gold in the inventory
     *                   By default the inventory has any item.
     */
    public Inventory(int nbMaxItems, int golds) {
        items = new ArrayList<Item>();
        if (golds < 0) {
            golds = 0;
        } else {
            gold = golds;
        }
        if (nbMaxItems < 0) {
            maxItems = 10;
        } else {
            maxItems = nbMaxItems;
        }
    }


    /**
     * This method returns a list of item from the inventory - simple accessor
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    
    /**
     * This method returns the number of items in the inventory - simple accessor
     */
    public int getNbItems() {
        return this.getItems().size();
    }

    /**
     * This method returns gold from the inventory of a character - simple accessor
     */
    public int getGold() {
        return gold;
    }

    /**
     * @return the maxItems
     */
    public int getMaxItems() {
        return maxItems;
    }


    /**
     * This method allow to add or remove money (by minus int) from the inventory
     */
    public boolean manageGold(int money) {
        if (gold + money > 0) {
            gold += money;
            return true;
        } else
            return false;
    }

    /**
     * This method deletes all items in an inventory.
     */
    public void resetInventory() {
        items.clear();
    }

    /**
     * This method deletes one item in an inventory.
     *
     * @param item: The item deleted to the inventory
     * @return true if the item is correctly delete
     */
    public boolean deleteItem(Item itemToDelete) {
        items.remove(itemToDelete);
        return true;
    }

    /**
     * This method adds one item in an inventory.
     *
     * @param item: The item added to the inventory
     * @return true if the item is correctly add, false if not
     */
    public boolean addItem(Item itemToAdd) {
        if (items.size() == this.getMaxItems()) {
            return false;
        } else if (items.contains(itemToAdd)) {
            return false;
        } else {
            items.add(itemToAdd);
            return true;
        }
    }
}
