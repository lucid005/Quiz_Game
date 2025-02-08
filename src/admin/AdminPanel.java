package admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.CardLayout;

import database.QuestionDAO;
import model.Question_model;

public class AdminPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
    private DefaultTableModel tableModel;
    private JPanel MainContent_Panel;
    
    private JTextField Question_Textfield;
    private JTextField OptionA_TextField;
    private JTextField OptionB_TextField;
    private JTextField OptionC_TextField;
    private JTextField OptionD_TextField;
    private JRadioButton rdbtnA, rdbtnB, rdbtnC, rdbtnD;
    private ButtonGroup answerGroup;
    private JComboBox<String> difficultyComboBox;

    private JPanel UpdateQuestion_Panel;
    private JTextField updateQuestionTextField;
    private JTextField updateOptionA_TextField;
	private JTextField updateOptionB_TextField;
	private JTextField updateOptionC_TextField;
	private JTextField updateOptionD_TextField;
	private JRadioButton updateRdbtnA, updateRdbtnB, updateRdbtnC, updateRdbtnD;
	private ButtonGroup updateAnswerGroup;
	private JComboBox<String> updateDifficultyComboBox;
    
//    private JTextField ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		getContentPane().setLayout(null);
		
		JPanel Sidebar = new JPanel();
		Sidebar.setBackground(new Color(246, 245, 244));
		Sidebar.setBounds(0, 0, 170, 610);
		getContentPane().add(Sidebar);
		Sidebar.setLayout(null);
		
			JLabel lblAdminPanel = new JLabel("ADMIN PANEL");
			lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdminPanel.setBounds(0, 39, 170, 17);
			lblAdminPanel.setFont(new Font("Ubuntu", Font.BOLD, 16));
			Sidebar.add(lblAdminPanel);
        
        MainContent_Panel = new JPanel();
        MainContent_Panel.setBackground(new Color(255, 255, 255));
        MainContent_Panel.setBounds(170, 0, 830, 610);
        getContentPane().add(MainContent_Panel);
                MainContent_Panel.setLayout(new CardLayout(0, 0));
                
                JPanel AllQuestions_Panel = new JPanel();
                AllQuestions_Panel.setBackground(new Color(255, 255, 255));
                MainContent_Panel.add(AllQuestions_Panel, "name_9939285740461");
                AllQuestions_Panel.setLayout(null);
                
                JLabel lblViewAllQuestions = new JLabel("View All Questions");
                lblViewAllQuestions.setBounds(12, 33, 214, 28);
                AllQuestions_Panel.add(lblViewAllQuestions);
                lblViewAllQuestions.setFont(new Font("Ubuntu", Font.BOLD, 24));
                
                tableModel = new DefaultTableModel(new Object[]{"ID", "Question", "Option A", "Option B", "Option C", "Option D", "Answer", "Difficulty Level"}, 0);
                table = new JTable(tableModel);
                table.setRowHeight(30);

                        JScrollPane DataTable = new JScrollPane(table);
                        DataTable.setBounds(12, 92, 740, 506);
                        AllQuestions_Panel.add(DataTable);
                        
        loadQuestions();
        
        JPanel AddQuestion_Panel = new JPanel();
        MainContent_Panel.add(AddQuestion_Panel, "name_9939296160870");
        AddQuestion_Panel.setBackground(new Color(255, 255, 255));
        AddQuestion_Panel.setLayout(null);
        
	        JLabel lblAddQuestion = new JLabel("Add Question");
	        lblAddQuestion.setFont(new Font("Ubuntu", Font.BOLD, 24));
	        lblAddQuestion.setHorizontalAlignment(SwingConstants.CENTER);
	        lblAddQuestion.setBounds(12, 34, 806, 30);
	        AddQuestion_Panel.add(lblAddQuestion);
	        
	        JLabel lblFillInAll = new JLabel("Fill in all the text fields");
	        lblFillInAll.setHorizontalAlignment(SwingConstants.CENTER);
	        lblFillInAll.setFont(new Font("Ubuntu", Font.BOLD, 12));
	        lblFillInAll.setBounds(12, 75, 806, 17);
	        AddQuestion_Panel.add(lblFillInAll);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(255, 255, 255));
	        panel.setBounds(12, 125, 806, 425);
	        AddQuestion_Panel.add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblQuestion = new JLabel("Question:");
	        lblQuestion.setFont(new Font("Ubuntu", Font.BOLD, 14));
	        lblQuestion.setBounds(12, 16, 74, 17);
	        panel.add(lblQuestion);
	        
	        Question_Textfield = new JTextField();
	        Question_Textfield.setFont(new Font("Ubuntu", Font.PLAIN, 12));
	        Question_Textfield.setBounds(88, 10, 706, 30);
	        panel.add(Question_Textfield);
	        Question_Textfield.setColumns(10);
	        
	        
	        JLabel lblQptionA = new JLabel("Option A:");
	        lblQptionA.setFont(new Font("Ubuntu", Font.BOLD, 14));
	        lblQptionA.setBounds(12, 63, 74, 17);
	        panel.add(lblQptionA);
	        
	        OptionA_TextField = new JTextField();
	        OptionA_TextField.setFont(new Font("Ubuntu", Font.PLAIN, 12));
	        OptionA_TextField.setBounds(88, 57, 706, 30);
	        panel.add(OptionA_TextField);
	        OptionA_TextField.setColumns(10);
	        
	        JLabel lblQptionB = new JLabel("Option B:");
	        lblQptionB.setFont(new Font("Ubuntu", Font.BOLD, 14));
	        lblQptionB.setBounds(12, 111, 74, 17);
	        panel.add(lblQptionB);
	        
	        OptionB_TextField = new JTextField();
	        OptionB_TextField .setFont(new Font("Ubuntu", Font.PLAIN, 12));
	        OptionB_TextField .setBounds(88, 105, 706, 30);
	        panel.add(OptionB_TextField );
	        OptionB_TextField .setColumns(10);
	        
	        JLabel lblQptionC = new JLabel("Option C:");
	        lblQptionC.setFont(new Font("Ubuntu", Font.BOLD, 14));
	        lblQptionC.setBounds(12, 157, 74, 17);
	        panel.add(lblQptionC);
	        
	        OptionC_TextField  = new JTextField();
	        OptionC_TextField .setFont(new Font("Ubuntu", Font.PLAIN, 12));
	        OptionC_TextField .setBounds(88, 151, 706, 30);
	        panel.add(OptionC_TextField );
	        OptionC_TextField .setColumns(10);
	        
	        
	        JLabel lblQptionD = new JLabel("Option D:");
	        lblQptionD.setFont(new Font("Ubuntu", Font.BOLD, 14));
	        lblQptionD.setBounds(12, 199, 74, 17);
	        panel.add(lblQptionD);
	        
	        OptionD_TextField  = new JTextField();
	        OptionD_TextField .setFont(new Font("Ubuntu", Font.PLAIN, 12));
	        OptionD_TextField .setBounds(88, 193, 706, 30);
	        panel.add(OptionD_TextField );
	        OptionD_TextField .setColumns(10);
	        
	        JLabel lblCorrectAnswer = new JLabel("Correct Answer:");
	        lblCorrectAnswer.setFont(new Font("Ubuntu", Font.BOLD, 14));
	        lblCorrectAnswer.setBounds(12, 241, 116, 17);
	        panel.add(lblCorrectAnswer);
	
	        rdbtnA = new JRadioButton("A");
	        rdbtnA.setBackground(new Color(255, 255, 255));
	        rdbtnA.setBounds(142, 238, 50, 20);
	        panel.add(rdbtnA);
	
	        rdbtnB = new JRadioButton("B");
	        rdbtnB.setBackground(new Color(255, 255, 255));
	        rdbtnB.setBounds(196, 238, 50, 20);
	        panel.add(rdbtnB);
	
	        rdbtnC = new JRadioButton("C");
	        rdbtnC.setBackground(new Color(255, 255, 255));
	        rdbtnC.setBounds(250, 238, 50, 20);
	        panel.add(rdbtnC);
	
	        rdbtnD = new JRadioButton("D");
	        rdbtnD.setBackground(new Color(255, 255, 255));
	        rdbtnD.setBounds(304, 238, 50, 20);
	        panel.add(rdbtnD);
	
	        answerGroup = new ButtonGroup();
	        answerGroup.add(rdbtnA);
	        answerGroup.add(rdbtnB);
	        answerGroup.add(rdbtnC);
	        answerGroup.add(rdbtnD);
	        
	        JLabel lblDifficultyLevel = new JLabel("Difficulty Level:");
	        lblDifficultyLevel.setFont(new Font("Ubuntu", Font.BOLD, 14));
	        lblDifficultyLevel.setBounds(12, 283, 110, 17);
	        panel.add(lblDifficultyLevel);
	
	        difficultyComboBox = new JComboBox<>();
	        difficultyComboBox.setMaximumRowCount(3);
	        difficultyComboBox.setFont(new Font("Ubuntu", Font.BOLD, 12));
	        difficultyComboBox.setBackground(new Color(255, 255, 255));
	        difficultyComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Beginner", "Intermediate", "Expert"}));
	        difficultyComboBox.setBounds(127, 276, 150, 30);
	        panel.add(difficultyComboBox);
	        
	        JButton btnAdd = new JButton("Add Question");
	        btnAdd.setBounds(290, 335, 123, 35);
	        panel.add(btnAdd);
	        btnAdd.setFont(new Font("Ubuntu", Font.BOLD, 12));
	        btnAdd.setForeground(new Color(255, 255, 255));
	        btnAdd.setBackground(new Color(26, 95, 180));
	        btnAdd.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		addQuestion();     			
	        	}
	        });
	        
	        JButton btnCancel = new JButton("Cancel");
	        btnCancel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		clearFields();
	        	}
	        });
	        btnCancel.setBounds(428, 335, 105, 35);
	        panel.add(btnCancel);
	        btnCancel.setFont(new Font("Ubuntu", Font.BOLD, 12));
	        btnCancel.setBackground(new Color(255, 255, 255));
        
	   	JButton AddButton = new JButton("+ Add");
	   	AllQuestions_Panel.add(AddButton);
	   	AddButton.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	   			MainContent_Panel.removeAll();
	   			MainContent_Panel.add(AddQuestion_Panel);
	   			MainContent_Panel.repaint();
	   			MainContent_Panel.revalidate();
	   		}
	   	});
	   	AddButton.setBounds(718, 29, 100, 32);
	   	AddButton.setFont(new Font("Ubuntu", Font.BOLD, 12));
	   	AddButton.setForeground(new Color(255, 255, 255));
	   	AddButton.setBackground(new Color(26, 95, 180));
	        
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setBackground(new Color(255, 255, 255));
	    buttonPanel.setBounds(753, 92, 77, 506);
	    AllQuestions_Panel.add(buttonPanel);
	    
	    ImageIcon originalEditIcon = new ImageIcon(AdminPanel.class.getResource("/resources/edit.png"));
	    Image originalEditImage = originalEditIcon.getImage();
	    Image resizedEditImage = originalEditImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	    ImageIcon resizedEditIcon = new ImageIcon(resizedEditImage);
	        
	    JButton updateBtn = new JButton("");
	    updateBtn.setBackground(new Color(255, 255, 255));
	    updateBtn.setIcon(resizedEditIcon);
	        
	    ImageIcon originalDeleteIcon = new ImageIcon(AdminPanel.class.getResource("/resources/delete.png"));
	    Image originalDeleteImage = originalDeleteIcon.getImage();
	    Image resizedDeleteImage = originalDeleteImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
	    ImageIcon resizedDeleteIcon = new ImageIcon(resizedDeleteImage);
	        
	    JButton deleteBtn = new JButton("");
	    deleteBtn.setBackground(new Color(255, 255, 255));
	    deleteBtn.setIcon(resizedDeleteIcon);
	        
	    updateBtn.addActionListener(e -> updateSelectedQuestion());
	    deleteBtn.addActionListener(e -> deleteSelectedQuestion());
	        
	    buttonPanel.add(updateBtn);
	    buttonPanel.add(deleteBtn);
	        
	    UpdateQuestion_Panel = new JPanel();
	    UpdateQuestion_Panel.setBackground(new Color(255, 255, 255));
	    MainContent_Panel.add(UpdateQuestion_Panel, "name_14248032531233");
	    UpdateQuestion_Panel.setLayout(null);

		    JLabel lblUpdateQuestion = new JLabel("Update Question");
		    lblUpdateQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		    lblUpdateQuestion.setFont(new Font("Ubuntu", Font.BOLD, 24));
		    lblUpdateQuestion.setBounds(10, 35, 806, 30);
		    UpdateQuestion_Panel.add(lblUpdateQuestion);
	
		    JLabel lblFillInAll_1 = new JLabel("Fill in all the text fields");
		    lblFillInAll_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblFillInAll_1.setFont(new Font("Ubuntu", Font.BOLD, 12));
		    lblFillInAll_1.setBounds(10, 75, 806, 17);
		    UpdateQuestion_Panel.add(lblFillInAll_1);
	
		    JPanel panel_1 = new JPanel();
		    panel_1.setLayout(null);
		    panel_1.setBackground(Color.WHITE);
		    panel_1.setBounds(12, 125, 806, 425);
		    UpdateQuestion_Panel.add(panel_1);
	
		    JLabel lblQuestion_1 = new JLabel("Question:");
		    lblQuestion_1.setFont(new Font("Ubuntu", Font.BOLD, 14));
		    lblQuestion_1.setBounds(12, 16, 74, 17);
		    panel_1.add(lblQuestion_1);
	
		    updateQuestionTextField = new JTextField();
		    updateQuestionTextField.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		    updateQuestionTextField.setColumns(10);
		    updateQuestionTextField.setBounds(88, 10, 706, 30);
		    panel_1.add(updateQuestionTextField);
	
		    JLabel lblQptionA_1 = new JLabel("Option A:");
		    lblQptionA_1.setFont(new Font("Ubuntu", Font.BOLD, 14));
		    lblQptionA_1.setBounds(12, 63, 74, 17);
		    panel_1.add(lblQptionA_1);
	
		    updateOptionA_TextField = new JTextField();
		    updateOptionA_TextField.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		    updateOptionA_TextField.setColumns(10);
		    updateOptionA_TextField.setBounds(88, 57, 706, 30);
		    panel_1.add(updateOptionA_TextField);
	
		    JLabel lblQptionB_1 = new JLabel("Option B:");
		    lblQptionB_1.setFont(new Font("Ubuntu", Font.BOLD, 14));
		    lblQptionB_1.setBounds(12, 111, 74, 17);
		    panel_1.add(lblQptionB_1);
	
		    updateOptionB_TextField = new JTextField();
		    updateOptionB_TextField.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		    updateOptionB_TextField.setColumns(10);
		    updateOptionB_TextField.setBounds(88, 105, 706, 30);
		    panel_1.add(updateOptionB_TextField);
	
		    JLabel lblQptionC_1 = new JLabel("Option C:");
		    lblQptionC_1.setFont(new Font("Ubuntu", Font.BOLD, 14));
		    lblQptionC_1.setBounds(12, 157, 74, 17);
		    panel_1.add(lblQptionC_1);
	
		    updateOptionC_TextField = new JTextField();
		    updateOptionC_TextField.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		    updateOptionC_TextField.setColumns(10);
		    updateOptionC_TextField.setBounds(88, 151, 706, 30);
		    panel_1.add(updateOptionC_TextField);
	
		    JLabel lblQptionD_1 = new JLabel("Option D:");
		    lblQptionD_1.setFont(new Font("Ubuntu", Font.BOLD, 14));
		    lblQptionD_1.setBounds(12, 199, 74, 17);
		    panel_1.add(lblQptionD_1);
	
		    updateOptionD_TextField = new JTextField();
		    updateOptionD_TextField.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		    updateOptionD_TextField.setColumns(10);
		    updateOptionD_TextField.setBounds(88, 193, 706, 30);
		    panel_1.add(updateOptionD_TextField);
	
		    JLabel lblCorrectAnswer_1 = new JLabel("Correct Answer:");
		    lblCorrectAnswer_1.setFont(new Font("Ubuntu", Font.BOLD, 14));
		    lblCorrectAnswer_1.setBounds(12, 241, 116, 17);
		    panel_1.add(lblCorrectAnswer_1);
	
		    updateRdbtnA = new JRadioButton("A");
		    updateRdbtnA.setBackground(Color.WHITE);
		    updateRdbtnA.setBounds(142, 238, 50, 20);
		    panel_1.add(updateRdbtnA);
	
		    updateRdbtnB = new JRadioButton("B");
		    updateRdbtnB.setBackground(Color.WHITE);
		    updateRdbtnB.setBounds(196, 238, 50, 20);
		    panel_1.add(updateRdbtnB);
	
		    updateRdbtnC = new JRadioButton("C");
		    updateRdbtnC.setBackground(Color.WHITE);
		    updateRdbtnC.setBounds(250, 238, 50, 20);
		    panel_1.add(updateRdbtnC);
	
		    updateRdbtnD = new JRadioButton("D");
		    updateRdbtnD.setBackground(Color.WHITE);
		    updateRdbtnD.setBounds(304, 238, 50, 20);
		    panel_1.add(updateRdbtnD);
	
		    updateAnswerGroup = new ButtonGroup();
		    updateAnswerGroup.add(updateRdbtnA);
		    updateAnswerGroup.add(updateRdbtnB);
		    updateAnswerGroup.add(updateRdbtnC);
		    updateAnswerGroup.add(updateRdbtnD);
	
		    JLabel lblDifficultyLevel_1 = new JLabel("Difficulty Level:");
		    lblDifficultyLevel_1.setFont(new Font("Ubuntu", Font.BOLD, 14));
		    lblDifficultyLevel_1.setBounds(12, 283, 110, 17);
		    panel_1.add(lblDifficultyLevel_1);
	
		    updateDifficultyComboBox = new JComboBox<>();
		    updateDifficultyComboBox.setMaximumRowCount(3);
		    updateDifficultyComboBox.setFont(new Font("Ubuntu", Font.BOLD, 12));
		    updateDifficultyComboBox.setBackground(Color.WHITE);
		    updateDifficultyComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Beginner", "Intermediate", "Expert"}));
		    updateDifficultyComboBox.setBounds(127, 276, 150, 30);
		    panel_1.add(updateDifficultyComboBox);
	
		    JButton btnUpdate = new JButton("Update Question");
		    btnUpdate.setForeground(Color.WHITE);
		    btnUpdate.setFont(new Font("Ubuntu", Font.BOLD, 12));
		    btnUpdate.setBackground(new Color(26, 95, 180));
		    btnUpdate.setBounds(281, 335, 132, 35);
		    panel_1.add(btnUpdate);
	
		    JButton btnCancel_1 = new JButton("Cancel");
		    btnCancel_1.setForeground(new Color(0, 0, 0));
		    btnCancel_1.setFont(new Font("Ubuntu", Font.BOLD, 12));
		    btnCancel_1.setBackground(new Color(255, 255, 255));
		    btnCancel_1.setBounds(428, 335, 105, 35);
		    panel_1.add(btnCancel_1);
		    
		    btnCancel_1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            MainContent_Panel.removeAll();
		            MainContent_Panel.add(AllQuestions_Panel);
		            MainContent_Panel.repaint();
		            MainContent_Panel.revalidate();
		        }
		    });
		    
		    btnUpdate.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            int selectedRow = table.getSelectedRow();
		            if (selectedRow == -1) {
		                JOptionPane.showMessageDialog(null, "Please select a question to update.", "Update Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            int questionId = (int) tableModel.getValueAt(selectedRow, 0);
		            String questionText = updateQuestionTextField.getText();
		            String optionA = updateOptionA_TextField.getText();
		            String optionB = updateOptionB_TextField.getText();
		            String optionC = updateOptionC_TextField.getText();
		            String optionD = updateOptionD_TextField.getText();
		            String correctAnswer = "";

		            if (updateRdbtnA.isSelected()) {
		                correctAnswer = "A";
		            } else if (updateRdbtnB.isSelected()) {
		                correctAnswer = "B";
		            } else if (updateRdbtnC.isSelected()) {
		                correctAnswer = "C";
		            } else if (updateRdbtnD.isSelected()) {
		                correctAnswer = "D";
		            }

		            String difficultyLevel = (String) updateDifficultyComboBox.getSelectedItem();

		            Question_model updatedQuestion = new Question_model(questionId, questionText, optionA, optionB, optionC, optionD, correctAnswer, difficultyLevel);

		            QuestionDAO questionDAO = new QuestionDAO();
		            questionDAO.updateQuizQuestion(updatedQuestion);

		            loadQuestions();

		            MainContent_Panel.removeAll();
		            MainContent_Panel.add(AllQuestions_Panel);
		            MainContent_Panel.repaint();
		            MainContent_Panel.revalidate();
		        }
		    });
	        
	        
	        
	    JButton btnAllData = new JButton("All Data");
	    Sidebar.add(btnAllData);
	    btnAllData.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		MainContent_Panel.removeAll();
	    		MainContent_Panel.add(AllQuestions_Panel);
	    		MainContent_Panel.repaint();
	    		MainContent_Panel.revalidate();
	    	}
	    });
		btnAllData.setBounds(0, 93, 170, 43);
		btnAllData.setFont(new Font("Ubuntu", Font.BOLD, 12));
		btnAllData.setForeground(new Color(255, 255, 255));
		btnAllData.setBackground(new Color(26, 95, 180));	
	}
	
	private void clearFields() {
	    Question_Textfield.setText("");
	    OptionA_TextField.setText("");
	    OptionB_TextField.setText("");
	    OptionC_TextField.setText("");
	    OptionD_TextField.setText("");
	    answerGroup.clearSelection();
	    difficultyComboBox.setSelectedIndex(0);
	}

	
	private void loadQuestions() {
	    tableModel.setRowCount(0);
	    QuestionDAO questionDAO = new QuestionDAO();
	    List<Question_model> questions = questionDAO.getAllQuizQuestions();
	    
	    if (questions != null) {
	        for (int i = 0; i < questions.size(); i++) {
	        	Question_model question = questions.get(i);
	            tableModel.addRow(new Object[]{
	            	i + 1 ,
	                question.getQuestionText(),
	                question.getOptionA(),
	                question.getOptionB(),
	                question.getOptionC(),
	                question.getOptionD(),
	                question.getCorrectAnswer(),
	                question.getDifficultyLevel()
	            });
	        }
	    }
	}
	
    private void addQuestion() {
    	if (Question_Textfield.getText().isEmpty() || OptionA_TextField.getText().isEmpty() || OptionB_TextField.getText().isEmpty() || 
    			OptionC_TextField.getText().isEmpty() || OptionD_TextField.getText().isEmpty() || answerGroup.getSelection() == null) {
    		
    		JOptionPane.showMessageDialog(null, "Please fill in all fields before adding a question." , "Input Error", JOptionPane.ERROR_MESSAGE);
    		return;
    	} else {
    		JOptionPane.showMessageDialog(null, "Question Added!!");
    	}
    	
    	String questionText = Question_Textfield.getText();
    	String optionA = OptionA_TextField.getText();
    	String optionB = OptionB_TextField.getText();
    	String optionC = OptionC_TextField.getText();
    	String optionD = OptionD_TextField.getText();
    	String correctAnswer = "";
    	
    	if (rdbtnA.isSelected()) {
    		correctAnswer = "A";
    	} else if (rdbtnB.isSelected()) {
    		correctAnswer = "B";
    	} else if (rdbtnC.isSelected()) {
    		correctAnswer = "C";
    	} else if (rdbtnD.isSelected()) {
    		correctAnswer = "D";
    	}
    	
    	String difficultyLevel = (String) difficultyComboBox.getSelectedItem();
    	
    	Question_model newQuestion = new Question_model(0, questionText, optionA, optionB, optionC, optionD, correctAnswer, difficultyLevel);
    	
    	QuestionDAO questionDAO = new QuestionDAO();
    	questionDAO.addQuestion(newQuestion);
    	
    	loadQuestions();
    	
    	clearFields();
    }


    private void updateSelectedQuestion() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a question to update.", "Update Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int questionId = (int) tableModel.getValueAt(selectedRow, 0);
        QuestionDAO questionDAO = new QuestionDAO();
        Question_model question = questionDAO.getQuizQuestionById(questionId);

        if (question != null) {
        	updateQuestionTextField.setText(question.getQuestionText());
            updateOptionA_TextField.setText(question.getOptionA());
            updateOptionB_TextField.setText(question.getOptionB());
            updateOptionC_TextField.setText(question.getOptionC());
            updateOptionD_TextField.setText(question.getOptionD());

            switch (question.getCorrectAnswer()) {
                case "A":
                    updateRdbtnA.setSelected(true);
                    break;
                case "B":
                    updateRdbtnB.setSelected(true);
                    break;
                case "C":
                    updateRdbtnC.setSelected(true);
                    break;
                case "D":
                    updateRdbtnD.setSelected(true);
                    break;
            }

            updateDifficultyComboBox.setSelectedItem(question.getDifficultyLevel());

            MainContent_Panel.removeAll();
            MainContent_Panel.add(UpdateQuestion_Panel);
            MainContent_Panel.repaint();
            MainContent_Panel.revalidate();
        } else {
            JOptionPane.showMessageDialog(null, "Error: Question not found.", "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	private void deleteSelectedQuestion() {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Please select a question to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    int questionId = (int) tableModel.getValueAt(selectedRow, 0);
	    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this question?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
	    if (confirm == JOptionPane.YES_OPTION) {
	        QuestionDAO questionDAO = new QuestionDAO();
	        questionDAO.deleteQuizQuestion(questionId);
	        loadQuestions();
	    }
	}
}