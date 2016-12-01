import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClickerScreen
extends JPanel
implements ActionListener {
    private static final long serialVersionUID = 1;
    private int clicks = 0;
    private int time = 0;
    private JButton clickButton = new JButton("Click Here!");
    private JButton restartButton = new JButton("Restart");
    private JLabel clickLabel = new JLabel("Clicks: " + this.clicks);
    private JLabel timeLabel = new JLabel("Time: " + this.time);
    Timer timer = new Timer();

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getClicks() {
        return this.clicks;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    private JButton restartButton() {
        this.restartButton.setBounds(150, 350, 100, 50);
        this.restartButton.addActionListener(this);
        this.restartButton.setFont(new Font("Arial", 0, 20));
        return this.restartButton;
    }

    private JButton clickButton() {
        this.clickButton.setBounds(20, 25, 350, 300);
        this.clickButton.addActionListener(this);
        this.clickButton.setFont(new Font("Arial", 1, 40));
        return this.clickButton;
    }

    private JLabel clickLabel() {
        this.clickLabel.setBounds(50, 325, 100, 50);
        this.clickLabel.setFont(new Font("Arial", 0, 20));
        return this.clickLabel;
    }

    private JLabel timeLabel() {
        this.timeLabel.setBounds(275, 325, 100, 50);
        this.timeLabel.setFont(new Font("Arial", 0, 20));
        return this.timeLabel;
    }

    public void setTimeLabel(String label) {
        this.timeLabel.setText(label);
    }

    public void addComponents() {
        this.setLayout(null);
        this.add(this.restartButton());
        this.add(this.clickButton());
        this.add(this.clickLabel());
        this.add(this.timeLabel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.clickButton) {
            this.timer.setRunning(true);
            if (this.time != 10) {
                ++this.clicks;
                this.clickLabel.setText("Clicks: " + this.clicks);
            }
            if (this.clicks == 1) {
                new Thread(this.timer).start();
            }
        } else if (e.getSource() == this.restartButton) {
            this.timer.setRunning(false);
            this.time = 0;
            this.clicks = 0;
            this.timeLabel.setText("Time: " + this.time);
            this.clickLabel.setText("Clicks: " + this.clicks);
        }
    }
}