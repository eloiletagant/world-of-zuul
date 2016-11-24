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
	private Key badKey;
	
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
		myLock = new Lock("MyKey", "Test key", 10, true);
		badKey = new Key("badKey", "Test bad key", 10, true);
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
		assertEquals("MyKey",myLock.getKey().getName());
		assertEquals("Test Key",myLock.getKey().getDescription());
		assertEquals(10,myLock.getKey().getPrice());
		assertEquals(true,myLock.getKey().getSellAble());
	}
	
	/**
	 * Method testOpenRight
	 * Checks the method openLock with the associated key given in parameter. Checks if the Lock is open too.
	 */
	@Test
	public void testUnlock(){
		myLock.unlock(badKey);
		assertSame(badKey,myLock.getKey());
		assertEquals(true,myLock.getLock());
	}
	
	/**
	 * Method testOpenBad
	 * Checks the method openLock with a non associated key given in parameter. Checks if the Lock stay close too.
	 */
	@Test
	public void testOpenBad(){
		badKey = new Key("BadKey", null, 0, false);
		myLock.openLock(badKey);
		assertNotSame(badKey,myLock.getAssociatedKey());
		assertEquals(true,myLock.getLock());
	}
}
