package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import database.DatabaseConnection; // Ensure this exists for DB connection

class UserScore {
    private String username;
    private int totalScore;

    public UserScore(String username, int totalScore) {
        this.username = username;
        this.totalScore = totalScore;
    }

    public String getUsername() {
        return username;
    }

    public int getTotalScore() {
        return totalScore;
    }
}

public class LeaderboardPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	private JTable leaderboardTable;
    private DefaultTableModel tableModel;

    public LeaderboardPanel(CardLayout cardLayout, JPanel parentPanel) {
    	setBackground(new Color(255, 255, 255));
    	setLayout(null);

    	JLabel lblLeaderboard = new JLabel("Leaderboard");
    	lblLeaderboard.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
    	lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
    	lblLeaderboard.setBounds(12, 29, 976, 58);
    	add(lblLeaderboard);
    	
        // Table Model setup
        tableModel = new DefaultTableModel(new String[]{"Rank", "Username", "Total Score"}, 0);
        leaderboardTable = new JTable(tableModel);
        leaderboardTable.setFont(new Font("Arial", Font.PLAIN, 16));
        leaderboardTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        leaderboardTable.setRowHeight(30);
        leaderboardTable.getColumnModel().getColumn(0).setPreferredWidth(100);   
        leaderboardTable.getColumnModel().getColumn(1).setPreferredWidth(600);  
        leaderboardTable.getColumnModel().getColumn(2).setPreferredWidth(150);  

        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        scrollPane.setBounds(194, 110, 611, 450);
        add(scrollPane);
        
        fetchAndDisplayLeaderboard();
    }

    private void fetchAndDisplayLeaderboard() {
        List<UserScore> leaderboard = new ArrayList<>();
        String query = "SELECT username, score1, score2, score3, score4, score5 FROM user_data";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String username = rs.getString("username");
                int totalScore = rs.getInt("score1") + rs.getInt("score2") +
                                 rs.getInt("score3") + rs.getInt("score4") +
                                 rs.getInt("score5");

                leaderboard.add(new UserScore(username, totalScore));
            }

            // Sort users by totalScore in descending order
            leaderboard.sort(Comparator.comparingInt(UserScore::getTotalScore).reversed());

            // Clear existing rows in table
            tableModel.setRowCount(0);

            // Populate table with sorted data
            int rank = 1;
            for (UserScore user : leaderboard) {
                tableModel.addRow(new Object[]{rank, user.getUsername(), user.getTotalScore()});
                rank++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching leaderboard: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
