package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.CustomButton;

public class MainMenuPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public MainMenuPanel(CardLayout cardLayout, JPanel parentPanel) {
    	setBackground(new Color(255, 255, 255));
        setLayout(new GridBagLayout());

        // Load the logo
        ImageIcon iconLogo = new ImageIcon(Main.class.getResource("/resources/Logo.png"));
        Image imgLogo = iconLogo.getImage().getScaledInstance(360, 160, Image.SCALE_SMOOTH);
        JLabel lblQuizo = new JLabel(new ImageIcon(imgLogo));
        GridBagConstraints gbcLogo = new GridBagConstraints();
	        gbcLogo.gridx = 0;
	        gbcLogo.gridy = 0;
	        gbcLogo.insets = new Insets(20, 10, 40, 10);
	        gbcLogo.anchor = GridBagConstraints.CENTER;
	        add(lblQuizo, gbcLogo);

        // Play Button
        CustomButton btnPlay = new CustomButton("Play");
        btnPlay.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(parentPanel, "PlayerDetails");
        	}
        });
        btnPlay.setPreferredSize(new Dimension(260, 70));
        GridBagConstraints gbcPlay = new GridBagConstraints();
	        gbcPlay.gridx = 0;
	        gbcPlay.gridy = 1;
	        gbcPlay.insets = new Insets(10, 10, 10, 10);
	        gbcPlay.anchor = GridBagConstraints.CENTER;
	        add(btnPlay, gbcPlay);

        // Leaderboard Button
        CustomButton btnLeaderboard = new CustomButton("Leaderboard");
        btnLeaderboard.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(parentPanel, "Leaderboard");
        	}
        });
        btnLeaderboard.setPreferredSize(new Dimension(260, 70)); 
        btnLeaderboard.setHoverColor(new Color(246, 211, 45));
        GridBagConstraints gbcLeaderboard = new GridBagConstraints();
	        gbcLeaderboard.gridx = 0;
	        gbcLeaderboard.gridy = 2;
	        gbcLeaderboard.insets = new Insets(10, 10, 10, 10);
	        gbcLeaderboard.anchor = GridBagConstraints.CENTER;
	        add(btnLeaderboard, gbcLeaderboard);

        // Exit Button
        CustomButton btnExit = new CustomButton("Exit");
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnExit.setPreferredSize(new Dimension(260, 70));	
        btnExit.setHoverColor(new Color(224, 27, 36));
        GridBagConstraints gbcExit = new GridBagConstraints();
	        gbcExit.gridx = 0;
	        gbcExit.gridy = 3;
	        gbcExit.insets = new Insets(10, 10, 10, 10);
	        gbcExit.anchor = GridBagConstraints.CENTER;
	        add(btnExit, gbcExit);

    }
}