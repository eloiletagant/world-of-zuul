/**
 * This class manages the item which is in the inventory of a charcater.
 * 
 * @author Groupe 4
 * @version 10/11/2016
 *
 */
public class Item {
	private String name;
	private String description;
	private int price;
	private boolean sellAble;
	private int weight;
	
	/**
	 * constructor of the class item
	 */
	public Item(String newName, String desc, int pric, boolean sell)
	{
		name = newName;
		description = desc;
		price = pric;
		sellAble = sell;
	}
	
	/**
	 * This method displays the description of an item.
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * This method displays the name of the item.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method displays the price of an item.
	 */
	public int getPrince()
	{
		return price;
	}
	
	/**
	 * This method informed us if an item can be selled.
	 */
	public boolean getSellAble()
	{
		return sellAble;
	}
	
}
