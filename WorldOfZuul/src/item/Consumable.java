package item;

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
	 * Constructor of the Consumable class
	 * If the given name is a null string, the name is "Unidentified object".
	 * If the given description is a null string, the description is "This object seems strange".
	 * If the given price is negative, the price is 100 gold.
	 * If the given effect is a null string, the effect is "This consumable has no effect".
	 * If given HPcare and increaseDamage are negative, they will be equals to 0.
	 * 
	 * @param newName String		name of the item
	 * @param aDescription String	description of the item
	 * @param aPrice Int			price of the item
	 * @param sell Boolean			true if the item can be sell
	 * @param anEffect String		effect of the item
	 */
	public Consumable(String newName, String aDescription, int aPrice, boolean sell, String anEffect, int HPcare, int HPdamage, boolean inWeapon)
	{
		super(newName,aDescription,aPrice,sell);
		if (HPcare<0)
		{
			care=0;
		}
		else
		{
			care=HPcare;
		}
		if (HPdamage<=0)
		{
			increaseDamage=0;
			weapon=false;
		}
		else
		{
			increaseDamage=HPdamage;
			weapon=inWeapon;
		}
		if ((newName.isEmpty() || (anEffect.isEmpty())) || (care==0 && increaseDamage==0))
		{
			effect = "This consumable has no effect";
		}
		else
		{
			effect = anEffect;
		}
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
	 *  This method returns the number of health points which will be cared when a player uses this consumable - simple accessor
	 * @return int	number of health points cared
	 */
	public int getCare()
	{
		return care;
	}
	
	/**
	 *  This method returns the number of damages which will be added to the damages of the player who used this consumable - simple accessor
	 * @return int	number of damages added
	 */
	public int getDamage()
	{
		return increaseDamage;
	}
	
	/**
	 *  This method returns a boolean : - simple accessor
	 *  - true if the damages are increased to the weapon of a player
	 *  - false if damages are increased to the player
	 * @return String	weapon or player
	 */
	public boolean getWeapon()
	{
		return weapon;
	}
}
