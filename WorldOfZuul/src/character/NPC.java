package character;

/**
 * This class describes and manages a NPC.
 * A NPC can be an enemy or a friend.
 * He have a name and other parameter of a class Character. 
 * 
 * @author Groupe4
 * @version 10/11/2016
 *
 */

public class NPC extends Character{
	
	private boolean enemy; //indicate if the npc is friendly or not 
	
	/**
	 * Function NPC he change the name in the class Character.
	 * @param String name
	 */
	public NPC(String name){
		super(name);
	}
	
	/**
	 * This method returns an boolean true if the NPC can fight a character.
	 * @return boolean enemy
	 */
	public boolean getEnemy()
	{
		return enemy;
	}

}
