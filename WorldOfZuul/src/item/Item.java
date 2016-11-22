package item;
/**
 * 
 * @author gp4
 * @version 
 * This class manage the game items. 
 */
public class Item {
	private String name; // It is the name of the Item. It can not be changed after its assignment.
	private String description; //It is the description of the Item. It can not be changed after its assignment.
	private int price; // The price can not be negative
	private boolean sellAble; // It is the boolean to know if we can sell this item or not. It can not be changed after its assignment.
	//private int weight;
	
	/**
	 * This is the constructor of the class
	 * @param newName String : name of the item
	 * @param desc String : description of the item and it's effects
	 * @param pric Int : price of the item
	 * @param sell Boolean : is the item sellAble
	 */
	public Item(String newName, String desc, int pric, boolean sell)
	{
		name = newName; // Assignment of the name.
		description = desc; // Assignement of the descrition.
		price = pric; // Assignement of the price.
		sellAble = sell; // Assignement of the boolean if we can sell this item or not.
	}
	
	/**
	 * This method allow visualizing all description of an item.
	 * @return String : description of the item
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * This method allow showing the name of an item.
	 * @return String : description of the item
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method allow showing the price of an item.
	 * @return Integer : price of the item
	 */
	public int getPrince()
	{
		return price;
	}
	
	/**
	 * This method allow showing if the item can be sold.
	 * @return Boolean : cant the object be sell
	 * return true if we can sold this item.
	 */
	public boolean getSellAble()
	{
		return sellAble;
	}
	
}
