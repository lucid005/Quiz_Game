package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;

import components.CustomButton;
import components.CustomTextField;

public class PlayerDetailsPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public PlayerDetailsPanel(CardLayout cardLayout, JPanel parentPanel) {
        setBackground(new Color(255, 255, 255)); 
        setLayout(new GridBagLayout());

        // Back Button
        CustomButton btnBack = new CustomButton("Back");
        btnBack.setPreferredSize(new Dimension(200, 50));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(parentPanel, "MainMenu");
            }
        });
        GridBagConstraints gbcBack = new GridBagConstraints();
	        gbcBack.gridx = 0;
	        gbcBack.gridy = 0; 
	        gbcBack.insets = new Insets(20, 20, 10, 10);
	        gbcBack.anchor = GridBagConstraints.NORTHWEST; 
	        gbcBack.weightx = 1.0; 
	        gbcBack.weighty = 0.0; 
	        add(btnBack, gbcBack);

        // Title 
        JLabel lblPlayerDetails = new JLabel("Player Details");
        lblPlayerDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 46));
        GridBagConstraints gbcTitle = new GridBagConstraints();
	        gbcTitle.gridx = 0; 
	        gbcTitle.gridy = 1; 
	        gbcTitle.insets = new Insets(20, 10, 20, 10); 
	        gbcTitle.anchor = GridBagConstraints.CENTER; 
	        gbcTitle.weightx = 1.0; 
	        gbcTitle.weighty = 0.0; 
	        add(lblPlayerDetails, gbcTitle);

        // Username Text Field
        CustomTextField usernameTextField = new CustomTextField(20);
        usernameTextField.setPreferredSize(new Dimension(500, 70));
        usernameTextField.setPlaceholder("Enter Username"); 
        GridBagConstraints gbcUsername = new GridBagConstraints();
	        gbcUsername.gridx = 0; 
	        gbcUsername.gridy = 2; 
	        gbcUsername.insets = new Insets(10, 10, 10, 10);
	        gbcUsername.anchor = GridBagConstraints.CENTER; 
	        gbcUsername.weightx = 1.0; 
	        gbcUsername.weighty = 0.0; 
	        add(usernameTextField, gbcUsername);

        // Age Text Field 
        CustomTextField ageTextField = new CustomTextField(20);
        ageTextField.setPreferredSize(new Dimension(500, 70));
        ageTextField.setPlaceholder("Enter Age"); 
        GridBagConstraints gbcAge = new GridBagConstraints();
	        gbcAge.gridx = 0; 
	        gbcAge.gridy = 3; 
	        gbcAge.insets = new Insets(10, 10, 10, 10); 
	        gbcAge.anchor = GridBagConstraints.CENTER;
	        gbcAge.weightx = 1.0; 
	        gbcAge.weighty = 0.0;
	        add(ageTextField, gbcAge);

        // Save Button 
        CustomButton btnSave = new CustomButton("Save");
        btnSave.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbcSave = new GridBagConstraints();
	        gbcSave.gridx = 0; 
	        gbcSave.gridy = 4; 
	        gbcSave.insets = new Insets(20, 10, 20, 10);
	        gbcSave.anchor = GridBagConstraints.NORTH; 
	        gbcSave.weightx = 1.0; 
	        gbcSave.weighty = 1.0; 
	        add(btnSave, gbcSave);
    }
}