
public class Key extends Item{
	
	Lock associatedLock;
	
	public Key(String newName, String desc, int pric, boolean sell, Lock aLock)
	{
		super(newName,desc,pric,sell);
		associatedLock = aLock;
	}
	
	public Lock getLock()
	{
		return associatedLock;
	} 
} 
