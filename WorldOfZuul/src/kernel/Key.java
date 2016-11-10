package kernel;
/**
 *  
 * @author gp4
 * @version 
 * This class manage keys and his locket
 *
 */
public class Key extends Item{
	
	private Lock associatedLock;
	
	/**
	 * Constructor of this class.
	 * @param newName String : name of the item
	 * @param desc String : description of the item and it's effects
	 * @param pric Int : price of the item
	 * @param sell Boolean : is the item sellAble
	 * @param aLock Lock : associated locket 
	 */
	public Key(String newName, String desc, int pric, boolean sell, Lock aLock)
	{
		super(newName,desc,pric,sell);
		associatedLock = aLock;
	}
	/**
	 * 
	 * @return Lock : locket associated to the key
	 */
	public Lock getLock()
	{
		return associatedLock;
	}
} 
