package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import components.CustomButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    public ScorePanel(int score, int totalQuestions, CardLayout cardLayout, JPanel parentPanel) {
        setBackground(new Color(255, 255, 255));
        setLayout(new GridBagLayout());

        JLabel scoreLabel = new JLabel("Your Score: " + score + "/" + totalQuestions);
        scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        scoreLabel.setBounds(80, 50, 300, 40);
        GridBagConstraints gbc_Score = new GridBagConstraints();
        gbc_Score.gridwidth = 0;
        gbc_Score.insets = new Insets(0, 0, 20, 0);
        gbc_Score.gridx = 0;
        gbc_Score.gridy = 0;
        add(scoreLabel, gbc_Score);

        CustomButton restartButton = new CustomButton("Restart");
        restartButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        restartButton.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_Restart = new GridBagConstraints();
        gbc_Restart.gridwidth = 0;
        gbc_Restart.insets = new Insets(0, 0, 20, 0);
        gbc_Restart.gridx = 0;
        gbc_Restart.gridy = 1;
        add(restartButton, gbc_Restart);

        CustomButton mainMenuButton = new CustomButton("Main Menu");
        mainMenuButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        mainMenuButton.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_MainMenu = new GridBagConstraints();
        gbc_MainMenu.gridwidth = 0;
        gbc_MainMenu.insets = new Insets(0, 0, 20, 0);
        gbc_MainMenu.gridx = 0;
        gbc_MainMenu.gridy = 2;
        add(mainMenuButton, gbc_MainMenu);

        // Action for restart button
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Component gamePanelComponent = parentPanel.getComponent(0); // Index 0 assuming GamePanel is first
                if (gamePanelComponent instanceof GamePanel) {
                    GamePanel gamePanel = (GamePanel) gamePanelComponent;
                    gamePanel.resetButtons(); 
                }

                // Restart the game or reset the score
                cardLayout.show(parentPanel, "Game");
            }
        });

        // Action for main menu button
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Go to main menu
                cardLayout.show(parentPanel, "MainMenu");
            }
        });
    }
}
