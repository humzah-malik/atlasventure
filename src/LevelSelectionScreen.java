import javax.swing.*;
import java.awt.*;

/**
 * Represents the screen for level selection in the game. 
 * Players can choose from available levels to play based on their progress.
 * Inherits from {@link GameScreen} to provide a consistent interface and functionality across screens.
 * 
 * @author Ali Mohamed
 * @author Nikunj Patel
 * @version 1.0
 */
public class LevelSelectionScreen extends GameScreen {
    
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    private GameManager gameManager;
    private GameData playerData; // Added to hold the player's game data

    public LevelSelectionScreen(GameManager gameManager, GameData playerData) {
        this.gameManager = gameManager;
        this.playerData = playerData; // Initialize playerData with passed GameData
        initialize();
    }

    /**
     * The `initialize` method sets up a level selection screen with title, back button, and
     * dynamically created level buttons based on player progress.
     */
    @Override
    protected void initialize() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        this.setLayout(null); // Use null layout for absolute positioning
        
        JLabel title = new JLabel("Level Selection");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        title.setForeground(Color.white);
        title.setBounds(0, 20, SCREEN_WIDTH, 60);
        this.add(title);

        JButton backToMain = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
        backToMain.setBounds(10, 10, 60, 60);
        backToMain.setBackground(null);
        backToMain.setBorderPainted(false);
        backToMain.setContentAreaFilled(false);
        backToMain.addActionListener(e ->{ 
            gameManager.switchToGameModeScreen(playerData);
            AudioManager.getInstance().playButtonClickSound();
        });
        this.add(backToMain);

        // Dynamically create level buttons based on player progress
        int levelsCompleted = playerData.getLevelCompleted();
for (int i = 0; i < 5; i++) { // Assuming 5 levels for simplicity
    String buttonText = "Level " + (i + 1) + getStatus(i, levelsCompleted);
    JButton levelButton = new JButton(buttonText);
    levelButton.setBounds(250, 100 + i * 80, 300, 50); // Adjust button position and size
    levelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
    levelButton.setBackground(Color.white);
    levelButton.setEnabled(i <= levelsCompleted); // Unlock current and next level

    final int level = i + 1; // Effectively final copy of i for use in lambda
    levelButton.addActionListener(e -> {
        AudioManager.getInstance().playButtonClickSound();
        selectLevel(level);
    });
    this.add(levelButton);
}
    }

    /**
     * The function `getStatus` determines the status of a level based on the level index and the
     * number of levels completed.
     * 
     * @param levelIndex The `levelIndex` parameter represents the index of the level for which you
     * want to determine the status.
     * @param levelsCompleted The `levelsCompleted` parameter represents the number of levels that have
     * been completed by the player.
     * @return The method `getStatus` returns a String indicating the status of a level based on the
     * `levelIndex` and `levelsCompleted` parameters. The possible return values are:
     * - " - Completed" if `levelIndex` is less than `levelsCompleted`
     * - " - Current" if `levelIndex` is equal to `levelsCompleted`
     * - " - Locked" if `levelIndex` is greater
     */
    private String getStatus(int levelIndex, int levelsCompleted) {
        if (levelIndex < levelsCompleted) return " - Completed";
        else if (levelIndex == levelsCompleted) return " - Current";
        else return " - Locked";
    }

    JButton [] levelButtons = new JButton [5];
    /**
     * The `initializeButtons` method dynamically creates level buttons based on player progress,
     * setting their text, position, font, background color, and enabling/disabling based on completed
     * levels.
     */
    private void initalizeButtons()
    {
        // Dynamically create level buttons based on player progress
        int levelsCompleted = playerData.getLevelCompleted();
        for (int i = 0; i < 5; i++) { // Assuming 5 levels for simplicity
            String buttonText = "Level " + (i + 1) + getStatus(i, levelsCompleted);
            JButton levelButton = new JButton(buttonText);
            levelButton.setBounds(250, 100 + i * 80, 300, 50); // Adjust button position and size
            levelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            levelButton.setBackground(Color.white);
            levelButton.setEnabled(i <= levelsCompleted); // Unlock current and next level

            final int level = i + 1; // Effectively final copy of i for use in lambda
            levelButton.addActionListener(e -> selectLevel(level));
            this.add(levelButton);
            levelButtons [i] = levelButton;

        }

    }
     /**
      * The `refreshButtons` function updates the position, size, font, background color, and enabled
      * status of level buttons based on player progress.
      */
     public void refreshButtons ()
     {
         for (int i = 0; i< levelButtons.length; i++)
         {
             JButton levelButton = levelButtons[i];
             levelButton.setBounds(250, 100 + i * 80, 300, 50); // Adjust button position and size
             levelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
             levelButton.setBackground(Color.white);
             levelButton.setEnabled(i <= playerData.getLevelCompleted()); // Unlock current and next level
             String buttonText = "Level " + (i + 1) + getStatus(i, playerData.getLevelCompleted());
             levelButton.setText(buttonText);

         }

     }

    /**
     * The `selectLevel` method selects a game level, creates a JFrame for the level, and switches to
     * gameplay for that level.
     * 
     * @param levelNumber The `levelNumber` parameter is an integer value that represents the number of
     * the level being selected.
     */
    private void selectLevel(int levelNumber) {
        System.out.println("Selected Level: " + levelNumber);
        JFrame frame = new JFrame("Level " + levelNumber + " Game");
        Level1Game level1Game = new Level1Game(levelNumber,playerData, this, gameManager);
        gameManager.switchToGameplay(playerData, levelNumber, this);
    }

    @Override
    public void updateScreen() {
        // Implement screen update logic if necessary
    }

    @Override
    public void activate() {
        // Implement activation logic if necessary
    }

    @Override
    public void deactivate() {
        // Implement deactivation logic if necessary
    }

    @Override
    protected void handleInput(String actionCommand) {
        // Implement input handling if necessary
    }

    
}
