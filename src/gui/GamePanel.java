package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public GamePanel(CardLayout cardLayout, JPanel parentPanel) {
		setBackground(new Color(255, 255, 255));
		setLayout(new GridBagLayout());
	}

}
