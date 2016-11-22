package test;
import item.TreasureBox;
import item.Weapon;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TreasureBoxTest {

	private TreasureBox myTreasureBox;

		/**
		 * Default constructor for the test class treasurBox
		 */
	public TreasureBoxTest(){
		
	}
	
	/**
	 * sets up the test fixture.
	 * <p> Initialize one weapon for the test which have their parameters:
	 * 				- name : Box1
	 * 				- description : "keys open the door"
	 * 				- price : 50
	 * 				- sell : true
	 * 				- lock  : key1
	 */
	
@Before
public void setUp()
{
	myTreasureBox = new TreasureBox ("Box1", "keys open the door", 50, true, "key1");	
	
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
 public void testNameBox1()
 {
	 // The parameter "Box1" must be set as the name attribute
	 assertEquals("Box1", myTreasureBox.getName());
 }
 
 /**
  * Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
  */
 @Test
 public void testDescBox1()
 {
	 // The parameter "keys open the door" must be set as the name attribute
	 assertEquals("keys open the door", myTreasureBox.getDescription();	
 }
 
}