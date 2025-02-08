package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Question_model;

public class QuestionDAO {

    // Add a new quiz question
    public void addQuestion(Question_model question) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        String insertSQL = "INSERT INTO quiz_questions (question_text, option_a, option_b, option_c, option_d, correct_answer, difficulty_level) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertSQL)) {
            stmt.setString(1, question.getQuestionText());
            stmt.setString(2, question.getOptionA());
            stmt.setString(3, question.getOptionB());
            stmt.setString(4, question.getOptionC());
            stmt.setString(5, question.getOptionD());
            stmt.setString(6, question.getCorrectAnswer());
            stmt.setString(7, question.getDifficultyLevel());

            stmt.executeUpdate();
            System.out.println("Quiz question added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding quiz question: " + e.getMessage());
        }
    }

    // Update an existing quiz question
    public void updateQuizQuestion(Question_model question) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        String updateSQL = "UPDATE quiz_questions SET question_text = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, correct_answer = ?, difficulty_level = ? WHERE question_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateSQL)) {
            stmt.setString(1, question.getQuestionText());
            stmt.setString(2, question.getOptionA());
            stmt.setString(3, question.getOptionB());
            stmt.setString(4, question.getOptionC());
            stmt.setString(5, question.getOptionD());
            stmt.setString(6, question.getCorrectAnswer());
            stmt.setString(7, question.getDifficultyLevel());
            stmt.setInt(8, question.getId());

            stmt.executeUpdate();
            System.out.println("Quiz question updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating quiz question: " + e.getMessage());
        }
    }

    // Get a quiz question by ID
    public Question_model getQuizQuestionById(int id) {
        Question_model question = null;
        
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }

            String selectSQL = "SELECT * FROM quiz_questions WHERE question_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(selectSQL)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        question = new Question_model(
                                rs.getInt("question_id"),
                                rs.getString("question_text"),
                                rs.getString("option_a"),
                                rs.getString("option_b"),
                                rs.getString("option_c"),
                                rs.getString("option_d"),
                                rs.getString("correct_answer"),
                                rs.getString("difficulty_level")
                        );
                    } else {
                        System.out.println("No question found with ID: " + id);
                    }
                }
            }
         catch (SQLException e) {
            System.err.println("Error retrieving quiz question: " + e.getMessage());
        }

        return question;
    }

    
    public List<Question_model> getQuizQuestionByDifficultyLevel(String difficultyLevel) {
        List<Question_model> questions = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
            if (connection == null) {
                return questions; 
            }

            String selectSQL = "SELECT * FROM quiz_questions WHERE difficulty_level = ?";
            try (PreparedStatement stmt = connection.prepareStatement(selectSQL)) {
                stmt.setString(1, difficultyLevel);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Question_model question = new Question_model(
                                rs.getInt("question_id"),
                                rs.getString("question_text"),
                                rs.getString("option_a"),
                                rs.getString("option_b"),
                                rs.getString("option_c"),
                                rs.getString("option_d"),
                                rs.getString("correct_answer"),
                                rs.getString("difficulty_level")
                        );
                        questions.add(question);
                    }
                }
            }
         catch (SQLException e) {
            System.err.println("Error retrieving quiz questions: " + e.getMessage());
        }

        return questions;
    }


    // Get all quiz questions
    public List<Question_model> getAllQuizQuestions() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }

        List<Question_model> questionList = new ArrayList<>();

        String selectSQL = "SELECT * FROM quiz_questions";
        try (PreparedStatement stmt = connection.prepareStatement(selectSQL)) {
            try (ResultSet rs = stmt.executeQuery();) {
            	while (rs.next()) {
                Question_model question = new Question_model(
                        rs.getInt("question_id"),
                        rs.getString("question_text"),
                        rs.getString("option_a"),
                        rs.getString("option_b"),
                        rs.getString("option_c"),
                        rs.getString("option_d"),
                        rs.getString("correct_answer"),
                        rs.getString("difficulty_level")
                );
                questionList.add(question);
            	}
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving quiz questions: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }

        return questionList;
    }

    // Delete a quiz question by ID
    public void deleteQuizQuestion(int id) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return;
        }

        String deleteSQL = "DELETE FROM quiz_questions WHERE question_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteSQL)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Quiz question deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting quiz question: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
}
