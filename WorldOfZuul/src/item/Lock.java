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
	private Key key = null;
	private boolean lock;

	/**
	 * Constructor used to instantiate a lock
	 */
	public Lock()
	{
		lock = true;
	}
	
	/**
	 * Simple accessor
	 * @return A boolean true if the lock is open false if is not
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
	public void addKey(Key key)
	{
		if (this.key == null)
		{
            this.key = key;
        }
	}

	/**
	 * This method is used to open a lock if the key corresponds to the associated key
	 * @param: A key that will be compared with the associated key
	*/
	public void unlock(Key key)
	{
		if (key.getKeyToken() == this.key.getKeyToken())
		{
			lock = false; //the lock is open
		}
		else
		{
			lock = true; //the lock stay closed
		}
	}
}
