package character;

/**
 * This class describes and manages a NPC.
 * A NPC can be an enemy or a friend. By default NPC are enemies.
 * He have a name and other parameter of a class Character.
 * A NPC may have more than 2 hands (4 max) it allows him to wear more weapons 
 * A NPC have no HP limit, but he can't heal himself. 
 * His functions are redefined compare to a normal Character to respect this.
 * 
 * @author Groupe4
 * @version 10/11/2016
 *
 */

public class NPC extends Player
{

    private boolean enemy; //indicate if the NPC is friendly or not.
	
	/**
     * Constructor for NPC
     * If the name is a null string, the given name is "Attila".
     * The NPC has between O and 4 hands and they are available to wear weapons at the beginning of the game.
     * The minimum number of health points of a NPC is 5 and there is no maximum.
     * He has an empty inventory with 10 locations.
     * He starts the game at the Home Room.
	 * At the beginning, the damage bonus are set to 0 by default. It will be change when using some items like weapons or potions.
	 * @param String	name
	 * @param int 		hp : number of health points
	 * @param int		nbHands : number of hands
	 * @param boolean	isEnemy : true if enemy, false if not
	 */
	public NPC(String name, int hp, int nbHands, boolean isEnemy)
	{
		super(name,hp,nbHands);
		enemy=isEnemy;
	}
	
	/**
	 * This method returns an boolean true if the NPC can fight a character.
	 * Boolean false if the NPC can trade with the character
	 * @return boolean enemy
	 */
	public boolean getEnemy()
	{
		return enemy;
	}
	
	/**
	 * This method is used to modify the enemy attribute in true or false. 
	 */
	public void swapFriendShip()
	{
		if (enemy==true)
		{
			enemy = false;
		}
		else
		{
			enemy = true;
		}
    }
	
	
	/**
	 * This methods delete Health to a NPC (Only negative values are accepted because an NPC can not heal)
	 * @param hp Negative value : damages taken by the NPC
	 */
	public void manageHealth(int hp)
	{
		if(hp < 0)
		{
			super.manageHealth(hp);
		}
	}
}
