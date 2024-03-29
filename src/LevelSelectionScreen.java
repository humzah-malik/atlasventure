import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
        this.setLayout(new GridLayout(0, 1, 10, 10)); // Use GridLayout for automatic alignment
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        
        JLabel title = new JLabel("Level Selection");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        title.setForeground(Color.white);
        this.add(title);

        // Dynamically create level buttons based on player progress
        int levelsCompleted = playerData.getLevelCompleted();
        for (int i = 0; i < 5; i++) { // Assuming 5 levels for simplicity
            JButton levelButton = new JButton("Level " + (i + 1) + getStatus(i, levelsCompleted));
            levelButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            levelButton.setEnabled(i <= levelsCompleted); // Unlock current and next level
            int level = i + 1;
            levelButton.addActionListener(e -> selectLevel(level));
            this.add(levelButton);
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> gameManager.changeGameState("MAIN_MENU"));
        this.add(backButton);
    }

    private String getStatus(int levelIndex, int levelsCompleted) {
        if (levelIndex < levelsCompleted) return " - Completed";
        else if (levelIndex == levelsCompleted) return " - Current";
        else return " - Locked";
    }

    private void selectLevel(int levelNumber) {
        // Here you can implement the logic to start the selected level
        System.out.println("Selected Level: " + levelNumber);
        // For example: gameManager.startLevel(levelNumber);
    }

	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateScreen'");
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'activate'");
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deactivate'");
	}

	@Override
	protected void handleInput(String actionCommand) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'handleInput'");
	}

    // The rest of your overridden methods (updateScreen, activate, deactivate, handleInput)
}
