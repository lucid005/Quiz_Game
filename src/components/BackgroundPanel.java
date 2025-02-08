package components;

import java.awt.*;
import javax.swing.*;

import gui.Main;

public class BackgroundPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage; // Background image

    public BackgroundPanel() {
        // Load the background image
        backgroundImage = new ImageIcon(Main.class.getResource("/resources/background.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}