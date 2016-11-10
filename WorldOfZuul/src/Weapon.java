/**
 * This class manages weapons which are in the inventory of the character. 
 * 
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class Weapon extends Item{

	private int damages;
	private boolean oneHand;
	private boolean equiped;
	
	/**
	 * constructor of the class weapon.
	 * 
	 * @param newName	name of the weapon
	 * @param desc		description of the weapon
	 * @param pric		price of the weapon
	 * @param sell		true if the weapon is able to sell
	 * @param dmg		damages induced by the weapon
	 * @param hand		true if the weapon needs just one hand to be equipped. 
	 */
	public Weapon(String newName, String desc, int pric, boolean sell,int dmg, boolean hand)
	{
		super(newName,desc,pric,sell);
		damages = dmg;
		oneHand = hand;
		equiped = false;
	}
	
	/**
	 * This method returns a boolean true if 
	 * @return
	 */
	public boolean getOneHand()
	{
		return oneHand;
	}
	
	/**
	 * This method returns a boolean true if the weapon is equipped by a character.
	 * @return
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
	 * This method allows the character to equip this weapon.
	 */
	public void equip()
	{
		equiped = true;
	}
	
	/**
	 * This method allows the character to unequip this weapon.
	 */
	public void unequip()
	{
		equiped = false;
	}
}
