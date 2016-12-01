import java.awt.Component;
import javax.swing.JFrame;

public class Clicker {
    private static Screen screen = new Screen();
    private static JFrame frame;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Clicker.getScreen().addComponents();
        frame.add(Clicker.getScreen());
        frame.setVisible(true);
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
}