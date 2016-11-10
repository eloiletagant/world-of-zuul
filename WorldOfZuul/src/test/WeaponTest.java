package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponTest {

	/**
    * @Test This method allow testing if a weapon is not equipped.
    */
    public void testUnequipWeapon(Weapon weap)  throws Exception {
        assertFalse(unequipeWeapon(weap));
    }

}
