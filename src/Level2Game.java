import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class Level2Game extends JPanel {
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 650;
    private int levelNumber;
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardsPanel;
    private boolean isAnswerCorrect = false;
    private int totalPoints = 0;
    private JLabel pointsLabel;
    private boolean[] questionAnsweredCorrectly;
    private ThemeLevelData currentLevelData;
    private int currentQuestionIndex = 0;
    private GameData playerData;
    private LevelSelectionScreen levelSelectionScreen;
    private GameManager gameManager;
    int hintsUsed;
    private ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen;

    String[] questionTitles = {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5"};

    public Level2Game(int levelNumber, GameData player, ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen, GameManager gameManager) {
        this.themeBasedModeSelectionScreen = themeBasedModeSelectionScreen;
        this.levelNumber = levelNumber;
        this.playerData = player;
        this.gameManager = gameManager;
        System.out.println(levelNumber);
        currentLevelData = new ThemeLevelData(levelNumber+1);
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        questionAnsweredCorrectly = new boolean[questionTitles.length];
        createCardsPanel();

        for (int i = 0; i < questionTitles.length; i++) {
            JPanel questionPanel = createQuestionPanel(questionTitles[i], currentLevelData.correctAnswers[i], currentLevelData.options[i], currentLevelData.hints[i], currentLevelData.imagePaths[i]);
            cardsPanel.add(questionPanel, "Question" + i);
        }

        add(cardsPanel, BorderLayout.CENTER);

        JPanel pointsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pointsPanel.setOpaque(false); // Set the panel to be transparent
    
        // Configure the points label
        pointsLabel = new JLabel("Points: " + totalPoints);
        pointsLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        pointsLabel.setForeground(Color.white);

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setOpaque(false); // Set the panel to be transparent
    
        // Configure the back button
        JButton backToMain = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
        backToMain.setPreferredSize(new Dimension(60, 60));
        backToMain.setBorderPainted(false);
        backToMain.setContentAreaFilled(false);
        backToMain.addActionListener(e -> {
            gameManager.switchToThemeBasedModeSelectionScreen(playerData);
            AudioManager.getInstance().playButtonClickSound();
            levelSelectionScreen.activate(); // Assuming you have a method to show the level selection screen
        });
    
        // Add the back button to the back button panel
        backButtonPanel.add(backToMain);
    
        // Add the points label to the points panel
        pointsPanel.add(pointsLabel);
    
        // Create a top panel to hold both the back button and points label
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false); // Set the panel to be transparent
        topPanel.add(backButtonPanel, BorderLayout.WEST);
        topPanel.add(pointsPanel, BorderLayout.CENTER);
    
        // Add the top panel to the NORTH region of the Level1Game panel
        add(topPanel, BorderLayout.NORTH);

        
        cardLayout.show(cardsPanel, "Question0");
    }

    private void createCardsPanel() {
        cardsPanel = new JPanel(cardLayout);
        cardsPanel.setOpaque(false); // Making the cards panel transparent
        for (int i = 0; i < questionTitles.length; i++) {
            JPanel questionPanel = createQuestionPanel(questionTitles[i], currentLevelData.correctAnswers[i], currentLevelData.options[i], currentLevelData.hints[i], currentLevelData.imagePaths[i]);
            cardsPanel.add(questionPanel, "Question" + i);
        }
        add(cardsPanel, BorderLayout.CENTER);
    }

    private JPanel createQuestionPanel(String questionTitle, String correctAnswer, String[] options, String hint, String imagePath) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
    
        // Title label setup
        JLabel titleLabel = new JLabel(questionTitle, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel, BorderLayout.NORTH);
    
        // Image setup
        JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource(imagePath)).getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH)));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);
    
        // Bottom panel setup for options and controls
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
    
        // Options panel setup
        JPanel optionsPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // Two rows, two columns for buttons
        optionsPanel.setOpaque(false);
        Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
    
        // Creating option buttons
        
        bottomPanel.add(optionsPanel, BorderLayout.CENTER);
    
        // Control panel setup for hint and next question buttons
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setOpaque(false);
    
        JButton hintButton = new JButton("Use Hint");
        hintButton.addActionListener(e ->{ 
            hintsUsed++;
            JOptionPane.showMessageDialog(panel, hint, "Hint", JOptionPane.INFORMATION_MESSAGE);
        });
        controlPanel.add(hintButton);
    
        //JButton nextQuestionButton = new JButton("Next Question");
        //nextQuestionButton.addActionListener(e -> goToNextQuestion());
        //nextQuestionButton.setEnabled(false); // Initially disabled, enable when answer is correct
        //controlPanel.add(nextQuestionButton);
    
        bottomPanel.add(controlPanel, BorderLayout.SOUTH);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        for (String option : options) {
            JButton optionButton = new JButton(option);
            optionButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
            optionButton.setFocusPainted(false);
            optionButton.setBackground(Color.WHITE);
            optionButton.setBorder(buttonBorder);
            optionButton.addActionListener(e -> checkAnswer(e.getActionCommand(), correctAnswer));
            optionsPanel.add(optionButton);
        }
    
    
        return panel;
    }
    
    private void checkAnswer(String selectedOption, String correctAnswer) {
        if (selectedOption.equals(correctAnswer)) {
            totalPoints += 10; // Or your scoring logic
            pointsLabel.setText("Score: " + totalPoints);
            JOptionPane.showMessageDialog(this, "Correct!", "Answer", JOptionPane.INFORMATION_MESSAGE);
            goToNextQuestion(); 
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect!", "Answer", JOptionPane.ERROR_MESSAGE);
            goToNextQuestion(); 
        }
    }
    
    private void enableNextQuestionButton(JButton nextQuestionButton) {
        // Assuming you have a reference to the next question button
        nextQuestionButton.setEnabled(true);
    }

    private void showFunFact(boolean isCorrect, int funFactIndex, int questionIndex) {
        String message = isCorrect ? "Correct! " : "Incorrect. ";
        //message += currentLevelData.funFacts[questionIndex][funFactIndex];
        JOptionPane.showMessageDialog(this, message, isCorrect ? "Correct Answer" : "Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
    }

    private void goToNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex >= questionTitles.length) {
            
            if (playerData.getLevelCompleted() < levelNumber) {
                JOptionPane.showMessageDialog(this, "You've completed all questions! Total Points: " + totalPoints, "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                playerData.setLevelCompleted(levelNumber);
                playerData.setScore(playerData.getScore() + totalPoints);
                playerData.setHintsUsed(hintsUsed);
            }
            else{JOptionPane.showMessageDialog(this, "You've completed all questions! This isn't your first time, Sorry No points. ");
        }
            // Add the points earned in this level to the player's total score
        
        // Now, save the updated player data back to the JSON file
        GameDataManager.updatePlayerData(playerData);

            levelSelectionScreen.refreshButtons();

            return;
        }


        cardLayout.show(cardsPanel, "Question" + currentQuestionIndex);
        this.revalidate();
        this.repaint();
        isAnswerCorrect = false;
    }
}
