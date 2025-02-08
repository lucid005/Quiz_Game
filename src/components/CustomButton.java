package components;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class CustomButton extends JButton {

    private static final long serialVersionUID = 1L;

    // Properties for customization
    private int cornerRadius = 20; // Border radius
    private Color shadowColor = new Color(0, 0, 0, 100); // Drop shadow color
    private int shadowOffset = 5; // Drop shadow offset
    private Color strokeColor = Color.BLACK; // Stroke color
    private int strokeWidth = 2; // Stroke width

    public CustomButton(String text) {
        super(text);
        setContentAreaFilled(false); // Make the button transparent
        setFocusPainted(false); // Remove the focus border
        setFont(new Font("Arial Black", Font.BOLD, 24));
        setForeground(Color.WHITE); // Text color
        setPreferredSize(new Dimension(200, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // Draw drop shadow
        g2.setColor(shadowColor);
        g2.fill(new RoundRectangle2D.Double(
            shadowOffset, shadowOffset, width - shadowOffset, height - shadowOffset, cornerRadius, cornerRadius
        ));

        // Draw the button background
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(
            0, 0, width - shadowOffset, height - shadowOffset, cornerRadius, cornerRadius
        ));

        // Draw stroke (border)
        g2.setColor(strokeColor);
        g2.setStroke(new BasicStroke(strokeWidth));
        g2.draw(new RoundRectangle2D.Double(
            strokeWidth / 2.0, strokeWidth / 2.0, width - shadowOffset - strokeWidth, height - shadowOffset - strokeWidth, cornerRadius, cornerRadius
        ));

        // Draw the button text
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint the default border
    }

    // Getters and setters for customization properties
    public int getCornerRadius() {
        return cornerRadius;
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        repaint();
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
        repaint();
    }

    public int getShadowOffset() {
        return shadowOffset;
    }

    public void setShadowOffset(int shadowOffset) {
        this.shadowOffset = shadowOffset;
        repaint();
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
        repaint();
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        repaint();
    }
}