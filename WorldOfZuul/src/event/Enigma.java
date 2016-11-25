package event;

import item.Item;
import character.Character;
import character.NPC;

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
    public Enigma(String description, Item loot, Character player, NPC npc, String q, String a) {
        super(description, loot, player, npc);
        question = q;
        answer = a;
    }

    /**
     * method to get the answer
     * @return
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method will test if the answer is correct.
     * @param test
     */
    public boolean testAnswer(String test) {
        if (test.equals(answer)) {
            getPlayer().getInventory().addItem(super.getItem());
            System.out.println("Well play, you got it!");
            return true;
        } else {
            System.out.println("You are close...");
            return false;
        }
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
