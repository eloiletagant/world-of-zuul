package item;

/**
 * This class manages weapons which are in the inventory of the character. 
 * <p> Thanks to this class the player is able to : <:p>
 * <ul>
 * <il> check if the weapons is onehand or not <il>
 * <il> check the weapon's damages <il>
 * <il> Equipe with an weapon <il>
 * <il> put the weapon <il>
 * </ul>
 * @author Group 4
 * @version 22/11/2016
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
	 * This method allows the character to equip this weapon.
	 * @return true if the player is equip, else return false
	 */
	public void equip()
	{
		equiped = true;
	}
	
	/**
	 * This method allows the character to unequip this weapon.
	 * @return false if the player is unequip
	 */
	public void unequip()
	{
		equiped = false;
	}
}
