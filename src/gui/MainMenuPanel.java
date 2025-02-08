package gui;

import java.awt.*;
import javax.swing.*;

import components.BackgroundPanel;
import components.CustomButton;

public class MainMenuPanel extends BackgroundPanel {

    private static final long serialVersionUID = 1L;

    public MainMenuPanel(CardLayout cardLayout, JPanel parentPanel) {
        setLayout(new GridBagLayout());

        // Load the logo
        ImageIcon iconLogo = new ImageIcon(Main.class.getResource("/resources/Logo.png"));
        Image imgLogo = iconLogo.getImage().getScaledInstance(360, 160, Image.SCALE_SMOOTH);
        JLabel lblQuizo = new JLabel(new ImageIcon(imgLogo));

        // Play Button
        CustomButton btnPlay = new CustomButton("Play");
        btnPlay.setPreferredSize(new Dimension(260, 55));
        btnPlay.setBackground(new Color(0, 123, 255));
        btnPlay.setCornerRadius(25); 
        btnPlay.setShadowOffset(5);
        btnPlay.setStrokeWidth(2); 
        btnPlay.addActionListener(e -> cardLayout.show(parentPanel, "Loading"));

        // Leaderboard Button
        CustomButton btnLeaderboard = new CustomButton("Leaderboard");
        btnLeaderboard.setPreferredSize(new Dimension(260, 55));
        btnLeaderboard.setBackground(new Color(40, 167, 69)); 
        btnLeaderboard.setCornerRadius(25); 
        btnLeaderboard.setShadowOffset(5);
        btnLeaderboard.setStrokeWidth(2); 

        // Exit Button
        CustomButton btnExit = new CustomButton("Exit");
        btnExit.setPreferredSize(new Dimension(260, 55));
        btnExit.setBackground(new Color(220, 53, 69)); 
        btnExit.setCornerRadius(25); 
        btnExit.setShadowOffset(5); 
        btnExit.setStrokeWidth(2); 
        btnExit.addActionListener(e -> System.exit(0));

        // Add the logo to the panel
        GridBagConstraints gbcLogo = new GridBagConstraints();
        gbcLogo.gridx = 0;
        gbcLogo.gridy = 0;
        gbcLogo.insets = new Insets(20, 10, 40, 10);
        gbcLogo.anchor = GridBagConstraints.CENTER;
        add(lblQuizo, gbcLogo);

        // Add the Play button
        GridBagConstraints gbcPlay = new GridBagConstraints();
        gbcPlay.gridx = 0;
        gbcPlay.gridy = 1;
        gbcPlay.insets = new Insets(10, 10, 10, 10);
        gbcPlay.anchor = GridBagConstraints.CENTER;
        add(btnPlay, gbcPlay);

        // Add the Leaderboard button
        GridBagConstraints gbcLeaderboard = new GridBagConstraints();
        gbcLeaderboard.gridx = 0;
        gbcLeaderboard.gridy = 2;
        gbcLeaderboard.insets = new Insets(10, 10, 10, 10);
        gbcLeaderboard.anchor = GridBagConstraints.CENTER;
        add(btnLeaderboard, gbcLeaderboard);

        // Add the Exit button
        GridBagConstraints gbcExit = new GridBagConstraints();
        gbcExit.gridx = 0;
        gbcExit.gridy = 3;
        gbcExit.insets = new Insets(10, 10, 10, 10);
        gbcExit.anchor = GridBagConstraints.CENTER;
        add(btnExit, gbcExit);
    }
}