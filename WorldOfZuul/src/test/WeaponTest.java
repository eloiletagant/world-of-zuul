package test;
import item.Weapon;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;


public class WeaponTest
{	
	private Weapon myWeapon;

	/**
	 * Sets up the test fixture
	 * Called before every test method
	 * Initialize one key with specific parameters
	 */
	@Before
	public void setUp()
	{
		myWeapon = new Weapon("Sword","This sword is very helpfull during a fight", 150, true, 5, true);
	}
	
	/**
	 * Tears down the test fixture.
	 * Called after every test case method. Nothing to do in this case.
	 */
	@After
	public void tearDown()
	{
	}

	/**
	 * Method testSword
	 * Checks if the given parameter in the constructor is correctly set to the attribute.
	 * 
	 */
	@Test
	public void testSword()
	{
		assertEquals("Sword",myWeapon.getName());
		assertEquals("This sword is very helpfull during a fight",myWeapon.getDescription());
		assertEquals(150,myWeapon.getPrice());
		assertEquals(true,myWeapon.getSellAble());
		assertEquals(5,myWeapon.getDamages());
		assertEquals(true,myWeapon.getOneHand());
		assertEquals(false,myWeapon.getEquiped());
	}
	
	/**
	 * Method testDefault
	 * Checks the default parameters
	 * 
	 */
	@Test
	public void testDefault()
	{
		Weapon bad = new Weapon("", "", -10, true,-1,false);
		assertEquals("Unidentified object",bad.getName());
		assertEquals("This object seems strange and come from nowhere",bad.getDescription());
		assertEquals(0,bad.getPrice());
		assertEquals(false,bad.getSellAble());
		assertEquals(2,bad.getDamages());
		assertEquals(false,bad.getOneHand());
		assertEquals(false,bad.getEquiped());
	}
	
	/**
	 * Method testEquip
	 * <p>Checks if the weapon is correctly equiped</p>
	 * 
	 */
	@Test
	public void testEquip()
	{
		myWeapon.equip();
		assertEquals(true,myWeapon.getEquiped());
	}
	
	/**
	 * Method testUnequip
	 * <p>Checks if the weapon is correctly equiped</p>
	 */
	@Test
	public void testUnequip()
	{
		myWeapon.equip();
		myWeapon.unequip();
		assertEquals(false,myWeapon.getEquiped());
	}
}
