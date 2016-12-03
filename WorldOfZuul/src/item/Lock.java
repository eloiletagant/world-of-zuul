package item;

/**
 * This class manages a lock system for a door or a treasure box.
 * The lock has an associated key used to open it. The lock is closed by default. 
 * @author Group4
 * @version 10/11/2016
 *
 */
public class Lock
{	
	private Key key;
	private boolean lock;

	/**
	 * Constructor used to instantiate a lock
	 */
	public Lock()
	{
		lock = true;
		key = null;
	}
	
	/**
	 * Simple accessor
	 * @return A boolean true if the lock is closed false if it is not
	*/
	public boolean getLock()
	{
		return lock;
	}
	
	/**
	 * Simple accessor
	 * @return Key: The key associated to the lock
	*/
	public Key getKey()
	{
		return key;
	}

	/**
	 * associate a key to the lock
	 */
	public void addKey(Key newKey)
	{
		if (key == null)
		{
            key = newKey; 
        }
	}

	/**
	 * This method is used to open a lock if the key corresponds to the associated key
	 * @param: A key that will be compared with the associated key
	 * @return true = the chest opened, false = the chest stayed close
	*/
	public boolean unlock(Key keyTest)
	{
		if (keyTest.getKeyToken() == key.getKeyToken())
		{
			lock = false; //the lock is open
			return true;
		}
		else
		{
			lock = true; //the lock stay closed
			return false;
		}
	}
}
