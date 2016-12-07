import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker implements ActionListener, Runnable  {
	
    private int clicks = 0;
    private int time = 0;
    private int winScore;
    

    private static int MAX;
    
    //private boolean win = false;
    private boolean running = false;
    private Game game;
    
        
    public Clicker(Game g, int max) {
    	game = g;
    	MAX = max;
    }
    
    /**
     * 
     * @param clicksAsked
     */
    public void clickerLauncher (int clicksAsked){
        
    	game.getClickerFrame().setVisible(true);
    	
    	winScore = clicksAsked;
    	
    	game.getLeftB().setEnabled(false);
    	game.getRightB().setEnabled(false);
    	game.getBehindB().setEnabled(false);
    	game.getFrontB().setEnabled(false);  

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
    
    private void isDone() {
    	game.updateFightScore();
    	//possiblity to display infos on the screen
    }

    
    //buttons listener
    @Override
    public void actionPerformed(ActionEvent e) {
        
    	if (e.getSource() == game.getClickButton()) {

        	//behavior on the click button
            if (time != MAX) {
                clicks++;
                game.getClickLabel().setText("Clicks: " + clicks);
              //if the goal is reached 
                if (clicks == winScore) {
                    running = false;
                    isDone();
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
                running = false;
                isDone();
            }
            
            try {
            	//sleep for 0.01 second
                Thread.sleep(10);
            } catch (InterruptedException message) {
                // empty catch block
            }
            if (!running) continue;           
            time++;
            game.getBar().setValue(time);
        }
    }
    
    public void resetClicker()
    {
    	clicks = 0;
    	game.getClickLabel().setText("Clicks: " + clicks);
        time = 0;
        game.getBar().setValue(time);
    }
}

