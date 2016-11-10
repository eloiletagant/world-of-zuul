
public class Weapon extends Item{

	private int damages;
	private boolean oneHand;
	private boolean equiped;
	
	public Weapon(String newName, String desc, int pric, boolean sell,int dmg, boolean hand)
	{
		super(newName,desc,pric,sell);
		damages = dmg;
		oneHand = hand;
		equiped = false;
	}
	
	public boolean getOneHand()
	{
		return oneHand;
	}
	
	public boolean getEquiped()
	{
		return equiped;
	}
	
	public int getDamages()
	{
		return damages;
	}
	
	public void equip()
	{
		equiped = true;
	}
	
	public void unEquip()
	{
	equiped = false;
	}
}
