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
	 */
	public Weapon(String newName, String aDescription, int aPrice, boolean sell, int nbDamage)
	{
		super(newName,aDescription,aPrice,sell);
		if (nbDamage<0)
		{
			nbDamage=2;
		}
		damages = nbDamage;
		equiped = false;
	}
	
	/**
	 * This method returns if the weapon is already use by a player
	 * @return  a boolean true if the weapon is equipped by a character.
	 */
	public boolean getEquiped()
	{
		return equiped;
	}
	
	/**
	 * This method returns the number of damages of a weapon.
	 * @return integer : number of damages of the weapon
	 */
	public int getDamages()
	{
		return damages;
	}
	
	/**
	 * This method allows the character to equip or unequip a weapon.
	 * 
	 */
	public void equip()
	{
		if (this.getEquiped()==false)
		{
			equiped=true;
		}
		else
		{
			equiped=false;
		}
	}
	
	/**
	 * This method adds damages to the weapon
	 * @param bonusDamages damages to add to this weapon
	 */
	public void addDamages(int bonusDamages)
	{
		if(bonusDamages > 0)
		{
			damages += bonusDamages;
		}
	}
	
}
