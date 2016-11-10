package kernel;
/**
 * This class manages the lock system of a door or a treasure box.
 * @author Group4
 * @version 10/11/2016
 *
 */
public class Lock {
	
	private Key associatedKey;
	private boolean lock;

	/**
	 * This method returns a boolean true if the door or a treasure box is locked
	 * @return
	 */
	public boolean getLock()
	{
		return lock;
	}
	
	/**
	 * This method opens a locked door/treasure box.
	 */
	public void openLock(Key)
	{
		
	}
}
