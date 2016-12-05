package clickerGame;

import javax.swing.JFrame;

public class Clicker {
    private static Screen screen = new Screen();
    private static JFrame frame;



    public static int clickerLauncher (int clicksAsked) {
        JFrame frame = new JFrame();
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Clicker.getScreen().addComponents();
        frame.add(Clicker.getScreen());
        frame.setVisible(true);
        screen.getTimer().setWinScore(clicksAsked);
        //while(true)
        {
        	//if(screen.getFightDone() == true)
        	{
        		frame.dispose();
        		return screen.getClicks();
        	}
        }
        
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        Clicker.screen = screen;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        Clicker.frame = frame;
    }
    
    public void dispose()
    {
    	frame.dispose();
    }
    

}