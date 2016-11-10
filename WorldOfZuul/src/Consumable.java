
public class Consumable extends Item{

	String effect;
	
	public Consumable(String newName, String desc, int pric, boolean sell,String effects)
	{
		super(newName,desc,pric,sell);
		effect = effects;
	}
	
	public void use()
	{
	
	}
	
	public String getEffect()
	{
		return effect;
	} 
}
