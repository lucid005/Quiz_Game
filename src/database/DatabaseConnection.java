package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Password_mysql10169";
    private static final String DB_NAME = "Quiz_Game";
    
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                Connection tempConnection = DriverManager.getConnection(URL, USER, PASSWORD);

                try (Statement statement = tempConnection.createStatement()) {
                    statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
                }
                
                tempConnection.close();

                connection = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
//                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the connection: " + e.getMessage());
        }
    }
}
