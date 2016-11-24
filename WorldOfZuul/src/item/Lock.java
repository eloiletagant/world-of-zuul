package item;

/**
 * This class manages a lock system for a door or a treasure box.
 * The lock has an associated key used to open it. The lock is closed by default. 
 * @author Group4
 * @version 10/11/2016
 *
 */
public class Lock {
	
	private Key key;
	private boolean lock = false;

	/**
	 * Constructor used to instantiate a lock
	 * @param: The associated key
	*/
	public Lock(String keyName, String keyDescription, int keyPrice, boolean keySellAble) {
		this.key = new Key(keyName, keyDescription, keyPrice, keySellAble);
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
	 * This method is used to open a lock if the key corresponds to the associated key
	 * @param: A key that will be compared with the associated key
	*/
	public boolean unlock(Key key)
	{
		if (key.getKeyToken() == this.key.getKeyToken()) {
			lock = false; //the lock is open
			return lock;
		} else {
			lock = true; //the lock stray closed
			return lock;
		}
	}
}
