/**
 * This class manages consumables. Consumables may have different effects and are destroyed when they are used.
 * @author Group 4
 * @version 10/11/2016
 * 
 */
public class Consumable extends Item{

	private String effect;
	/**
	 * Constructor of this class
	 * @param newName String : name of the item
	 * @param desc String : description of the item and it's effects
	 * @param pric Int : price of the item
	 * @param sell Boolean : is the item sellAble
	 * @param effects String : effect of the items
	 */
	public Consumable(String newName, String desc, int pric, boolean sell,String effects)
	{
		super(newName,desc,pric,sell);
		effect = effects;
	}
	
	/**
	 *  This method returns an effect.
	 * @return String : effect of this consumable
	 */
	public String getEffect()
	{
		return effect;
	}
	
	/**
	 * This method uses the item : the effects will apply and the item will be destroyed
	 */
	private void use()
	{
	
	}
}
