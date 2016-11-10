
public class Item {
	private String name;
	private String description;
	private int price;
	private boolean sellAble;
	//private int weight;
	
	public Item(String newName, String desc, int pric, boolean sell)
	{
		name = newName;
		description = desc;
		price = pric;
		sellAble = sell;
	}
	
	public String getDescription()
	{
		return description;
	}
	public String getName()
	{
		return name;
	}
	public int getPrince()
	{
		return price;
	}
	public boolean getSellAble()
	{
		return sellAble;
	}
	
}
