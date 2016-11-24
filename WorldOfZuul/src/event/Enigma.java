package event;

import item.Item;

/**
 * This method generates an enigma. This enigma will be resolved by the character to win an item or a price.
 * @author Group 4 
 * @version 10/11/2016
 *
 */
public class Enigma extends Event
{
	private String question;
	private String answer;

	/**
	 * Constructor of the class enigma.This method will generate an enigma.
	 * @param q		a question
	 * @param a		an answer
	 */
	public Enigma(String description, Item loot, Character player, String q, String a) {
		super(description, loot, player);
		question = q;
		answer = a;
	}
	
	/**
	 * This method will test if the answer is correct.
	 * @param a
	 */
	public void testAnswer (String test) {
		if (test.equals(answer)) {
			player.getInventory().addItem(loot);
		}
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
