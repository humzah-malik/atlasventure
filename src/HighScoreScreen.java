import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The {@code HighScoreScreen} class represents a screen displaying the high scores from previous game sessions.
 * It extends {@link GameScreen} to use common screen functionalities.
 * The screen shows a list of top scores and provides a way to navigate back to the main menu.
 *
 * @version 1.0
 * @author Ali Mohamed
 * @author Nikunj Patel
 */

public class HighScoreScreen extends GameScreen {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    private GameManager gameManager;
	private List<GameData> topScores;

// The `public HighScoreScreen(GameManager gameManager, List<GameData> topScores)` constructor in the
// `HighScoreScreen` class is initializing a new instance of the `HighScoreScreen` with the provided
// `GameManager` and a list of `GameData` representing the top scores.
public HighScoreScreen(GameManager gameManager, List<GameData> topScores) {
    this.gameManager = gameManager;
    this.topScores = topScores; // Save the top scores
    initialize();
}


    /**
     * The `initialize` method sets up a graphical user interface for displaying high scores in a Java
     * application.
     */
    @Override
    protected void initialize() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.setLayout(null);

        JLabel title = new JLabel("High Scores");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        title.setForeground(Color.black);
        title.setBounds(200, 0, 400, 100);
        this.add(title);


        JPanel greyPanel = new JPanel();
        greyPanel.setBackground(Color.white);
        greyPanel.setBounds(100, 150, 600, 300); // Adjust size as needed
        greyPanel.setLayout(new GridLayout(topScores.size() + 1, 3)); // Rows for scores and one for header
        Border blackBorder = BorderFactory.createLineBorder(Color.black, 5);
        greyPanel.setBorder(blackBorder);

        // Headers
        greyPanel.add(new JLabel("#", SwingConstants.CENTER));
        greyPanel.add(new JLabel("Name", SwingConstants.CENTER));
        greyPanel.add(new JLabel("Score", SwingConstants.CENTER));

        // Scores
        int rank = 1;
        for (GameData data : topScores) {
            greyPanel.add(new JLabel(String.valueOf(rank++), SwingConstants.CENTER));
            greyPanel.add(new JLabel(data.getPlayerUsername(), SwingConstants.CENTER));
            greyPanel.add(new JLabel(String.valueOf(data.getScore()), SwingConstants.CENTER));
        }

        this.add(greyPanel);

        JButton backToMain = createBackButton();
        this.add(backToMain);
    }

    /**
     * The `createBackButton` function creates a JButton with an image and functionality to return to
     * the main menu in a Java application.
     * 
     * @return The method `createBackButton()` returns a `JButton` component that has been configured
     * to display an image of a back button, set its bounds, background, border, and content area
     * properties, added an action listener to change the game state to "MAIN_MENU" and play a button
     * click sound when clicked.
     */
    private JButton createBackButton() {
        JButton backToMain = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
        backToMain.setBounds(10, 10, 60, 60);
        backToMain.setBackground(null);
        backToMain.setBorderPainted(false);
        backToMain.setContentAreaFilled(false);
        backToMain.addActionListener(e ->{ 
            gameManager.changeGameState("MAIN_MENU");
            AudioManager.getInstance().playButtonClickSound();
        });
        return backToMain;
    }

    @Override
    public void updateScreen() {
        repaint();
    }

    @Override
    public void activate() {
        this.setVisible(true);
    }

    @Override
    public void deactivate() {
        this.setVisible(false);
    }


	@Override
	protected void handleInput(String actionCommand) {
		throw new UnsupportedOperationException("Unimplemented method 'handleInput'");
	}
}
