package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;
import model.User_model;

public class Registration {
    public void addPlayer(User_model player) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        // Check if the player already exists
        if (playerExists(player)) {
            // If the player exists, update their scores
            updatePlayerScores(player);
            System.out.println("Player already exists. Scores updated.");
        } else {
            // If the player does not exist, insert a new player
            insertNewPlayer(player);
            System.out.println("New player added successfully.");
        }
    }

    private boolean playerExists(User_model player) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return false;
        }

        String selectSQL = "SELECT COUNT(*) FROM user_data WHERE username = ? AND age = ? AND difficulty_level = ?";
        try (PreparedStatement stmt = connection.prepareStatement(selectSQL)) {
            stmt.setString(1, player.getUsername());
            stmt.setInt(2, player.getAge());
            stmt.setString(3, player.getDifficulty_level());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // If count > 0, the player already exists
                }
            }
        } catch (SQLException e) {
            System.out.println("Error checking if player exists: " + e.getMessage());
        }

        return false;
    }

    private void insertNewPlayer(User_model player) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        String insertSQL = "INSERT INTO user_data(username, age, difficulty_level, score1, score2, score3, score4, score5) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertSQL)) {
            stmt.setString(1, player.getUsername());
            stmt.setInt(2, player.getAge());
            stmt.setString(3, player.getDifficulty_level());
            stmt.setInt(4, player.getScore1());
            stmt.setInt(5, player.getScore2());
            stmt.setInt(6, player.getScore3());
            stmt.setInt(7, player.getScore4());
            stmt.setInt(8, player.getScore5());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding new player: " + e.getMessage());
        }
    }

    public void updatePlayerScores(User_model player) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        String updateSQL = "UPDATE user_data SET score1 = ?, score2 = ?, score3 = ?, score4 = ?, score5 = ? WHERE username = ? AND age = ? AND difficulty_level = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateSQL)) {
            stmt.setInt(1, player.getScore1());
            stmt.setInt(2, player.getScore2());
            stmt.setInt(3, player.getScore3());
            stmt.setInt(4, player.getScore4());
            stmt.setInt(5, player.getScore5());
            stmt.setString(6, player.getUsername());
            stmt.setInt(7, player.getAge());
            stmt.setString(8, player.getDifficulty_level());

            stmt.executeUpdate();
            System.out.println("Player scores updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating player scores: " + e.getMessage());
        }
    }

    public void updatePlayerDifficulty(User_model player) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        String updateSQL = "UPDATE user_data SET difficulty_level = ? WHERE username = ? AND age = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateSQL)) {
            stmt.setString(1, player.getDifficulty_level());
            stmt.setString(2, player.getUsername());
            stmt.setInt(3, player.getAge());

            stmt.executeUpdate();
            System.out.println("Player difficulty level updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating player difficulty level: " + e.getMessage());
        }
    }
}