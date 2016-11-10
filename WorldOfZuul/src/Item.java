/**
 * 
 * @author gp4
 * @version 
 * This class manage the game items.
 */
public class Item {
	private String name;
	private String description;
	private int price;
	private boolean sellAble;
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
		name = newName;
		description = desc;
		price = pric;
		sellAble = sell;
	}
	
	/**
	 * 
	 * @return String : description of the item
	 */
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * 
	 * @return String : description of the item
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return Integer : price of the item
	 */
	public int getPrince()
	{
		return price;
	}
	
	/**
	 * 
	 * @return Boolean : cant the object be sell
	 */
	public boolean getSellAble()
	{
		return sellAble;
	}
	
}
