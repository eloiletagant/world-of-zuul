package test;

import static org.junit.Assert.*;
import static org.junit.After;
import static org.junit.Before;
import static org.junit.Test;

/**
 * The test class LockTest
 * Unit tests of the Lock class 
 * @author Groupe4
 * @version 22/11/2016
 */

public class LockTest {
	
	private Lock myLock;
	
	public LockTest(){
	}

	@Before
	public void setUp() {
		Key myKey;
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
		Key goodKey;
		myLock.openLock(goodKey);
		assertEquals(goodKey,myLock.getAssociatedKey());
		assertEquals(false,myLock.getLock());
	}
	
	@Test
	public void testOpenBad(){
		Key badKey;
		myLock.openLock(badKey);
		assertNotSame(badKey,myLock.getAssociatedKey());
		assertEquals(true,myLock.getLock());
	}
}
