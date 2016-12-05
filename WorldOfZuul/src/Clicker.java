import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker implements ActionListener, Runnable  {
	
    private int clicks = 0;
    private int time = 0;
    private int winScore;
    
    private static int MIN = 0;
    private static int MAX = 15;
    
    private boolean win = false;
    private boolean running = false;
    private boolean done = false;
    private Game game;
    
        
    public Clicker(Game g) {
    	game = g;
    }
    
    public int clickerLauncher (int clicksAsked) {
        
    	game.getClickerFrame().setVisible(true);
    	winScore = clicksAsked;
    	
    	game.getLeftB().setEnabled(false);
    	game.getRightB().setEnabled(false);
    	game.getBehindB().setEnabled(false);
    	game.getFrontB().setEnabled(false);  
    	

        while (!done) {	
        	game.getClickerFrame().getContentPane().repaint();
        }
        
        if (done) {
        	game.getLeftB().setEnabled(true);
        	game.getRightB().setEnabled(true);
        	game.getBehindB().setEnabled(true);
        	game.getFrontB().setEnabled(true);  
        }
        
        //System.out.println(clicks);
        return clicks;
        
    }
    

    public int getClicks() {
        return clicks;
    }
    
    public int getTime() {
        return time;
    }

    public boolean getRunning() {
        return running;
    }

    public int getWinScore() {
        return winScore;
    }

    
    //buttons listener
    @Override
    public void actionPerformed(ActionEvent e) {
        
    	if (e.getSource() == this.game.getClickButton()) {

        	//behavior
            if (time != MAX) {
                clicks++;
                game.getClickLabel().setText("Clicks: " + clicks);
                //percentage of victory
                //progression = (clicks * 100) / winScore;
                //progressionBar();
                if (clicks >= winScore) {
                	//player win
                    running = false;
                    win = true;
                    done = true;
                    game.getClickerFrame().setVisible(false);
   
                }
            }
            //trigger the timer in the first click
            if (clicks == 1) {
            	
            	//start to run the fight
            	running = true;
                new Thread(this).start();
      
            }
        }
    }
    

    
    
    //timer
    @Override
    public void run() {
        while (running) {
        	//time is over
            if (time == MAX) {
                if (clicks >= winScore) {
                	win = true;
                } else {
                	win = false;
                }
                running = false;
                done = true;
                game.getClickerFrame().setVisible(false);
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException message) {
                // empty catch block
            }
            if (!running) continue;
            time++;
            game.getBar().setValue(time);
        }
    }
    
}