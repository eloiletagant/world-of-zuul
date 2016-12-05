
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class Clicker extends JPanel implements ActionListener, Runnable  {
	
 
    private int clicks = 0;
    private int time = 0;
    private int progression = 0;
    private int winScore;
    
    private static int MIN = 0;
    private static int MAX = 15;
    private boolean win = false;
    private boolean running = false;
    private boolean done = false;
    private Game game;
    
    
    private JFrame frame;
    private JPanel progressionBar = new JPanel();
    private Container  globalPanel, bottomPanel;
    private JButton clickButton;
    private JLabel clickLabel;
    private JProgressBar bar = new JProgressBar();
        
   
    
    public int clickerLauncher (int clicksAsked) {
        
    	
    	game.getLeftB().setEnabled(false);
    	game.getRightB().setEnabled(false);
    	game.getBehindB().setEnabled(false);
    	game.getFrontB().setEnabled(false);  
    	
    	
    	frame = new JFrame();
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        winScore = clicksAsked;
        globalPanel = new JPanel(new GridLayout(3,1));
        //add comp


        
        //bottomPanel = new JPanel(new GridLayout(1,2));
        //bottomPanel.add(clickLabel(), BorderLayout.EAST);
        //bottomPanel.add(timeLabel(), BorderLayout.WEST);
        
        //bar.setStringPainted(true);
        bar.setMinimum(MIN);
        bar.setMaximum(MAX);
        
        clickButton = new JButton("Click Here!");
        clickButton.addActionListener(this);
        clickButton.setFont(new Font("Arial", 1, 40));
        
        clickLabel = new JLabel("Clicks: " + this.clicks, JLabel.CENTER);
        clickLabel.setFont(new Font("Arial", 0, 20));

        
        globalPanel.add(bar, BorderLayout.NORTH);
        globalPanel.add(clickButton, BorderLayout.CENTER);
        globalPanel.add(clickLabel, BorderLayout.SOUTH);
        
        frame.add(globalPanel);
        
        frame.setVisible(true);

        
        if (done) {
        	game.getLeftB().setEnabled(true);
        	game.getRightB().setEnabled(true);
        	game.getBehindB().setEnabled(true);
        	game.getFrontB().setEnabled(true);  
        }
        
        
        while (!done) {	
        	frame.getContentPane().repaint();
        }
        
        System.out.println(clicks);
        return clicks;
        
    }
    
    
    public JFrame getFrame() {
        return frame;
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
        
    	if (e.getSource() == this.clickButton) {

        	//behavior
            if (time != MAX) {
                clicks++;
                clickLabel.setText("Clicks: " + clicks);
                //percentage of victory
                //progression = (clicks * 100) / winScore;
                //progressionBar();
                if (clicks >= winScore) {
                	//player win
                    running = false;
                    win = true;
                    done = true;
                    frame.dispose();
   
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
                frame.dispose();
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException message) {
                // empty catch block
            }
            if (!running) continue;
            time++;
            bar.setValue(time);
        }
    }
    
}