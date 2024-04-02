import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The ThemeBasedModeSelectionScreen class allows the player to select a theme for their gameplay.
 * This screen presents different thematic options, such as landmarks, traditional clothing, and culture/traditions.
 * It extends the GameScreen abstract class and utilizes the GameManager to handle transitions between game states.
 *
 * @author Ali Mohamed
 * @author Nikunj Patel
 * @version 1.0
 */
public class ThemeBasedModeSelectionScreen extends GameScreen {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    private ArrayList<JButton> themeOptions;
    private GameManager gameManager;
    private GameData playerData;

    // This constructor `public ThemeBasedModeSelectionScreen(GameManager gameManager, GameData
    // currentPlayerData)` is initializing a new instance of the `ThemeBasedModeSelectionScreen` class
    // with the provided `GameManager` and `GameData` objects.
    public ThemeBasedModeSelectionScreen(GameManager gameManager, GameData currentPlayerData) {
        this.gameManager = gameManager;
        this.playerData = currentPlayerData;
        initialize();
    }

    /**
     * The `initialize` method sets up a GUI interface for selecting a theme in a Java application,
     * including labels, buttons, and event listeners.
     */
    @Override
    protected void initialize() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.setLayout(null);

        JLabel title = new JLabel("Select Theme");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setForeground(Color.black);
        title.setSize(400, 100);
        title.setLocation((SCREEN_WIDTH - title.getWidth()) / 2, 0);
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

        themeOptions = new ArrayList<>();

        JButton landmarksButton = new JButton("Landmarks");
        JButton languagesButton = new JButton("Traditional Clothing");
        JButton cultureButton = new JButton("Culture/Traditions");

        themeOptions.add(landmarksButton);
        themeOptions.add(languagesButton);
        themeOptions.add(cultureButton);

        for (int i = 0, y = 180; i < themeOptions.size(); i++, y += 80) {
            JButton currentButton = themeOptions.get(i);
            currentButton.setBounds(250, y, 300, 50);
            currentButton.setBackground(Color.white);
            currentButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            currentButton.addActionListener(new ThemeModeActionListener(gameManager, currentButton.getText(), i, this, playerData));
            this.add(currentButton);
        }
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
    }

    /**
     * This class represents an ActionListener for selecting a theme mode in a game, which triggers a
     * switch to gameplay with the selected theme.
     */
    private class ThemeModeActionListener implements ActionListener {
        private final GameManager gameManager;
        private final String themeMode;
        private final ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen;
        private final GameData playerData;
        int i;

        // This `ThemeModeActionListener` constructor is initializing the member variables of the
        // `ThemeModeActionListener` class with the values passed as arguments to the constructor.
        // Here's what each parameter is used for:
        public ThemeModeActionListener(GameManager gameManager, String themeMode, int i, ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen, GameData playerData) {
            this.gameManager = gameManager;
            this.themeMode = themeMode;
            this.i=i;
            this.themeBasedModeSelectionScreen = themeBasedModeSelectionScreen;
            this.playerData = playerData;
        }

       /**
        * The actionPerformed method plays a button click sound, prints the selected theme mode, and
        * switches to a gameplay screen based on the selected theme mode.
        * 
        * @param e The parameter `e` in the `actionPerformed` method of an `ActionListener` represents
        * the `ActionEvent` that occurred, such as a button click or menu selection. It provides
        * information about the event that triggered the action, allowing you to respond accordingly in
        * your code.
        */
        @Override
        public void actionPerformed(ActionEvent e) {
            AudioManager.getInstance().playButtonClickSound();
            System.out.println("Selected theme mode: " + themeMode);
            gameManager.switchToGameplay2(playerData, i, themeBasedModeSelectionScreen);
        }
    }
}

