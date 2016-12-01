package clickerGame;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Screen extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1;
    private int clicks = 0;
    private int time = 0;
    private int progression = 0;
    private JPanel progressionBar = new JPanel();
    private boolean fightDone = false;


    private JButton clickButton = new JButton("Click Here!");
    private JButton restartButton = new JButton("Restart");
    private JLabel clickLabel = new JLabel("Clicks: " + this.clicks);
    private JLabel timeLabel = new JLabel("Time: " + this.time);

    Timer timer = new Timer();

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getClicks() {
        return clicks;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public Timer getTimer() {
        return timer;
    }

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

    public void setTimeLabel(String label) {
        this.timeLabel.setText(label);
    }

    public void addComponents() {
        this.setLayout(null);
        this.add(this.progressionBar());
        this.add(this.clickButton());
        this.add(this.clickLabel());
        this.add(this.timeLabel());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.clickButton) {
            this.timer.setRunning(true);
            //behavior
            if (this.time != 10) {
                clicks++;
                clickLabel.setText("Clicks: " + clicks);
                //percentage of victory
                progression = (clicks * 100) / timer.getWinScore();
                progressionBar();
                if (clicks == timer.getWinScore()) {
                    timer.setRunning(false);
                    clickButton.setEnabled(false);

                    timer.setRunning(false);
                    clickButton.setEnabled(true);
                    setFightDone();
                    JOptionPane.showMessageDialog(Clicker.getFrame(), "Win", "Results", 1);
                }
            }
            //trigger the timer in the first click
            if (clicks == 1) {
                new Thread(timer).start();
            }
        }
    }
    
    public void setFightDone() {
    	fightDone = true;
    }
    
    public boolean getFightDone()
    {
    	return fightDone;
    }
}