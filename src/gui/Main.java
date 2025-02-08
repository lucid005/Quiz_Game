package gui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);

        CardLayout cardLayout = new CardLayout();
        JPanel parentPanel = new JPanel(cardLayout);

        LoadingPanel loadingPanel = new LoadingPanel(cardLayout, parentPanel);
        MainMenuPanel mainMenuPanel = new MainMenuPanel(cardLayout, parentPanel);

        parentPanel.add(loadingPanel, "Loading");
        parentPanel.add(mainMenuPanel, "MainMenu");

        frame.add(parentPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}