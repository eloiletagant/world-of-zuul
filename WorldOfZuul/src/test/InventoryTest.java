package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {
	
	/**
	* @Test This method allow testing the conservation of the entity of the item
    */
    public void testAddItem () throws Exception { 
    	Item a = new Item(“epée”,”arme”,50,true);
    	assertSame("Same item", a,Item.addItem(a));
	    for (String anObject: Inventory) {
	        assertEquals(a,Inventory.addItem(anObject));
	    }
	         
	    
	    
	/**
	 * @Test This method allow testing if the method deleteItem works well.
	 */
	 public void testDeletingItem (Item a) throws Exception { 
		 for (String anObject: Inventory) {
		     assertNotSame(a,Inventory.deleteItem(anObject));
		 }
	 }

}
