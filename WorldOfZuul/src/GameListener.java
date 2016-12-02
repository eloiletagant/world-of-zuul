import java.awt.event.*;

import character.Player;
/**
 * This class allows to listen the game interface and to perform actions
 * 
 * @author G4
 * @version 02/12/2016
 */

public class GameListener implements ActionListener {
    
	private Game game;
	private InventoryInterface inventoryInterface;
	private Player player;

    /**
     * GameListener constructor
    */   
    public GameListener(Game g, Player p) {
        game = g;
        player = p;
    }

    /**
     * Actions performed when actions in game class are listen
     * @param e: The source of the action in the game class
     */
    
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource() == game.front)
            game.move("front");
        if (e.getSource() == game.behind)
            game.move("behind");
        if (e.getSource() == game.right)
            game.move("right");
        if (e.getSource() == game.left)
            game.move("left");
        if (e.getSource() == game.bag)
        	inventoryInterface = new InventoryInterface(player.getInventory()); 
    }
    
   }
     
