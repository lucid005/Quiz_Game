package gui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Color;

public class LoadingPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public LoadingPanel(CardLayout cardLayout, JPanel parentPanel) {
		setBackground(new Color(255, 255, 255));
		setLayout(new GridBagLayout());
		
		ImageIcon iconLogo = new ImageIcon(Main.class.getResource("/resources/Logo.png"));
        Image imgLogo = iconLogo.getImage();
        Image scaledLogo = imgLogo.getScaledInstance(360, 160, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledLogo);
		
		JLabel LoadingLogo = new JLabel("");
		LoadingLogo.setHorizontalAlignment(SwingConstants.CENTER);
		LoadingLogo.setBounds(12, 150, 966, 179);
		LoadingLogo.setIcon(scaledIcon);
		GridBagConstraints gbcLogo = new GridBagConstraints();
		gbcLogo.anchor = GridBagConstraints.NORTHWEST;
	    	gbcLogo.insets = new Insets(10, 10, 10, 10);
	    	gbcLogo.gridx = 0;
	    	gbcLogo.gridy = 0;
	    	add(LoadingLogo, gbcLogo);
		
		JLabel lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setBounds(12, 341, 966, 51);
		GridBagConstraints gbcLabel = new GridBagConstraints();
	    	gbcLabel.insets = new Insets(10, 10, 10, 10);
	    	gbcLabel.gridx = 0;
	    	gbcLabel.gridy = 1;
	        add(lblLoading, gbcLabel);
		
		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(parentPanel, "MainMenu");
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

}
