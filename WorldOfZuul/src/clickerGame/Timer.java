package clickerGame;

import javax.swing.JOptionPane;

public class Timer implements Runnable {

    private boolean running = true;
    private int winScore = 100;

    public void setRunning(boolean running) {
        this.running = running; 
    }

    public boolean getRunning() {
        return running;
    }

    public int getWinScore() {
        return winScore;
    }

    public void setWinScore(int winScore) {
        this.winScore = winScore;
    }

    @Override
    public void run() {
        Screen screen = Clicker.getScreen();
        String fightMessage;
        while (this.running) {
            if (screen.getTime() == 15) {
                if (screen.getClicks() > winScore) {
                    fightMessage = "Victory !";
                } else {
                    fightMessage = "Too long";
                }
                Clicker.getScreen().setFightDone();
                //time is over
                System.exit(0);

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException message) {
                // empty catch block
            }
            if (!this.running) continue;
            screen.setTime(screen.getTime() + 1);
            screen.setTimeLabel("Time: " + screen.getTime());
        }
    }
}