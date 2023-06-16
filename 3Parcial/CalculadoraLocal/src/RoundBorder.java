import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundBorder extends AbstractBorder {
    private int radius;

    public RoundBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(c.getBackground());

        int r = radius * 2;
        g2.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, r, r));
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius, radius, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = insets.top = insets.bottom = radius;
        return insets;
    }
}