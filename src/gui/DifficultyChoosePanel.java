package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.CustomButton;
import java.awt.Font;
import model.User_model;
import user.Registration;

public class DifficultyChoosePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboBox;
    private CardLayout cardLayout;
    private JPanel parentPanel; 
    private User_model user; 

    public DifficultyChoosePanel(CardLayout cardLayout, JPanel parentPanel, User_model user) {
        this.cardLayout = cardLayout; 
        this.parentPanel = parentPanel; 
        this.user = user;
        setBackground(new Color(255, 255, 255));
        setLayout(new GridBagLayout());

        // Back Button
        CustomButton btnBack = new CustomButton("Back");
        btnBack.setPreferredSize(new Dimension(200, 50));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "PlayerDetails");
            }
        });
        GridBagConstraints gbcBack = new GridBagConstraints();
        gbcBack.gridx = 0;
        gbcBack.gridy = 0;
        gbcBack.insets = new Insets(20, 20, 10, 10);
        gbcBack.weightx = 1.0; 
        gbcBack.weighty = 1.0; 
        gbcBack.anchor = GridBagConstraints.NORTHWEST;
        add(btnBack, gbcBack);

        // Label
        JLabel title = new JLabel("Choose a difficulty Level: ");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 1;
        gbcTitle.insets = new Insets(10, 10, 10, 10);
        gbcTitle.weightx = 1.0; 
        gbcTitle.weighty = 0.0; 
        gbcTitle.anchor = GridBagConstraints.CENTER;
        add(title, gbcTitle);

        // ComboBox
        String[] items = {"Beginner", "Intermediate", "Expert"};
        comboBox = new JComboBox<>(items);
        comboBox.setPreferredSize(new Dimension(250, 40));
        GridBagConstraints gbcComboBox = new GridBagConstraints();
        gbcComboBox.gridx = 0;
        gbcComboBox.gridy = 2;
        gbcComboBox.insets = new Insets(10, 10, 10, 10);
        gbcComboBox.weightx = 1.0; 
        gbcComboBox.weighty = 4.0; 
        gbcComboBox.anchor = GridBagConstraints.NORTH;
        add(comboBox, gbcComboBox);

        // Save Button
        CustomButton btnSave = new CustomButton("Save");
        btnSave.setPreferredSize(new Dimension(200, 50));
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String difficultyLevel = (String) comboBox.getSelectedItem();
                user.setDifficulty_level(difficultyLevel); 
                Registration register = new Registration();
                register.updatePlayerDifficulty(user); 

                // Pass the difficulty level to the GamePanel
                GamePanel gamePanel = new GamePanel(cardLayout, parentPanel, user, difficultyLevel);
                parentPanel.add(gamePanel, "Game");
                cardLayout.show(parentPanel, "Game");
            }
        });
        GridBagConstraints gbcSave = new GridBagConstraints();
        gbcSave.gridx = 0;
        gbcSave.gridy = 3;
        gbcSave.insets = new Insets(10, 10, 10, 10);
        gbcSave.weightx = 1.0; 
        gbcSave.weighty = 1.0; 
        gbcSave.anchor = GridBagConstraints.NORTH;
        add(btnSave, gbcSave);
    }
}