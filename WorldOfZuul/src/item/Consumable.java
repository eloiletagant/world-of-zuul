package item;
import character.Character;

/**
 * This class manages consumables.
 * Consumables may have different effects and are destroyed when they are used.
 * A consumable can be a potion which get or lose health point to the player.
 * It can also increase the strength of a player.
 * @author Group 4
 * @version 22/11/2016
 * 
 */
public class Consumable extends Item
{
	// description of the effect of a consumable
	private String effect;
	// number of health care point
	private int care;
	// number of health point to increase the damage
	private int increaseDamage;
	// the increase damage can be apply to a weapon (true) or a character (false)
	private boolean weapon;
	
	/**
	 * Constructor of Consumable class.
	 * If the name is a null string, the given name is "Potion".
	 * 
	 * @param newName String		name of the item
	 * @param aDescription String	description of the item
	 * @param aPrice Int			price of the item
	 * @param sell Boolean			true if the item can be sell
	 * @param anEffect String		effect of the item
	 */
	public Consumable(String newName, String aDescription, int aPrice, boolean sell,String anEffect, int HPcare, int HPdamage, boolean inWeapon)
	{
		super(newName,aDescription,aPrice,sell);
		if (HPcare < 0)
		{
			HPcare=0;
			inWeapon=false;
		}
		if (HPdamage < 0)
		{
			HPdamage=0;
		}
		if ((anEffect.isEmpty()) || (HPcare==0 && HPdamage==0))
		{
			anEffect = "This consumable has no effect.";
		}
		effect = anEffect;
		care=HPdamage;
		increaseDamage=HPcare;
		weapon=inWeapon;
	}
	
	/**
	 *  This method returns an effect - simple accessor
	 * @return String	effect of this consumable
	 */
	public String getEffect()
	{
		return effect;
	}
	
	/**
	 * This method allows using the item.
	 * The effect will apply to the player or the weapon who used it.
	 * The item is destroyed automatically.
	 */ 
	private void use(Character aCharacter, Consumable itemUsed)
	{
		//applique les effets sur le joueur
		if (care > 0)
		{
			aCharacter.addHealth(care);
		}
		else if (increaseDamage > 0)
		{
			if (weapon == true)
			{
				
			}
			else
			{
				aCharacter.
			}

		}
		//delete an item in the inventory
		Inventory.deleteItem(itemUsed);
	}
}
