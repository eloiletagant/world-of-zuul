import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;


class MyProgressUI extends BasicProgressBarUI {

    private Rectangle r = new Rectangle();

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        r = getBox(r);
        g.setColor(progressBar.getForeground());
        g.fillOval(r.x, r.y, r.width, r.height);
    }
}
