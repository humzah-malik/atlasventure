import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

    private String getStatus(int levelIndex, int levelsCompleted) {
        if (levelIndex < levelsCompleted) return " - Completed";
        else if (levelIndex == levelsCompleted) return " - Current";
        else return " - Locked";
    }

    private void selectLevel(int levelNumber) {
        System.out.println("Selected Level: " + levelNumber);
        // inform the GameManager to switch to the game play screen for this level
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
