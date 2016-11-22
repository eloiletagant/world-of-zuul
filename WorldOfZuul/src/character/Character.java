package character;

import item.Inventory;
import room.Room; 

/**
 * This class describes and manages a character.
 * We can get the character position, his HP, his name and his inventory. 
 * A character can lose HP and retrieve it.
 * The HP can't rise over 20.
 * When his HP felt to 0, the character die. 
 *  
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
	private int nbHandsAvailable; //Number of hands open to wear weapons

	/**
	 * Constructeur de la classe
	 */
	public Character(String newName)
	{
		if(name.equals(""))
		{
			name = "Zuul";
		}
		else
			name = newName;
		health = 20;
		inventory = new Inventory();
		nbHandsAvailable = 2;
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
	public void setHealth(int hp)
	{
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
	
}
