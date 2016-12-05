package clickerGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Clicker extends JPanel implements ActionListener, Runnable  {
	
 
    private int clicks = 0;
    private int time = 0;
    private int progression = 0;
    private int winScore;
    private boolean win = false;
    private boolean running = false;
    
    
    private JFrame frame;
    private JPanel progressionBar = new JPanel();
    private JButton clickButton = new JButton("Click Here!");
    private JLabel clickLabel = new JLabel("Clicks: " + this.clicks);
    private JLabel timeLabel = new JLabel("Time: " + this.time);
        
    public static void main(String[] args) {
    	Clicker clicker = new Clicker();
    	clicker.clickerLauncher(15);
    }
    
    public boolean clickerLauncher (int clicksAsked) {
        
    	frame = new JFrame();
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        winScore = clicksAsked;
        
        //add comp
        frame.setLayout(null);
        frame.add(progressionBar());
        frame.add(clickButton());
        frame.add(clickLabel());
        frame.add(timeLabel());
        
        frame.setVisible(true);
        
        return win;
        
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


    
    
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
      
    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public void setTime(int time) {
        this.time = time;
    }
 
    public void setTimeLabel(String label) {
        this.timeLabel.setText(label);
    }
    
    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }
    
    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
    
    
    public void dispose() {
    	frame.dispose();
    }
    
    
    
    //set the screen items
    private JPanel progressionBar() {

        int xProgression = (progression * 340) / 100;
        if (xProgression <= 340) {
            progressionBar.setBounds(30 + xProgression, 20, 340 - xProgression, 50);
        } else {
            progressionBar = new JPanel();
            clickButton.setText("Win");
        }

        progressionBar.setBackground(Color.red);
        return progressionBar;
    }

    private JButton clickButton() {
        clickButton.setBounds(20, 100, 360, 200);
        clickButton.addActionListener(this);
        clickButton.setFont(new Font("Arial", 1, 40));
        return clickButton;
    }

    private JLabel clickLabel() {
        clickLabel.setBounds(50, 325, 100, 50);
        clickLabel.setFont(new Font("Arial", 0, 20));
        return clickLabel;
    }

    private JLabel timeLabel() {
        timeLabel.setBounds(275, 325, 100, 50);
        timeLabel.setFont(new Font("Arial", 0, 20));
        return timeLabel;
    }


    
    
    
    
    
    //buttons listener
    @Override
    public void actionPerformed(ActionEvent e) {
        
    	if (e.getSource() == this.clickButton) {
            
        	//start to run the fight
        	running = true;
            
        	//behavior
            if (time != 15) {
                clicks++;
                clickLabel.setText("Clicks: " + clicks);
                //percentage of victory
                progression = (clicks * 100) / winScore;
                progressionBar();
                if (clicks == winScore) {
                	//player win
                    running = false;
                    win = true;
                    clickButton.setEnabled(false);
                    
                }
            }
            //trigger the timer in the first click
            if (clicks == 1) {
                new Thread(this).start();
            }
        }
    }
    

    
    
    //timer
    @Override
    public void run() {
        while (running) {
        	//time is over
            if (time == 15) {
                if (clicks >= winScore) {
                	win = true;
                } else {
                	win = false;
                }
                running = false;                
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException message) {
                // empty catch block
            }
            if (!running) continue;
            time++;
            setTimeLabel("Time: " + time);
        }
    }
    

}