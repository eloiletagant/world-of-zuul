/**
 * 
 * @author gp4
 * This class manage consumables. Consumables may have differents effects and are destroyed when they are used.
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
	 * this method use the item : the effects will applies and the item will be destroyed
	 */
	public void use()
	{
	
	}
	
	/**
	 *  
	 * @return String : effect of this consumable
	 */
	public String getEffect()
	{
		return effect;
	}
}
