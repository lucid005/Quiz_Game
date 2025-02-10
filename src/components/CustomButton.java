package components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.JButton;

public class CustomButton extends JButton {
    private static final long serialVersionUID = 1L;

    private Color defaultColor = new Color(144, 238, 144); // Light green
    private Color hoverColor = new Color(102, 205, 102); // Default darker green
    private boolean isHovered = false; // Flag to track hover state

    public CustomButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(new Color(34, 139, 34)); // Dark green text
        setFont(new Font("Comic Sans MS", Font.BOLD, 28)); // Playful font

        // Add hover effect using MouseListener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Create a wavy irregular border
        Path2D.Float shape = new Path2D.Float();
        shape.moveTo(10, 20);
        shape.curveTo(40, 5, width - 40, 5, width - 10, 20);
        shape.curveTo(width - 5, height / 2, width - 40, height - 5, width - 10, height - 10);
        shape.curveTo(width / 2, height, 40, height - 5, 10, height - 10);
        shape.curveTo(5, height / 2, 5, 20, 10, 20);
        shape.closePath();

        // Set background color (default or hover)
        g2.setColor(isHovered ? hoverColor : defaultColor);
        g2.fill(shape);

        // Draw button border
        g2.setColor(new Color(34, 139, 34)); // Darker green border
        g2.setStroke(new BasicStroke(4));
        g2.draw(shape);

        // Draw text
        FontMetrics fm = g2.getFontMetrics();
        int textX = (width - fm.stringWidth(getText())) / 2;
        int textY = (height + fm.getAscent()) / 2 - 4;
        g2.drawString(getText(), textX, textY);

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint default border
    }

    // Setter method for customizing hover color
    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }
}
