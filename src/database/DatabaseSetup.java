package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSetup {
    public static void createQuestionTable() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        try {
            Statement stmt = connection.createStatement();
            
            // Create table for quiz questions if not exists
            String createQuizQuestionsTableSQL = 
                "CREATE TABLE IF NOT EXISTS quiz_questions (" +
                "question_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "question_text VARCHAR(255) NOT NULL, " +
                "option_a VARCHAR(100) NOT NULL, " +
                "option_b VARCHAR(100) NOT NULL, " +
                "option_c VARCHAR(100) NOT NULL, " +
                "option_d VARCHAR(100) NOT NULL, " +
                "correct_answer CHAR(1) NOT NULL, " + 
                "difficulty_level VARCHAR(50) NOT NULL" +
                ");";
                
            stmt.executeUpdate(createQuizQuestionsTableSQL);
            System.out.println("quiz_questions table created sucessfully.");
            
        } catch (SQLException e) {
            System.err.println("Error during database setup: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
    
    public static void createUserDataTable() {
    	Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }
        
        try {
        	Statement stmt = connection.createStatement();
        	
        	String createUserDataTableSQL = 
        			"CREATE TABLE IF NOT EXISTS user_data (" +
        					"id INT AUTO_INCREMENT PRIMARY KEY, " +
        					"username VARCHAR(50) NOT NULL, " +
        					"password VARCHAR(50), "+
        					"role VARCHAR(50), " +
        					");";
        	stmt.executeUpdate(createUserDataTableSQL);
        	System.out.println("user_data table created sucessfully.");
        } catch (SQLException e) {
        	System.err.println("Error during database setup: " + e.getMessage());
        } finally {
        	DatabaseConnection.closeConnection();
        }
    }
    
    public static void main(String[] args) {
    	createQuestionTable();
    }
}
