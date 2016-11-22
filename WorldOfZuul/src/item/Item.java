package item;
/**
 * This class manage the game items. 
 * @author Group4
 * @version 22/11/2016
 * 
 */
public class Item
{
	// the name of an Item. It can not be changed after its assignment.
	private String name;
	// the description of an Item. It can not be changed after its assignment.
	private String description; 
	// The price can not be negative
	private int price; 
	// true if a player can sell this item. It can not be changed after its assignment.
	private boolean sellAble; 
	//private int weight;
	
	/**
	 * Constructor of the Item class
	 * @param newName String		name of the item
	 * @param aDescription String	description of the item
	 * @param aPrice Int			price of the item
	 * @param sell Boolean			true if the item can be sell
	 */
	public Item(String newName, String aDescription, int aPrice, boolean sell)
	{
		name = newName; // Assignment of the name.
		description = aDescription; // Assignement of the descrition.
		price = aPrice; // Assignement of the price.
		sellAble = sell; // Assignement of the boolean if we can sell this item or not.
	}
	
	/**
	 * This method returns the description of an item.
	 * @return String	description of the item
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * This method returns the name of an item.
	 * @return String	name of the item
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method returns the price of an item.
	 * @return Integer	price of the item
	 */
	public int getPrice()
	{
		return price;
	}
	
	/**
	 * This method returns if the item can be sold.
	 * @return Boolean : true if this item is sellable.
	 */
	public boolean getSellAble()
	{
		return sellAble;
	}
}
