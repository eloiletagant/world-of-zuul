package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnigmaTest {

	@Test
    /**
     * Method testTestAnswer
     * This method checks if the method of comparison of answer works well.
     */
	public void testTestAnswer() throws Exception {
		 Enigma a= new Enigma("chaussettes");
	     assertTrue(testAnswer(a));
	     Enigma a= new Enigma("other");
	     assertFalse(a.testAnswer(testAnswer(a));
	}
}
