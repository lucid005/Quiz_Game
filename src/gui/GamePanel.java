package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import components.CustomButton;
import database.QuestionDAO;
import model.Question_model;
import model.User_model;
import user.Registration;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout;
    private JPanel parentPanel;
    private User_model user;
    private List<Question_model> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private JLabel questionLabel;
    private CustomButton option1;
    private CustomButton option2;
    private CustomButton option3;
    private CustomButton option4;
    public GamePanel(CardLayout cardLayout, JPanel parentPanel, User_model user, String difficultyLevel) {
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        this.user = user;
        setBackground(new Color(255, 255, 255));
        setLayout(new GridBagLayout());
        
        score = 0; 

        // Load questions based on the player's chosen difficulty level
        QuestionDAO questionDAO = new QuestionDAO();
        questions = questionDAO.getQuizQuestionByDifficultyLevel(difficultyLevel);
        Collections.shuffle(questions); // Shuffle the questions for randomness

        // Initialize UI components (same as before)
        questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        GridBagConstraints gbcQuestionLabel = new GridBagConstraints();
        gbcQuestionLabel.gridwidth = 3;
        gbcQuestionLabel.insets = new Insets(0, 0, 20, 0);
        gbcQuestionLabel.gridx = 0;
        gbcQuestionLabel.gridy = 0;
        add(questionLabel, gbcQuestionLabel);

        option1 = new CustomButton("");
        option1.setPreferredSize(new Dimension(280, 70));
        GridBagConstraints gbcOption1 = new GridBagConstraints();
        gbcOption1.insets = new Insets(0, 0, 10, 10);
        gbcOption1.gridx = 0;
        gbcOption1.gridy = 1;
        add(option1, gbcOption1);

        option2 = new CustomButton("");
        option2.setPreferredSize(new Dimension(280, 70));
        GridBagConstraints gbcOption2 = new GridBagConstraints();
        gbcOption2.insets = new Insets(0, 0, 10, 0);
        gbcOption2.gridx = 2;
        gbcOption2.gridy = 1;
        add(option2, gbcOption2);

        option3 = new CustomButton("");
        option3.setPreferredSize(new Dimension(280, 70));
        GridBagConstraints gbcOption3 = new GridBagConstraints();
        gbcOption3.insets = new Insets(0, 0, 10, 10);
        gbcOption3.gridx = 0;
        gbcOption3.gridy = 2;
        add(option3, gbcOption3);

        option4 = new CustomButton("");
        option4.setPreferredSize(new Dimension(280, 70));
        GridBagConstraints gbcOption4 = new GridBagConstraints();
        gbcOption4.insets = new Insets(0, 0, 20, 0);
        gbcOption4.gridx = 2;
        gbcOption4.gridy = 2;
        add(option4, gbcOption4);

        // Display the first question
        displayQuestion();

        // Add action listeners to the option buttons
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(option1.getText());
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(option2.getText());
            }
        });

        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(option3.getText());
            }
        });

        option4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(option4.getText());
            }
        });
    }


    private void displayQuestion() {
        if (currentQuestionIndex >= 10 || currentQuestionIndex >= questions.size()) {
            // End of game, save scores and show results
            saveScores();
            
         // Show the ScorePanel instead of JOptionPane
            ScorePanel scorePanel = new ScorePanel(score, questions.size(), cardLayout, parentPanel);
            parentPanel.add(scorePanel, "ScorePanel");
            cardLayout.show(parentPanel, "ScorePanel");
            return;
        }

        Question_model currentQuestion = questions.get(currentQuestionIndex);

        // Display the question
        questionLabel.setText(currentQuestion.getQuestionText());

        // Display the options
        option1.setText(currentQuestion.getOptionA());
        option2.setText(currentQuestion.getOptionB());
        option3.setText(currentQuestion.getOptionC());
        option4.setText(currentQuestion.getOptionD());
        
     // Re-enable buttons when a new question is displayed
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
    }

    private void checkAnswer(String selectedOption) {
    	 Question_model currentQuestion = questions.get(currentQuestionIndex);
    	    
    	 System.out.println("Selected answer: " + selectedOption);
    	 System.out.println("Correct answer: " + currentQuestion.getCorrectAnswer());
    	 // Check if the selected answer is correct and update score
    	 if (selectedOption.equals(currentQuestion.getCorrectAnswer())) {
    	     score++;
    	     System.out.println("Correct! Score: " + score); 
    	 }
    	 // Disable all option buttons to prevent multiple answers
    	 option1.setEnabled(false);
    	 option2.setEnabled(false);
    	 option3.setEnabled(false);
    	 option4.setEnabled(false);

    	 Timer timer = new Timer(1000, new ActionListener() {
    	     public void actionPerformed(ActionEvent e) {
    	         currentQuestionIndex++;
    	         displayQuestion(); 
    	     }
    	 });
    	 timer.setRepeats(false);  
    	 timer.start();
    }

    private void saveScores() {
        // Update the player's scores in the database
    	System.out.println("Saving score: " + score);
        user.setScore1(score);
        Registration register = new Registration();
        register.updatePlayerScores(user);
    }
    
    public void resetButtons() {
        // Re-enable option buttons to allow user interaction
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);

        score = 0;
        currentQuestionIndex = 0;

        // Display the first question again
        displayQuestion();
    }
}