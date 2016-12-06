package item;
/**
 * This class manage the game items.
 * An item must have a name and a description.
 * It can be sold by the player.
 * All information of the item can be visualizing thanks to all get methods.
 * @author Group4
 * @version 22/11/2016
 * 
 */
public abstract class Item
{
	// the name of an Item. It can not be changed after its assignment.
	private String name;
	// the description of an Item. It can not be changed after its assignment.
	private String description; 
	// The price can not be negative
	private int price; 
	// true if a player can sell this item. It can not be changed after its assignment.
	private boolean sellAble; 
	// this boolean helps during the management of items in the inventory. True if the item is displayed, false if it is not.
	private boolean display;
	
	/**
	 * Constructor of the Item class
	 * If the given name is a null string, the name is "Unidentified object".
	 * If the given description is a null string, the description is "This object seems strange".
	 * If the given price is negative, the price is 100 gold.
	 * @param newName String		name of the item
	 * @param aDescription String	description of the item
	 * @param aPrice Int			price of the item
	 * @param sell Boolean			true if the item can be sell
	 */
	public Item(String newName, String aDescription, int aPrice, boolean sell)
	{
		if (aDescription.isEmpty())
		{
			aDescription="This object seems strange.";
		}
		if (aPrice<0)
		{
			aPrice=100;
		}
		if (newName.isEmpty())
		{
			newName="Unidentified object";
			aDescription="This object seems strange and come from nowhere";
			sell=false;
			aPrice=0;
		}
		name = newName; 
		description = aDescription;
		price = aPrice;		
		sellAble = sell;
		display=false;
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
	
	/**
	 * This method returns if the item is managed.
	 * @return Boolean : true if this item is displayed.
	 */
	public boolean getDisplay()
	{
		return display;
	}
	
	/**
	 * This method returns if the item is managed.
	 * @return Boolean : true if this item is displayed.
	 */
	public void setManaged()
	{
		if (this.getDisplay()==true)
		{
			this.display=false;
		}
		else
		{
			this.display=true;
		}
	}
	public void equip()
	{
		
	}
}
