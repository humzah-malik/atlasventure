import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CustomLevelCreator extends JFrame {
    private ArrayList<CustomLevelData> customLevels = new ArrayList<>();
    
    private JTextField questionField, option1Field, option2Field, option3Field, option4Field, correctAnswerField, hintField, imagePathField;
    private JTextArea funFactField;
    private JButton addButton, saveButton;
    private GameData playerData;

    public CustomLevelCreator(GameData playerData) {
        this.playerData = playerData;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Create Custom Level");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 1));
        setLocationRelativeTo(null);
        
        addFields();
        addButton = new JButton("Add Question");
        addButton.addActionListener(this::addAction);
        add(addButton);
        
        saveButton = new JButton("Save Level");
        saveButton.addActionListener(this::saveAction);
        add(saveButton);
        
        pack();
        setVisible(true);
    }

    private void addFields() {
        questionField = new JTextField("Enter question here");
        add(questionField);
        
        option1Field = new JTextField("Option 1");
        add(option1Field);
        option2Field = new JTextField("Option 2");
        add(option2Field);
        option3Field = new JTextField("Option 3");
        add(option3Field);
        option4Field = new JTextField("Option 4");
        add(option4Field);
        
        correctAnswerField = new JTextField("Correct Answer");
        add(correctAnswerField);
        
        hintField = new JTextField("Hint for question");
        add(hintField);
        
        imagePathField = new JTextField("Path to image");
        add(imagePathField);
        
        funFactField = new JTextArea("Fun fact");
        funFactField.setLineWrap(true);
        funFactField.setWrapStyleWord(true);
        JScrollPane funFactScrollPane = new JScrollPane(funFactField);
        add(funFactScrollPane);
    }

    private void addAction(ActionEvent e) {
        String[] options = {option1Field.getText(), option2Field.getText(), option3Field.getText(), option4Field.getText()};
        String correctAnswer = correctAnswerField.getText();
        String hint = hintField.getText();
        String imagePath = imagePathField.getText();
        String[] funFacts = funFactField.getText().split("\n"); // Assuming fun facts are separated by newlines

        CustomLevelData customLevelData = new CustomLevelData();
        customLevelData.addQuestion(questionField.getText(), options, correctAnswer, hint, imagePath, funFacts);
        customLevels.add(customLevelData);

        clearFields();
    }

    private void clearFields() {
        questionField.setText("");
        option1Field.setText("Option 1");
        option2Field.setText("Option 2");
        option3Field.setText("Option 3");
        option4Field.setText("Option 4");
        correctAnswerField.setText("");
        hintField.setText("");
        imagePathField.setText("");
        funFactField.setText("");
    }

    private void saveAction(ActionEvent e) {
        if (!customLevels.isEmpty()) {
            // Assuming saveCustomLevels method now accepts ArrayList<CustomLevelData>
            CustomLevelSaver.saveCustomLevels(playerData.getPlayerUsername(), customLevels);
            JOptionPane.showMessageDialog(this, "Level saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the window after saving
        } else {
            JOptionPane.showMessageDialog(this, "No questions added. Please add questions before saving.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
