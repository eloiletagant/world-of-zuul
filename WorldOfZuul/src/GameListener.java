import java.awt.event.*;
/**
 * This class allows to listen the game interface and to perform actions
 * 
 * @author G4
 * @version 02/12/2016
 */

public class GameListener implements ActionListener {
    
	private Game game;

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
     
        if (e.getSource() == game.front)
            game.move("front");
        if (e.getSource() == game.behind)
            game.move("behind");
        if (e.getSource() == game.right)
            game.move("right");
        if (e.getSource() == game.left)
            game.move("left");
    }
    
   }
     
