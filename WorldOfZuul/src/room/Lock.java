package room;

import item.Key;

/**
 * This class manages a lock system for a door or a treasure box.
 * The lock has an associated key used to open it. The lock is closed by default. 
 * @author Group4
 * @version 10/11/2016
 *
 */
public class Lock {
	
	private Key associatedKey;
	private boolean lock;

	/**
	 * Constructor used to instantiate a lock
	 * @param: The associated key
	*/
	public Lock(Key associatedKey){
		this.associatedKey = associatedKey;
	}
	
	/**
	 * Simple accessor
	 * @return A boolean if the lock is open or not
	*/
	public boolean getLock()
	{
		return lock;
	}
	
	/**
	 * Simple accessor
	 * @return Key: The key associated to the lock
	*/
	public Key getAssociatedKey()
	{
		return associatedKey;
	}
	
	/**
	 * This method is used to open a lock if the key corresponds to the associated key
	 * @param: A key that will be compared with the associated key
	*/
	public void openLock(Key k)
	{
		if (k == associatedKey)
			lock = false;		
	}
}
