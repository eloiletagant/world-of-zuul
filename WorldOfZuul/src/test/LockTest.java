package test;

import static org.junit.Assert.*;
<<<<<<< HEAD

import java.util.concurrent.locks.Lock;

import static org.junit.After;
import static org.junit.Before;
import static org.junit.Test;
=======
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import item.Key;
import room.Lock;
>>>>>>> branch 'master' of https://github.com/eloiletagant/WorldOfZuul

/**
 * The test class LockTest
 * Unit tests of the Lock class 
 * @author Groupe4
 * @version 22/11/2016
 */

public class LockTest {
	
	private Lock myLock;
	private Key myKey, goodKey, badKey;
	
	public LockTest(){
	}

	@Before
	public void setUp() {
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
