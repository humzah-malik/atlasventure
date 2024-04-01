import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CustomLevelViewer extends JPanel {
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 650;
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardsPanel;
    private int currentQuestionIndex = 0;
    private JLabel pointsLabel;
    private int totalPoints = 0;
    private CustomLevelData customLevelData; // Assuming this is correctly defined elsewhere
    private GameManager gameManager;

    public CustomLevelViewer(GameManager gameManager, GameData playerData) {
        this.gameManager = gameManager;
        // Load custom level data for the player
        this.customLevelData = (CustomLevelData) CustomLevelLoader.loadCustomLevel(playerData.getPlayerUsername());

        if (this.customLevelData == null || this.customLevelData.getQuestions().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No custom level found. Returning to main menu.");
            gameManager.changeGameState("MAIN_MENU");
            return;
        }

        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        cardsPanel = new JPanel(cardLayout);
        // Iterate over questions to create panels
        for (int i = 0; i < customLevelData.getQuestions().size(); i++) {
            JPanel questionPanel = createQuestionPanel(i);
            cardsPanel.add(questionPanel, "Question" + i);
        }
        add(cardsPanel, BorderLayout.CENTER);

        pointsLabel = new JLabel("Points: 0");
        add(pointsLabel, BorderLayout.NORTH);

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> gameManager.changeGameState("MAIN_MENU"));
        add(backButton, BorderLayout.SOUTH);

        cardLayout.show(cardsPanel, "Question0");
    }


    private JPanel createQuestionPanel(int questionIndex) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.gray);

        JLabel questionLabel = new JLabel(customLevelData.getQuestions().get(questionIndex), SwingConstants.CENTER);
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // Adjust the layout as needed
        String[] options = customLevelData.getOptions().get(questionIndex);
        String correctAnswer = customLevelData.getCorrectAnswers().get(questionIndex);
        for (String option : options) {
            JButton optionButton = new JButton(option);
            optionButton.addActionListener(e -> answerSelected(e.getActionCommand(), correctAnswer));
            optionsPanel.add(optionButton);
        }
        panel.add(optionsPanel, BorderLayout.CENTER);

        // Optional: Display image if exists
        if (!customLevelData.getImagePaths().get(questionIndex).isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(customLevelData.getImagePaths().get(questionIndex)).getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT));
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(imageLabel, BorderLayout.SOUTH);
        }

        return panel;
    }

    private void answerSelected(String selectedOption, String correctAnswer) {
        if (selectedOption.equals(correctAnswer)) {
            totalPoints += 10; // Adjust scoring as necessary
            pointsLabel.setText("Points: " + totalPoints);
            JOptionPane.showMessageDialog(this, "Correct!", "Correct Answer", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect.", "Incorrect Answer", JOptionPane.ERROR_MESSAGE);
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < customLevelData.getQuestions().size()) {
            cardLayout.show(cardsPanel, "Question" + currentQuestionIndex);
        } else {
            JOptionPane.showMessageDialog(this, "You've completed the custom level! Total Points: " + totalPoints, "Level Completed", JOptionPane.INFORMATION_MESSAGE);
            // Optionally, navigate back to the main menu or another screen
            gameManager.changeGameState("MAIN_MENU");
        }
    }
}
