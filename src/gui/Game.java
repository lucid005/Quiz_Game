package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cardLayout = new CardLayout(0, 0);
		contentPane.setLayout(cardLayout);
		
		JPanel Loading_Panel = new JPanel();
		contentPane.add(Loading_Panel, "name_27207842674591");
		Loading_Panel.setLayout(null);
		
			JLabel LoadingLogo = new JLabel("");
			LoadingLogo.setHorizontalAlignment(SwingConstants.CENTER);
			LoadingLogo.setBounds(12, 150, 966, 179);
			ImageIcon iconLogo = new ImageIcon(Game.class.getResource("/resources/Logo.png"));
	        Image imgLogo = iconLogo.getImage();
	        Image scaledLogo = imgLogo.getScaledInstance(360, 160, Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(scaledLogo);
	        LoadingLogo.setIcon(scaledIcon);
			Loading_Panel.add(LoadingLogo);
			
			JLabel lblLoading = new JLabel("Loading...");
			lblLoading.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
			lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
			lblLoading.setBounds(12, 341, 966, 51);
			Loading_Panel.add(lblLoading);
		
		JPanel MainMenu_Panel = new JPanel();
		contentPane.add(MainMenu_Panel, "MainMenu");
		
		cardLayout.show(contentPane, "Loading");
		
		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "MainMenu");
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}
