package test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import item.Key;
import item.Lock;


/**
 * The test class LockTest
 * Unit tests of the Lock class 
 * @author Groupe4
 * @version 22/11/2016
 */

public class LockTest {
	
	private Lock myLock;
	private Key badKey, goodKey;
	
	/**
	 * Default constructor for test class LockTest
	 */
	public LockTest(){
	}

	/**
	 * Sets up the test fixture
	 * Called before every test method
	 * Initialize one key and the lock associated
	 */
	@Before
	public void setUp() {		
		goodKey = new Key("goodKey", "Test good key", 10, true);
		badKey = new Key("badKey", "Test bad key", 10, true);
		myLock = new Lock();
		myLock.addKey(goodKey);
	}
	
	/**
	 * Tear down the test fixture
	 * Called after every test case method. Nothing to do in this case.
	 */
	@After
	public void tearDown(){}
	/**
	 * Method test key
	 * Checks if the key given in Lock constructor is correctly set to the attribute
	 */
	@Test
	public void testKey(){
		assertSame(goodKey,myLock.getKey());
	}
	
	/**
	 * Method goodUnlock
	 * Checks the method unlock with the associated key given in parameter. Checks if the Lock is unlocked too.
	 */
	@Test
	public void goodUnlock(){
		myLock.unlock(goodKey);
		assertSame(goodKey,myLock.getKey());
		assertEquals(false,myLock.getLock());
	}
	
	/**
	 * Method badUnlock
	 * Checks the method unlock with a non associated key given in parameter. Checks if the Lock is locked too.
	 */
	@Test
	public void badUnlock(){
		myLock.unlock(badKey);
		assertNotSame(badKey,myLock.getKey());
		assertEquals(true,myLock.getLock());
	}
}
