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
    	    		createFrame();
    	    	}
    		}
    	}
        if (e.getSource() == game.getBehindB())
        {
        	if (doors.containsKey("behind"))
    		{
    			if(doors.get("behind").isLocked() == false)
    			{
    				game.move("behind");
    			}
    			else
    	    	{
    	    		createFrame();
    	    	}
    		}
        }
        if (e.getSource() == game.getRightB())
        {
        	if (doors.containsKey("right"))
    		{
    			if(doors.get("right").isLocked() == false)
    			{
    				game.move("right");
    			}
    			else
    	    	{
    	    		createFrame();
    	    	}
    		}
        }
        if (e.getSource() == game.getLeftB())
        {
        	if (doors.containsKey("left"))
    		{
    			if(doors.get("left").isLocked() == false)
    			{
    				game.move("left");
    			}
    			else
    	    	{
    	    		createFrame();
    	    	}
    		}
        }
        if (e.getSource() == game.getBagB()) {
        	if (game.getInventoryIsOpen()) {
        		game.openInventory(false);
        		game.setOpenningInventory(false);
        	} else {
        		//the inventory is close, so we can open it
        		game.openInventory(true);
        		game.setOpenningInventory(true);
        	}
        }
        	
    }
    
    public void createFrame()
    {
    	Font police = new Font ("Kristen ITC", Font.BOLD, 14);
    	myLabel= new JLabel("This door is locked.", JLabel.CENTER);
    	myLabel.setBackground(Color.black);
        myLabel.setOpaque(true);
        myLabel.setForeground(Color.yellow);
        myLabel.setFont(police);
		myButton= new JButton("Try to open !");
		myButton.setBackground(Color.black);
        myButton.setOpaque(true);
        myButton.setForeground(Color.yellow);
        myButton.setFont(police);
		myPanel= new JPanel(new GridLayout (0,1));
		myPanel.add(myLabel);
		myPanel.add(myButton);
		myFrame= new JFrame("Locked Door");  
        myFrame.add(myPanel);
        myFrame.setSize(500, 500);
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
   }
     
