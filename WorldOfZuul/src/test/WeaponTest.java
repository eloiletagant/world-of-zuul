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
	 * Default construcot for test class Weapon
	 */
	public WeaponTest()
	{
		
	}
	
	/**
	 * sets up the test fixture.
	 * <p> Initialize one weapon for the test which have their parameters:
	 * 				- name : knife
	 * 				- description :Sharp instrument, consisting of handle with a blade
	 * 				- damages : 50
	 * 				- sell : true
	 * 				- price : 150
	 * 				- oneHandle : true
	 */
	
		@Before
	public void setUp()
	{
		myWeapon = new Weapon ("Knife", "Sharp instrument, consisting of handle with a blade", 50, true, 150, true);	
		
	}
	
	/**
	 * Tears down the test fixture
	 * <p> Called after every test case method. NOthing to do in this case </p>
	 */
	 @After
	 public void tearDown()
	 {
	 }
	 
	 /**
	  * Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testNameKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals("Knife", myWeapon.getName());
	 }
	 
	 /**
	  * Checks if the description given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testDescriptionKnife()
	 {
		 // The descritption must be set as the description attribute
		 assertEquals("Sharp instrument, consisting of handle with a blade", myWeapon.getDescription());
	 }
	 
	 /**
	  * Checks if the price given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testPriceKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(50, myWeapon.getPrice());
	 }
	 /**
	  * Checks if the boolean sell given  as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testSellKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(true, myWeapon.getSellAble());
	 }
	 
	 /**
	  * Checks if the damage given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testDamageKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(150, myWeapon.getDamages());
	 }
	 /**
	  * Checks if the boolean handle given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testHandleKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals(true, myWeapon.getOneHand());
	 }
	 

}
