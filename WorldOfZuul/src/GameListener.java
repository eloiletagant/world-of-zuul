import java.awt.event.*;
import java.util.*;

import character.NPC;
import character.Player;
import event.*;
import item.Weapon;
import room.Door;
/**
 * This class allows to listen the game interface and to perform actions
 * 
 * @author G4
 * @version 02/12/2016
 */

public class GameListener implements ActionListener {
    
	private Game game;
	private HashMap<String, Door> doors;
	
    /**
     * GameListener constructor
    */   
    public GameListener(Game g) {
        game = g;
    }

    /**
     * Actions performed when actions in game class are listen
     * @param e: The source of the action in the game class
     */
    
    public void actionPerformed(ActionEvent e) {
    	
    	doors = game.getPlayer().getLocation().getDoors();
    	Weapon w = new Weapon("", "", 0, true, 0);
    	Player player = new Player("", game.getMaxHealth());
    	NPC npc = new NPC("", 0, 0, true);
		Enigma enigma = new Enigma("", w, player, npc, "", "");
		
    	
    	if (e.getSource() == game.getFrontB()) {
    		if (doors.containsKey("front")) {
    			if(doors.get("front").isLocked() == false) {
    				game.move("front");
    			} else {
    				game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
    		
    	} else if (e.getSource() == game.getBehindB()) {
        	if (doors.containsKey("behind")) {
    			if(doors.get("behind").isLocked() == false) {
    				game.move("behind");
    			} else {
    				game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
        	
        } else if (e.getSource() == game.getRightB()) {
        	if (doors.containsKey("right")) {
    			if(doors.get("right").isLocked() == false) {
    				game.move("right");
    			} else {
    	    		game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
        	
        } else if (e.getSource() == game.getLeftB()) {
        	if (doors.containsKey("left")) {
    			if(doors.get("left").isLocked() == false) {
    				game.move("left");
    			} else {
    				game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
        	
        } else if (e.getSource() == game.getBagB()){
        	game.openInventory();
        	
        } else if (e.getSource() == game.getSpeak()) {
        	for (Event event : game.getPlayer().getLocation().getEvents()) {
            	if (event instanceof Enigma) {
            		enigma = (Enigma) event;
            	}
            }
        	if (enigma.getEnable()==true)
        	{
        		game.displayEnigma();
        	}
        	else if(enigma.getItem()!=null)
        	{
        		game.setText(enigma.checkAnswer(enigma.getAnswer()));
        	}
        	else
        	{
        		game.setText("You already won this reward.");
        	}
            
        } else if (e.getSource() == game.getSearch())  {
        	for (Event event : game.getPlayer().getLocation().getEvents())
            {
            	if (event instanceof Fight)
            	{
            		if (event.getItem()!=null)
            		{
            			if (game.getPlayer().getInventory().getItems().add(event.getItem()))
            			{
            				game.setText("Well done, you recover your reward "+event.getItem().getName()+" !");
            			}
            			else
            			{
            				game.setText("Your bag is full... You need to sell some items. Come back later to cover your reward please ");
            			}
            		}
            	}
            	else
            	{
            		if (game.getPlayer().getLocation().hasChest()){
            			if (game.getPlayer().getLocation().getChest().getLock().getLock() == true){
            				game.setText("The chest "+game.getPlayer().getLocation().getChest().getName()+" is locked. You need a key to open this chest. Try to open it by opening your inventory !");
            			} else {
            				game.getItemsFromChest(game.getPlayer().getLocation().getChest());
            			}
            		} else {
            			game.setText("There is no chest in this room !");
            		}
            	}
        	}
        } else if (e.getSource() == game.getEnigmaButton())
        {
        	// We are looking for the enigma in the player current room
            for (Event event : game.getPlayer().getLocation().getEvents())
            {
            	if (event instanceof Enigma)
            	{
            		enigma = (Enigma) event;
            	}
            }
            game.setText(enigma.checkAnswer(game.getTypingArea().getText()));
            game.getEnigmaFrame().dispose();
        }
    }
}
     
