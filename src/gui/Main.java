package gui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import components.CustomButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {	
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);

        CardLayout cardLayout = new CardLayout();
        JPanel parentPanel = new JPanel(cardLayout);

        JPanel beginPanel = new JPanel(null); 
        LoadingPanel loadingPanel = new LoadingPanel(cardLayout, parentPanel);
        MainMenuPanel mainMenuPanel = new MainMenuPanel(cardLayout, parentPanel);
        GamePanel gamePanel = new GamePanel(cardLayout, parentPanel);
        PlayerDetailsPanel playerDetailsPanel = new PlayerDetailsPanel(cardLayout, parentPanel);
        LeaderboardPanel leaderboardPanel = new LeaderboardPanel(cardLayout, parentPanel);

        parentPanel.add(beginPanel, "Begin");
        parentPanel.add(loadingPanel, "Loading");
        parentPanel.add(mainMenuPanel, "MainMenu");
        parentPanel.add(leaderboardPanel, "Leaderboard");
        parentPanel.add(playerDetailsPanel, "PlayerDetails");
        parentPanel.add(gamePanel, "Game");

        beginPanel.setBackground(new Color(255, 255, 255));
        CustomButton btnBegin = new CustomButton("BEGIN");
        btnBegin.setBounds(320, 266, 260, 80);
        btnBegin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "Loading");
                
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        cardLayout.show(parentPanel, "MainMenu");
                    }
                });
                timer.setRepeats(false);
                timer.start();
        }});
        beginPanel.add(btnBegin);

        frame.getContentPane().add(parentPanel);
        cardLayout.show(parentPanel, "Begin");

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
