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
	 * Initialize one key and its lock associated
	 */
	@Before
	public void setUp() {
		myKey = new Key("Key", null, 0, false);
		myLock = new Lock(myKey);
	}
	
	@After
	public void tearDown(){}
	
	@Test
	public void testKey(){
		assertEquals(myKey,myLock.getAssociatedKey());
	}
	
	@Test
	public void testOpenRight(){
		myLock.openLock(myKey);
		assertEquals(myKey,myLock.getAssociatedKey());
		assertEquals(false,myLock.getLock());
	}
	
	@Test
	public void testOpenBad(){
		badKey = new Key("BadKey", null, 0, false);
		myLock.openLock(badKey);
		assertNotSame(badKey,myLock.getAssociatedKey());
		assertEquals(true,myLock.getLock());
	}
}
