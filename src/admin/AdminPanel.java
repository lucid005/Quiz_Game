package admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
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
    private JTextField Question_Textfield;
    private JTextField OptionA_TextField;
    private JTextField OptionB_TextField;
    private JTextField OptionC_TextField;
    private JTextField OptionD_TextField;
    private JRadioButton rdbtnA, rdbtnB, rdbtnC, rdbtnD;
    private ButtonGroup answerGroup;

    private JComboBox<String> difficultyComboBox;
    
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
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		JPanel Sidebar = new JPanel();
		Sidebar.setBackground(new Color(246, 245, 244));
		Sidebar.setBounds(0, 0, 150, 560);
		getContentPane().add(Sidebar);
		Sidebar.setLayout(null);
		
			JLabel lblAdminPanel = new JLabel("ADMIN PANEL");
			lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdminPanel.setBounds(0, 39, 150, 17);
			lblAdminPanel.setFont(new Font("Ubuntu", Font.BOLD, 16));
			Sidebar.add(lblAdminPanel);
        
        JPanel MainContent_Panel = new JPanel();
        MainContent_Panel.setBackground(new Color(255, 255, 255));
        MainContent_Panel.setBounds(151, 0, 649, 560);
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
                        DataTable.setBounds(12, 92, 625, 459);
                        AllQuestions_Panel.add(DataTable);
                        
        loadQuestions();
        
        JPanel AddQuestion_Panel = new JPanel();
        MainContent_Panel.add(AddQuestion_Panel, "name_9939296160870");
        AddQuestion_Panel.setBackground(new Color(255, 255, 255));
        AddQuestion_Panel.setLayout(null);
        
        JLabel lblAddQuestion = new JLabel("Add Question");
        lblAddQuestion.setFont(new Font("Ubuntu", Font.BOLD, 24));
        lblAddQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddQuestion.setBounds(12, 34, 625, 30);
        AddQuestion_Panel.add(lblAddQuestion);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(64, 94, 523, 425);
        AddQuestion_Panel.add(panel);
        panel.setLayout(null);
        
        JLabel lblQuestion = new JLabel("Question:");
        lblQuestion.setFont(new Font("Ubuntu", Font.BOLD, 14));
        lblQuestion.setBounds(12, 16, 74, 17);
        panel.add(lblQuestion);
        
        Question_Textfield = new JTextField();
        Question_Textfield.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        Question_Textfield.setBounds(88, 10, 423, 30);
        panel.add(Question_Textfield);
        Question_Textfield.setColumns(10);
        
        
        JLabel lblQptionA = new JLabel("Option A:");
        lblQptionA.setFont(new Font("Ubuntu", Font.BOLD, 14));
        lblQptionA.setBounds(12, 63, 74, 17);
        panel.add(lblQptionA);
        
        OptionA_TextField = new JTextField();
        OptionA_TextField.setFont(new Font("Ubuntu", Font.PLAIN, 12));
        OptionA_TextField.setBounds(88, 57, 423, 30);
        panel.add(OptionA_TextField);
        OptionA_TextField.setColumns(10);
        
        JLabel lblQptionB = new JLabel("Option B:");
        lblQptionB.setFont(new Font("Ubuntu", Font.BOLD, 14));
        lblQptionB.setBounds(12, 111, 74, 17);
        panel.add(lblQptionB);
        
        OptionB_TextField = new JTextField();
        OptionB_TextField .setFont(new Font("Ubuntu", Font.PLAIN, 12));
        OptionB_TextField .setBounds(88, 105, 423, 30);
        panel.add(OptionB_TextField );
        OptionB_TextField .setColumns(10);
        
        JLabel lblQptionC = new JLabel("Option C:");
        lblQptionC.setFont(new Font("Ubuntu", Font.BOLD, 14));
        lblQptionC.setBounds(12, 157, 74, 17);
        panel.add(lblQptionC);
        
        OptionC_TextField  = new JTextField();
        OptionC_TextField .setFont(new Font("Ubuntu", Font.PLAIN, 12));
        OptionC_TextField .setBounds(88, 151, 423, 30);
        panel.add(OptionC_TextField );
        OptionC_TextField .setColumns(10);
        
        
        JLabel lblQptionD = new JLabel("Option D:");
        lblQptionD.setFont(new Font("Ubuntu", Font.BOLD, 14));
        lblQptionD.setBounds(12, 199, 74, 17);
        panel.add(lblQptionD);
        
        OptionD_TextField  = new JTextField();
        OptionD_TextField .setFont(new Font("Ubuntu", Font.PLAIN, 12));
        OptionD_TextField .setBounds(88, 193, 423, 30);
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

        // Group the radio buttons to allow only one selection at a time
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
        difficultyComboBox.setBounds(127, 276, 110, 30);
        panel.add(difficultyComboBox);
        
        JButton btnAdd = new JButton("Add Question");
        btnAdd.setBounds(137, 333, 123, 35);
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
        btnCancel.setBounds(275, 333, 105, 35);
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
	        AddButton.setBounds(537, 29, 100, 32);
	        AddButton.setFont(new Font("Ubuntu", Font.BOLD, 12));
	        AddButton.setForeground(new Color(255, 255, 255));
	        AddButton.setBackground(new Color(26, 95, 180));
	        
	        
	        
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
			btnAllData.setBounds(0, 93, 150, 43);
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
	        for (Question_model question : questions) {
	            tableModel.addRow(new Object[]{
	                question.getId(),
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

}