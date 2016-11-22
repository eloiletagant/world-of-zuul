//********* EN COURS ON ESSAIS *********
package test;
import item.Weapon;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;


public class WeaponTest {
	
	private Weapon myWeapon;

	/**
	 * Constructor
	 */
	public WeaponTest()
	{
		
	}
	
	/**
	 * Create a weapon
	 */
	@Before
	public void setUp()
	{
		myWeapon = new Weapon ("Knife", "Sharp instrument, consisting of handle with a blade", 50, true, 150, true);	
		
	}
	
	/**
	 * 
	 */
	 @After
	 public void tearDown()
	 {
		 // on comprends pas a quoi elle sert
	 }
	 
	 /**
	  * 
	  */
	 @Test
	 public void testNameKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals("Knife", myWeapon.getName());
	 }
	 
	 /**
	  * 
	  */
	 @Test
	 public void testDescriptionKnife()
	 {
		 // The descritption must be set as the description attribute
		 assertEquals("Sharp instrument, consisting of handle with a blade", myWeapon.getDescription());
	 }
	 
	 /**
	  * 
	  */
	 @Test
	 public void testPriceKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(50, myWeapon.getPrice());
	 }
	 /**
	  * 
	  */
	 @Test
	 public void testSellKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(true, myWeapon.getSellAble());
	 }
	 
	 /**
	  * 
	  */
	 @Test
	 public void testDamageKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(150, myWeapon.getDamages());
	 }
	 /**
	  * 
	  */
	 @Test
	 public void testHandleKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(true, myWeapon.getOneHand());
	 }
	 

}
