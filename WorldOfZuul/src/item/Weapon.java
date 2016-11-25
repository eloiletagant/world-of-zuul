package item;

/**
 * This class manages weapons which are in the inventory of the character. 
 * <p> Thanks to this class the player is able to : <p>
 * <ul>
 * <li> check if the weapons is onehand or not <li>
 * <li> check the weapon's damages <li>
 * <li> Equip with an weapon <li>
 * <li> put the weapon <li>
 * </ul>
 * @author Group 4
 * @version 22/11/2016
 *
 */
public class Weapon extends Item
{
	private int damages;
	private boolean oneHand;
	private boolean equiped;
	
	/**
	 * Constructor of the Weapon class
	 * If the given name is a null string, the name is "Unidentified object".
	 * If the given description is a null string, the description is "This object seems strange".
	 * If the given price is negative, the price is 100 gold.
	 * If the given nbDamage is negative, it will be equals to 0.
	 * 
	 * @param newName String		name of the item
	 * @param aDescription String	description of the item
	 * @param aPrice Int			price of the item
	 * @param sell Boolean			true if the item can be sell
	 * @param nbDamage Int			damages induced by the weapon
	 * @param hand					true if the weapon needs just one hand to be equipped. 
	 */
	public Weapon(String newName, String aDescription, int aPrice, boolean sell, int nbDamage, boolean hand)
	{
		super(newName,aDescription,aPrice,sell);
		if (nbDamage<0)
		{
			nbDamage=2;
		}
		damages = nbDamage;
		oneHand = hand;
		equiped = false;
	}
	
	/**
	 * This method check if the weapon is an onehand
	 * @return true if the weapon is an oneHand, else return false
	 */
	public boolean getOneHand()
	{
		return oneHand;
	}
	
	/**
	 * This method check if th weapon is already use by a player
	 * @return  a boolean true if the weapon is equipped by a character.
	 */
	public boolean getEquiped()
	{
		return equiped;
	}
	
	/**
	 * This method returns the number of damages of a weapon.
	 * @return
	 */
	public int getDamages()
	{
		return damages;
	}
	
	/**
	 * This method allows the character to equip a weapon.
	 * @param eq : boolean true if the weapon is equipped.
	 */
	public void equip(boolean eq)
	{
		equiped = eq;
	}
	
}
