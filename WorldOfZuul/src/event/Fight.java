package event;

import character.*;
import character.NPC;
import item.*;

/**
 * This class manages a fight between a character and a NPC.
 *
 * @author Group4
 * @version 10/11/2016
 */
public class Fight extends Event {
    private boolean isWin;

    /**
     * Constructor of a fight
     *
     * @param description String description of the event
     * @param item        Item which can be get by the player, or trade
     * @param player      Character the player of the game
     * @param npc         NPC which is involved in the event
     */
    public Fight(String description, Item item, Player player, NPC npc) {
        super(description, item, player, npc);
        isWin = false;
    }

    public boolean getResult()
    {
    	return isWin;
    }
    //the methods will be created during the implementation of the game
    /**
     * 
     * @param clicks < clickRequired
     * @param clicksRequireds > clicks
     * @return return the result of the fight : true = win, false = loose
     */
    public boolean runFight(int clicks, int clicksRequireds)
    { 
    	int playerDamages = 1;
    	int npcDamages = 1;
    	for(Item test : this.getPlayer().getInventory().getItems())
    	{
    		if(test instanceof Weapon)
    		{
    			if(((Weapon) test).getEquiped())
    			{
    				playerDamages +=((Weapon) test).getDamages() + this.getPlayer().getBonusDamages();
    			}
    		}
    	}
    	
    	for(Item test : this.getNpc().getInventory().getItems())
    	{
    		if(test instanceof Weapon)
    		{
    			if(((Weapon) test).getEquiped())
    			{
    				npcDamages +=((Weapon) test).getDamages() + this.getNpc().getBonusDamages();
    			}
    		}
    	}
    	
    	playerDamages = (int)((float) playerDamages * (1.0 + ((float) clicks /clicksRequireds)));
    	while(this.getPlayer().getHealth() > 0 && this.getNpc().getHealth() > 0)
    	{
    		this.getPlayer().manageHealth(-npcDamages);
    		//System.out.println("You lost " + npcDamages + " hp");
    		//System.out.println(this.getPlayer().getHealth());
    		this.getNpc().manageHealth(-playerDamages);
    		//System.out.println("The enemy lost " + playerDamages + " hp");
    		//System.out.println(this.getNpc().getHealth());
    	}
    	if(this.getPlayer().getHealth() == 0)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    	
    }

}