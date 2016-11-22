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
	
	private Lock myLock, otherLock;
	private Key myKey, goodKey, badKey;
	
	public LockTest(){
	}

	@Before
	public void setUp() {
		myKey = new Key("Key", null, 0, false, null, myLock);
		goodKey = new Key("Key", null, 0, false, null, myLock);
		badKey = new Key("Key", null, 0, false, null, otherLock);
		myLock = new Lock(myKey);
		otherLock = new Lock(badKey);
	}
	
	@After
	public void tearDown(){}
	
	@Test
	public void testKey(){
		assertEquals(myKey,myLock.getAssociatedKey());
	}
	
	@Test
	public void testOpenRight(){
		myLock.openLock(goodKey);
		assertEquals(goodKey,myLock.getAssociatedKey());
		assertEquals(false,myLock.getLock());
	}
	
	@Test
	public void testOpenBad(){
		myLock.openLock(badKey);
		assertNotSame(badKey,myLock.getAssociatedKey());
		assertEquals(true,myLock.getLock());
	}
}
