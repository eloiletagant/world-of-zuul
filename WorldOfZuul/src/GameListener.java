import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import character.Player;
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
	private JFrame myFrame;
	private JLabel myLabel;
	private JPanel myPanel;
	private JButton myButton;


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
    
    public void actionPerformed(ActionEvent e)
    {
    	doors=game.getPlayer().getLocation().getDoors();
    	if (e.getSource() == game.getFrontB())
    	{
    		if (doors.containsKey("front"))
    		{
    			if(doors.get("front").isLocked() == false)
    			{
    				game.move("front");
    			}
    			else
    	    	{
    				game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
    	}
    	else if (e.getSource() == game.getBehindB())
        {
        	if (doors.containsKey("behind"))
    		{
    			if(doors.get("behind").isLocked() == false)
    			{
    				game.move("behind");
    			}
    			else
    	    	{
    				game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
        }
    	else if (e.getSource() == game.getRightB())
        {
        	if (doors.containsKey("right"))
    		{
    			if(doors.get("right").isLocked() == false)
    			{
    				game.move("right");
    			}
    			else
    	    	{
    	    		game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
        } 
    	else if (e.getSource() == game.getLeftB())
        {
        	if (doors.containsKey("left"))
    		{
    			if(doors.get("left").isLocked() == false)
    			{
    				game.move("left");
    			}
    			else
    	    	{
    				game.setText("This door is locked. You need a key to open this door. Try to open it by opening your inventory !");
    	    	}
    		}
        }
    	else if (e.getSource() == game.getBagB()) {
        	if (game.getInventoryIsOpen()) {
        		game.openInventory(false);
        		game.setOpenningInventory(false);
        	} else {  
        		//the inventory is close, so we can open it
        		game.openInventory(true);
        		game.setOpenningInventory(true);
        	}
        }
    	else if (e.getSource() == game.getSpeak())
        {
            game.displayEnigma();
        }
    	else if (e.getSource() == game.getSearch())
        {
    		if (game.getPlayer().getLocation().hasChest()){
    			if (game.getPlayer().getLocation().getChest().getLock().getLock() == true){
    				game.setText("This chest is locked. You need a key to open this chest. Try to open it by opening your inventory !");
    			} else {
    				game.getItemsFromChest(game.getPlayer().getLocation().getChest());
    			}
    		}
    		else {
    			game.setText("There is no chest in this room !");
    		}
        }
        	
    }

   }
     
