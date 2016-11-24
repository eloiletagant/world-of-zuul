package event;

import item.Item;
import character.Character;

/**
 * This method generates an enigma. This enigma will be resolved by the character to win an item or a price.
 *
 * @author Group 4
 * @version 10/11/2016
 */
public class Enigma extends Event {
    private String question;
    private String answer;

    /**
     * Constructor of the class enigma. This method will generate an enigma.
     *
     * @param q a question
     * @param a an answer
     */
    public Enigma(String description, Item loot, Character player, String q, String a) {
        super(description, loot, player);
        question = q;
        answer = a;
    }

    public String getAnswer() {
        return answer;
    }

    /**
     * This method will test if the answer is correct.
     *
     * @param test
     */
    public void testAnswer(String test) {
        if (test.equals(answer)) {
            player.getInventory().addItem(loot);
            System.out.println("Well play, you got it!");
        } else {
            System.out.println("You are close...");
        }
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
