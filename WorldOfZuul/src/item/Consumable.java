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
	public Consumable(String newName, String aDescription, int aPrice, boolean sell,String anEffect)
	{
		super(newName,aDescription,aPrice,sell);
		if (anEffect.isEmpty())
		{
			anEffect = "This consumable has no effect.";
		}
		effect = anEffect;
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
	private void use()
	{
		
	}
}
