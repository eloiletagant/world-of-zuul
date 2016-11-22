package test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import item.Key;
import room.Lock;


/**
 * The test class LockTest
 * Unit tests of the Lock class 
 * @author Groupe4
 * @version 22/11/2016
 */

public class LockTest {
	
	private Lock myLock;
	private Key myKey, badKey;
	
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
		myKey = new Key("Key", null, 0, false);
		myLock = new Lock(myKey);
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
		assertSame(myKey,myLock.getAssociatedKey());
	}
	
	/**
	 * Method testOpenRight
	 * Checks the attributed key given in method openLock and checks if the Lock is open too.
	 */
	@Test
	public void testOpenRight(){
		myLock.openLock(myKey);
		assertSame(myKey,myLock.getAssociatedKey());
		assertEquals(false,myLock.getLock());
	}
	
	/**
	 * Method testOpenRight
	 * Checks if a key given in method openLock is the good key attributed to the Lock. Checks if the Lock is open too.
	 */
	@Test
	public void testOpenBad(){
		badKey = new Key("BadKey", null, 0, false);
		myLock.openLock(badKey);
		assertNotSame(badKey,myLock.getAssociatedKey());
		assertEquals(true,myLock.getLock());
	}
}
