import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CustomLevelCreator extends JFrame {
    private ArrayList<CustomLevelData> customLevels = new ArrayList<>();
    
    private JTextField questionField, option1Field, option2Field, option3Field, option4Field, correctAnswerField, hintField, imagePathField, funFactField;
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
        
        funFactField = new JTextField("Fun fact");
        add(funFactField);
    }

    private void addAction(ActionEvent e) {
        String[] options = {option1Field.getText(), option2Field.getText(), option3Field.getText(), option4Field.getText()};
        String correctAnswer = correctAnswerField.getText();
        String hint = hintField.getText();
        String imagePath = imagePathField.getText();
        String funFact = funFactField.getText();

        CustomLevelData customLevelData = new CustomLevelData(questionField.getText(), correctAnswer, hint, imagePath);
        customLevels.add(customLevelData);

        clearFields();
    }

    private void clearFields() {
        questionField.setText("");
        option1Field.setText("");
        option2Field.setText("");
        option3Field.setText("");
        option4Field.setText("");
        correctAnswerField.setText("");
        hintField.setText("");
        imagePathField.setText("");
        funFactField.setText("");
    }

    private void saveAction(ActionEvent e) {
        if (!customLevels.isEmpty()) {
            CustomLevelSaver.saveCustomLevels(playerData.getPlayerUsername(), customLevels);
            JOptionPane.showMessageDialog(this, "Level saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the window after saving
        } else {
            JOptionPane.showMessageDialog(this, "No questions added. Please add questions before saving.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Assume playerData is retrieved or created elsewhere
        GameData playerData = new GameData(); // Example, replace with actual player data retrieval
        new CustomLevelCreator(playerData);
    }
}
