import javax.swing.JOptionPane;

public class Timer
implements Runnable {
    private boolean running = true;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getRunning() {
        return this.running;
    }

    @Override
    public void run() {
        Screen screen = Clicker.getScreen();
        String fightMessage;
        while (this.running) {
            if (screen.getTime() == 30) {
            	if (screen.getClicks() > 140){
            		fightMessage = "Victoire !";
            	}
            	else {
            		fightMessage = "Vous êtes mort";
            	}
                JOptionPane.showMessageDialog(Clicker.getFrame(), fightMessage, "Results", 1);
                break;
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException message) {
                // empty catch block
            }
            if (!this.running) continue;
            screen.setTime(screen.getTime() + 1);
            screen.setTimeLabel("Time: " + screen.getTime());
        }
    }
}