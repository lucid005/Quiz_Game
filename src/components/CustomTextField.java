package components;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CustomTextField extends JTextField {
    private static final long serialVersionUID = 1L;

    private Color backgroundColor = new Color(144, 238, 144); // Light green
    private Color borderColor = new Color(34, 139, 34); // Dark green border
    private Color textColor = new Color(34, 139, 34); // Dark green text
    private Color placeholderColor = new Color(100, 100, 100); // Gray placeholder text
    private String placeholder = ""; // Placeholder text

    public CustomTextField(int columns) {
        super(columns);
        setOpaque(false);
        setForeground(textColor);
        setFont(new Font("Comic Sans MS", Font.BOLD, 20)); 
        setBorder(new EmptyBorder(10, 15, 10, 15)); 
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

        // Set background color
        g2.setColor(backgroundColor);
        g2.fill(shape);

        // Draw text field border
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(4));
        g2.draw(shape);

        // Draw placeholder text if no text is entered
        if (getText().isEmpty() && !placeholder.isEmpty()) {
            g2.setColor(placeholderColor);
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            FontMetrics fm = g2.getFontMetrics();
            int textX = 15; // Adjust padding
            int textY = (height + fm.getAscent()) / 2 - 4;
            g2.drawString(placeholder, textX, textY);
        }

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint default border
    }

    // Setter methods for customizing colors
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        setForeground(textColor);
    }

    // Setter for placeholder text
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }
}