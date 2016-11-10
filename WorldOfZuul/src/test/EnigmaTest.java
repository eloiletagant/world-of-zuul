package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnigmaTest {

	@Test
    /**
    * This method allow testing if the answer is the good for an enigma.
    */
	public void testTestAnswer() throws Exception {
		 Enigma a= new Enigma(”answer”);
	     assertTrue(a.testAnswer(“answer”));
	     assertFalse(a.testAnswer(“falseAnswer”));
	}
	


}
