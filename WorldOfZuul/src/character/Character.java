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
 *
 */
public class Character
{
	private String name; //Name of the character. If empty, it will be Zuul by default
	private int health; //Start with 20 HP by default. The character die when his hp felt to 0
	private Inventory inventory; //All items of the char are present on the inventory
	private Room location; //Position of the character
	private int nbHandsAvailable; //Number of hands open to wear weapons : 2 by default and max, and never < 0
	private int maxHealth; // the maximum hp of the character (20) nobody can have maxhp < 5
	private int maxHands;
	private int damagesBonus;
	/**
	 * basic constructor
	 */
	public Character(String newName)
	{
		if(newName.equals(""))
		{
			name = "Zuul";
		}
		else
			name = newName;
		health = 20;
		inventory = new Inventory(10);
		nbHandsAvailable = 2;
		//set up a start room (useful for test)
		location = new Room("Home",0);
		maxHealth = 20;
		maxHands = 2;
		damagesBonus = 0;
	}
	
	/**
	 * Special constructor
	 */
	public Character(String newName,int hpMax, int nbHandsMax)
	{
		if(name.equals(""))
		{
			name = "Zuul";
		}
		else
			name = newName;
		
		if(nbHandsMax < 0)
			maxHands = 0;
		else if(nbHandsMax > 4)
			maxHands = 4;
		else
			maxHands = nbHandsMax;
		nbHandsAvailable = maxHands;
		
		if(hpMax < 5)
		{
			maxHealth = 5;
		}
		else 
			maxHealth = hpMax;
		health = maxHealth;
		
		inventory = new Inventory(10);
		//set up a start room (useful for test)
		location = new Room("Home",0);
		damagesBonus = 0;
	}
	
	/**
	 * This method returns the number of hands which is available for a character.
	 */
	public int getNbHandsAvailable()
	{
		return nbHandsAvailable;
	}
	
	/**
	 * This method returns the name of the character.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method returns the number of health point of a charcater.
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
	 * This method displays the room where the character is.
	 */
	public Room getLocation()
	{
		return location;
	}
	
	/**
	 * This method modify HP of the character
	 * @param hp HP added to the character. Negative value to take damages. HP max are 20
	 */
	public void addHealth(int hp)
	{
		if(health + hp > maxHealth)
			health = maxHealth;
		else if(health + hp < 0)
			health = 0;
		else 
			health += hp;
	}
	
	/**
	 * Move the character into another room
	 * @param newRoom The room the player will be in
	 */
	public void moveRoom(Room newRoom)
	{
		location = newRoom;
	}
	
	/**
	 * Calculate the new number of hands available to wear weapons
	 * @param nbr number of hand of the new weapon (positive : unequip, negative to equip weapon)
	 * @return true : the weapon can be equiped / unequiped; false : it cant
	 */
	public boolean swapWeapon(int nbr)
	{
		if(nbHandsAvailable + nbr > maxHands)
		{
			nbHandsAvailable = maxHands;
			return true;
		}
		else if(nbHandsAvailable + nbr < 0)
		{
			return false;
		}
		else
		{
			nbHandsAvailable += nbr;
			return true;
		}
	}
	
	/**
	 * 
	 */
	public int getBonusDamages()
	{
		return damagesBonus;		
	}
	
	public void addBonusDamages(int bonus)
	{
		
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public int getMaxHands()
	{
		return maxHands;
	}
}
