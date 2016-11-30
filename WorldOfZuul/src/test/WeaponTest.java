package test;
import item.Weapon;
import org.junit.Before;
import static org.junit.Assert.*;
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
	 * <p>Checks if we can correctly equip or unequip the weapon</p>
	 * 
	 */
	@Test
	public void testEquip()
	{
		assertEquals(false,myWeapon.getEquiped());
		myWeapon.equip();
		assertEquals(true,myWeapon.getEquiped());
		myWeapon.equip();
		assertEquals(false,myWeapon.getEquiped());
	}
	
	/**
	 * Method testAddDamages
	 * <p>Checks if we can correctly add damages to the weapon</p>
	 * <p>We can't add a negative value to the weapon damages</p>
	 * 
	 */
	@Test
	public void testAddDamages()
	{
		myWeapon.addDamages(2);
		assertEquals(7,myWeapon.getDamages());
		myWeapon.addDamages(-2);
		assertEquals(7,myWeapon.getDamages());
	}
	
}
