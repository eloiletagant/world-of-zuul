package kernel;
/**
 * This class describes and manages a NPC.
 * 
 * @author Groupe4
 * @version 10/11/2016
 *
 */
public class NPC extends Character{
	
	private boolean enemy; //indicate if the npc is friendly or not 
	
	public NPC(String name){
		super(name);
	}
	/**
	 * This method returns an boolean true if the NPC can fight a character.
	 * @return
	 */
	public boolean getEnemy()
	{
		return enemy;
	}

}
