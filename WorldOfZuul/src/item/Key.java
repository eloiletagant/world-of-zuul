
package item;
import room.Lock;

/**
 *  
 * @author Group4
 * @version 22/11/2016
 * This class manages keys and its locket.
 * A key must have all same parameters of an item.
 * 
 *
 */
public class Key extends Item{
	
	
	/**
	 * Constructor of this class.
	 * If the name is a null string, the given name is "Key".
	 * 
	 * @param newName String		name of the item
	 * @param aDescription String	description of the item
	 * @param aPrice Int			price of the item
	 * @param sell Boolean			true if the item can be sell
	 */
	public Key(String newName, String aDescription, int aPrice, boolean sell)
	{
		super(newName,aDescription,aPrice,sell);
	}
	

	
}