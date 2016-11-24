package item;
import java.util.UUID;

/**
 *  
 * @author Group4
 * @version 22/11/2016
 * This class manages keys.
 * A key must have all same parameters of an item.
 */
public class Key extends Item
{
	private String keyToken;
	
	/**
	 * Constructor of this class.
	 * If the name is a null string, the given name is "Key".
	 * 
	 * @param newName String		name of the item
	 * @param aDescription String	description of the item
	 * @param aPrice Int			price of the item
	 * @param sell Boolean			true if the item can be sell
	 */
	public Key(String name, String description, int price, boolean sellAble)
	{
		super(name,description,price,sellAble);
		keyToken = UUID.randomUUID().toString(); //generate a random token
	}

	/**
	 * @return the key token
	 */
	public String getKeyToken()
	{
		return keyToken;
	}

	
}