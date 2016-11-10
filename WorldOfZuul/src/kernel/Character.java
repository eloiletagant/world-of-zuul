package kernel;
/**
 * This class describes and manages a character.
 * 
 * @author Groupe4
 * @version 10/11/2016
 *
 */
public class Character
{
	private String name;
	private int health;
	private Inventory inventory;
	private Room location;
	private int nbHandsAvailable;

	/**
	 * Constructor to create a character.
	 */
	public Character(String name){
		
	}
	
	/**
	 * This method displays the number of hands which is avaiblable of a character.
	 */
	public int getNbHandsAvailable()
	{
		return nbHandsAvailable;
	}
	
	/**
	 * This method displays the name of the charcater.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method displays the number of health point of a charcater.
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**
	 * This method add a number of health point for a charcater.
	 */
    public void addHealth(int hp)
    {
    	
    }
    
	/**
	 * This method removes a number of health point for a charcater.
	 */
    public void removeHealth(int hp)
    {
 
    }
				
	/**
	 * This method displays the inventory of the character.
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
}
