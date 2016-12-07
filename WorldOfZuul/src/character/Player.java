package character;
import item.Inventory;
import room.Room;

/**
 * This class describes and manages a character.
 * We can get the character position, his HP, his name and his inventory.
 * A character can lose HP and retrieve it.
 * The HP can't rise over 20.
 * When his HP felt to 0, the character die.
 * He have two hands. Here is the number of hands available counter : 0 ==> 2
 *
 * @author Groupe4
 * @version 10/11/2016
 */
public class Player {
    private String name; //Name of the character. If empty, it will be Zuul by default
    private int health; //Start with 20 HP by default. The character die when his hp felt to 0
    private Inventory inventory; //All items of the character are present on the inventory
    private Room location; //Position of the character
    private int maxHealth; // the maximum hp of the player (20) nobody can have maxhp < 5
    private int maxHands;// [0,4]
    private int damagesBonus;// [-5,5]

    /**
     * Basic constructor used when creating a Player
     * If the name is a null string, the given name is "Kaamelott".
     * The number of health points of a player is 20 and he can not have more than 20 health points if he uses potions.
     * He has an empty inventory with 10 locations.
     * The player has 2 hands and they are available to wear weapons at the beginning of the game.
	 * He starts the game at the Home Room.
	 * At the beginning, the damage bonus are set to 0 by default. It will be change when using some items like weapons or potions.
     */
    public Player(String newName, int maxHealth)
    {
        if (newName.equals(""))
        {
            name = "Kaamelott";
        }
        else
        {
            name = newName;
        }
        this.maxHealth = maxHealth;
        health = 20;
        inventory = new Inventory(10);
        //set up a start room (useful for test)
        location = new Room("Home", 0);
        maxHands = 2;
        damagesBonus = 0;
    }

    /**
     * Special constructor used when creating a NPC
     * If the name is a null string, the given name is "Attila".
     * The NPC has between O and 4 hands and they are available to wear weapons at the beginning of the game.
     * The minimum number of health points of a NPC is 5 and there is no maximum.
     * He has an empty inventory with 10 locations.
     * He starts the game at the Home Room.
	 * At the beginning, the damage bonus are set to 0 by default. It will be change when using some items like weapons or potions.
     */
    public Player(String newName, int hpMax, int nbHandsMax) 
    {
        if (newName.equals(""))
        {
            name = "Attila";
        }
        else
        {
            name = newName;
        }
        if (nbHandsMax < 0)
        {
            maxHands = 0;
        }
        else if (nbHandsMax > 4)
        {
            maxHands = 4;
        }
        else
        {
            maxHands = nbHandsMax;
        }
        nbHandsAvailable = maxHands;
        if (hpMax < 5)
        {
            maxHealth = 5;
        }
        else
        {
        	maxHealth = hpMax;
        }
        health = maxHealth;
        inventory = new Inventory(10);
        //set up a start room (useful for test)
        location = new Room("Home", 0);
        damagesBonus = 0;
    }

    /**
     * This method returns the name of the character.
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method returns the number of health points of a character.
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * This method returns the inventory of the character.
     */
    public Inventory getInventory()
    {
        return inventory;
    }

    /**
     * This method returns the room where the character is.
     */
    public Room getLocation()
    {
        return location;
    }
    
    /**
     * This methods returns the maximum number of health points of a character.
     */
    public int getMaxHealth() 
    {
        return maxHealth;
    }

    /**
     * This method returns the maximum number of hands of a character.
     */
    public int getMaxHands()
    {
        return maxHands;
    }
    
    /**
     * This method returns the bonus damage of a character.
     */
    public int getBonusDamages()
    {
        return damagesBonus;
    }

    /**
     * This method modifies HP of the character
     *
     * @param hp HP added to the character. Negative value to take damages. HP max are 20
     */
    public void manageHealth(int hp)
    {
        if (health + hp > maxHealth)
        {
            health = maxHealth;
        }
        else if (health + hp < 0)
        {
        	health = 0;
        }
        else
        {
            health += hp;
        }
    }

    /**
     * Move the character into another room
     *
     * @param newRoom The room the player will be in
     */
    public void moveRoom(Room newRoom)
    {
        location = newRoom;
    }

    /**
     * Add or remove some damages to the character
     *
     * @param bonus negative ==> diminution of damages. Can not be over 5 and under -5
     */
    public void manageBonusDamages(int bonus)
    {
        if (damagesBonus + bonus > 5)
        {
            damagesBonus = 5;
        }
        else if (damagesBonus + bonus < -5)
        {
        	damagesBonus = -5;
        }
        else
        {
        	damagesBonus += bonus;
        }
    }
}
