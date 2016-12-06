package event;

import item.Item;
import character.*;
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
    private boolean enable; //enigma answered or not

    /**
     * Constructor of the class enigma. This method will generate an enigma.
     *
     * @param q a question
     * @param a an answer
     */
    public Enigma(String description, Item loot, Player player, NPC npc, String q, String a) {
        super(description, loot, player, npc);
        question = q;
        answer = a;
        enable = true;
    }

    
    /** 
     * method to get the answer
     * @return
     */
    public String getAnswer() { return answer; }

    /**
     * method to get the question 
     */
    public String getQuestion() { return question; }

    /**
     * accessor
     */
    public boolean getEnable() {
    	return enable;
    }
    
    public void setQuestion(String newQuestion) {
        question = newQuestion;
    }

    public void setAnswer(String newAnswer) {
        answer = newAnswer;
    }
    
    /**
     * disable an enigma
     */
    public void disableEnigma() {
    	enable = false;
    }
    

    
    /**
     * This method will test if the answer is correct.
     * @param playerAnswer
     */
    public String checkAnswer(String playerAnswer)
    {
    	String anAnswer=playerAnswer.toLowerCase();
    	String toReturn;
        if (anAnswer.contains(answer))
        {
            disableEnigma();
            if (getPlayer().getInventory().addItem(super.getItem())==false)
            {
            	toReturn="<html>Well done, you get it!<br>Your bag is full... You need to sell some items. Come back later please </html>";
            }
            else
            {
            	getPlayer().getInventory().addItem(super.getItem());
            	toReturn="<html>Well done, you get it!<br>You won "+super.getItem().getName()+". Congratulations !!!</html>";
            	super.setItem(null);
            } 
        }
        else
        {
            toReturn="Wrong answer, try again !";  
        }
        return toReturn;
    }

}
