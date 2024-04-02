 import javax.swing.*;
 import javax.swing.border.Border;
 
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.util.Enumeration;
 
 /**
 * This class represents the levels of the game. It is responsible for displaying questions, managing game state,
 * and interacting with other components like GameManager and LevelSelectionScreen.
 *
 * @version 1.0
 * @author Het Patel
 * @author Nikunj Patel
 */

 public class Level1Game extends JPanel {
     static final int SCREEN_WIDTH = 800;
     static final int SCREEN_HEIGHT = 650;
     private int levelNumber;
     private CardLayout cardLayout = new CardLayout();
     private JPanel cardsPanel;
     private boolean isAnswerCorrect = false;
     private int totalPoints = 0;
     private JLabel pointsLabel;
     private boolean[] questionAnsweredCorrectly;
     private levelData currentLevelData;
     private int currentQuestionIndex = 0;
     private GameData playerData;
     private LevelSelectionScreen levelSelectionScreen;
     private GameManager gameManager;
     int hintsUsed;
     String[] questionTitles = {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5"};
 
     // The `public Level1Game(int levelNumber, GameData player, LevelSelectionScreen
     // levelSelectionScreen, GameManager gameManager)` constructor in the `Level1Game` class is
     // initializing a new instance of the `Level1Game` class with the provided parameters. Here's what
     // each parameter is used for:
     public Level1Game(int levelNumber, GameData player, LevelSelectionScreen levelSelectionScreen, GameManager gameManager) {
         this.levelSelectionScreen = levelSelectionScreen;
         this.levelNumber = levelNumber;
         this.playerData = player;
         this.gameManager = gameManager;
         currentLevelData = new levelData(levelNumber);
         initialize();
     }
 
     /**
      * The `initialize` method sets up the layout and components for a game level screen in Java Swing.
      */
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
             gameManager.switchToLevelSelectionScreen(playerData);
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
 
     /**
      * The `createCardsPanel` method creates a panel with multiple question panels based on provided
      * data and adds it to the center of the layout.
      */
     private void createCardsPanel() {
         cardsPanel = new JPanel(cardLayout);
         cardsPanel.setOpaque(false); // Making the cards panel transparent
         for (int i = 0; i < questionTitles.length; i++) {
             JPanel questionPanel = createQuestionPanel(questionTitles[i], currentLevelData.correctAnswers[i], currentLevelData.options[i], currentLevelData.hints[i], currentLevelData.imagePaths[i]);
             cardsPanel.add(questionPanel, "Question" + i);
         }
         add(cardsPanel, BorderLayout.CENTER);
     }
 
     /**
      * The `createQuestionPanel` function creates a panel for displaying a question with options, hint
      * button, and image in a Java Swing GUI.
      * 
      * @param questionTitle The `questionTitle` parameter is a String that represents the title or text
      * of the question being displayed to the user. It is typically a question or a statement that the
      * user needs to respond to.
      * @param correctAnswer The `correctAnswer` parameter in the `createQuestionPanel` method is used
      * to specify the correct answer for the question being displayed. This answer will be compared
      * with the option selected by the user to determine if it is correct or not.
      * @param options The `options` parameter in the `createQuestionPanel` method is an array of
      * strings that represent the answer options for a multiple-choice question. Each string in the
      * array corresponds to a possible answer choice that the user can select. These options will be
      * displayed as buttons in the graphical user interface for the
      * @param hint The `hint` parameter in the `createQuestionPanel` method is used to provide a hint
      * for the question being displayed. When the user clicks on the "Use Hint" button, the hint
      * message associated with the question will be displayed in a dialog box.
      * @param imagePath The `imagePath` parameter in the `createQuestionPanel` method is a String that
      * represents the path to the image file that will be displayed in the panel. This path is used to
      * load the image and set it as the icon for the `imageLabel` in the panel. Make sure to
      * @return The `createQuestionPanel` method returns a `JPanel` that contains a question title, an
      * image, option buttons for the user to select an answer, a hint button, and control buttons for
      * the user to interact with the question panel.
      */
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
     
     /**
      * The `checkAnswer` function compares the selected option with the correct answer, updates the
      * score and displays a fun fact before moving to the next question.
      * 
      * @param selectedOption The `selectedOption` parameter represents the answer option that the user
      * has chosen for a particular question in a quiz or a similar scenario. It is compared with the
      * `correctAnswer` parameter to determine if the user's choice is correct or not.
      * @param correctAnswer The `correctAnswer` parameter in the `checkAnswer` method is the correct
      * answer to the current question being evaluated. It is compared with the `selectedOption`
      * parameter, which represents the answer chosen by the user. If the `selectedOption` matches the
      * `correctAnswer`, the user's answer
      */
     private void checkAnswer(String selectedOption, String correctAnswer) {
         if (selectedOption.equals(correctAnswer)) {
             isAnswerCorrect = true;
             totalPoints += 10; // Or your scoring logic
             pointsLabel.setText("Score: " + totalPoints);
             showFunFact(isAnswerCorrect, currentQuestionIndex, correctAnswer);
             goToNextQuestion(); 
         } else {
             isAnswerCorrect = false;
             showFunFact(isAnswerCorrect, currentQuestionIndex, correctAnswer);
             goToNextQuestion(); 
         }
     }
     
     /**
      * The function `enableNextQuestionButton` enables a specified JButton for the next question.
      * 
      * @param nextQuestionButton The `nextQuestionButton` parameter is of type `JButton`, which is a
      * class representing a button component in Java Swing.
      */
     private void enableNextQuestionButton(JButton nextQuestionButton) {
         // Assuming you have a reference to the next question button
         nextQuestionButton.setEnabled(true);
     }
 
     /**
      * This Java function displays a message with a fun fact based on whether the answer provided is
      * correct or incorrect.
      * 
      * @param isCorrect The `isCorrect` parameter is a boolean value that indicates whether the user's
      * answer to a question is correct or not. If `isCorrect` is `true`, it means the user's answer is
      * correct. If `isCorrect` is `false`, it means the user's answer is incorrect
      * @param questionIndex The `questionIndex` parameter is an integer value that represents the index
      * of the question for which you want to display a fun fact. It is used to access the corresponding
      * fun fact from the `funFacts` array in the `currentLevelData`.
      * @param correctAnswer The `correctAnswer` parameter in the `showFunFact` method is a `String`
      * that represents the correct answer to the question at the specified `questionIndex`. It is used
      * in the message displayed to the user when they provide an incorrect answer, indicating what the
      * correct answer should have been.
      */
     private void showFunFact(boolean isCorrect, int questionIndex, String correctAnswer) {
         if(currentLevelData.funFacts != null && currentLevelData.funFacts.length > questionIndex) {
             String funFact = currentLevelData.funFacts[questionIndex]; 
             String message = isCorrect ? "Correct!\n" : "Incorrect. The correct answer is " + correctAnswer +".\n";
             message += "Fun Fact: " + funFact; 
             JOptionPane.showMessageDialog(this, message, isCorrect ? "Correct Answer" : "Incorrect Answer", JOptionPane.INFORMATION_MESSAGE);
         }
     }
     
     
     
 
 
     /**
      * The function `goToNextQuestion` increments the current question index, displays a message based
      * on completion status and total points, updates player data, and switches to the level selection
      * screen.
      */
     private void goToNextQuestion() {
         currentQuestionIndex++;
         if (currentQuestionIndex >= questionTitles.length) {
             
             if (playerData.getLevelCompleted() < levelNumber && totalPoints >= 30) {
                 JOptionPane.showMessageDialog(this, "You've completed all questions! Total Points: " + totalPoints, "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                 playerData.setLevelCompleted(levelNumber);
                 playerData.setScore(playerData.getScore() + totalPoints);
                 playerData.setHintsUsed(hintsUsed);
                 gameManager.switchToLevelSelectionScreen(playerData);
             }
             else if(playerData.getLevelCompleted() < levelNumber && totalPoints < 30){
                 JOptionPane.showMessageDialog(this, "You've completed all questions! Your score is "+totalPoints+". You need at least 30 points to pass.");
                 gameManager.switchToLevelSelectionScreen(playerData);
             }
             else{
                 JOptionPane.showMessageDialog(this, "You've completed all questions! This isn't your first time. No points, sorry!");
                 gameManager.switchToLevelSelectionScreen(playerData);
             }
             // Add the points earned in this level to the player's total score
         
         // Now, save the updated player data back to the JSON file
         if(playerData.getPlayerUsername() == "DebugPlayer"){
        }
        else{
            GameDataManager.updatePlayerData(playerData);
        }
        levelSelectionScreen.refreshButtons();

        return;
    }
 
 
         cardLayout.show(cardsPanel, "Question" + currentQuestionIndex);
         this.revalidate();
         this.repaint();
         isAnswerCorrect = false;
     }
 }
 