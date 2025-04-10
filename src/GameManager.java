import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The `GameManager` class in Java represents a game manager that handles game state transitions,
 * window initialization, game loop setup, and screen switching using CardLayout.
 * 
 * @author Nikunj Patel
 */
public class GameManager implements ActionListener {
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String currentState;
    private Timer gameLoopTimer;

    // The `public GameManager()` constructor in the `GameManager` class is responsible for
    // initializing the game window, setting up the game loop, and changing the game state to the main
    // menu.
    public GameManager() {
        initializeGameWindow();
        initializeGameLoop();
        
        changeGameState("MAIN_MENU");

    }

    /**
     * The `initializeGameWindow` function sets up the main game window with specific properties, adds
     * different game screens using CardLayout, and displays the window to the user.
     */
    private void initializeGameWindow() {
        // Initialize the main game window
        mainFrame = new JFrame("AtlasVenture");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(815, 638); // Set the size of the game window
        mainFrame.setLocationRelativeTo(null); // Center the window on the screen
        mainFrame.setResizable(false);
        
        // Set up the panel with CardLayout for switching game screens
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // add game screens to the cardPanel:
        MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
        cardPanel.add(mainMenuScreen, "MAIN_MENU");

        NewGameScreen newGameScreen = new NewGameScreen(this);
        cardPanel.add(newGameScreen, "NEW_GAME");
        
        LoadGameScreen loadGameScreen = new LoadGameScreen(this);
        cardPanel.add(loadGameScreen, "LOAD_GAME");

        DebugMode dpassScreen = new DebugMode(this);
        cardPanel.add(dpassScreen, "DEBUG_MODE");

        TutorialScreen tutorialScreen = new TutorialScreen(this);
        cardPanel.add(tutorialScreen, "TUTORIAL");

        // Add the card panel to the main frame
        mainFrame.add(cardPanel);

        setupGlobalShortcuts();

        // Display the main window
        mainFrame.setVisible(true);
    }

    /**
     * The `initializeGameLoop` method sets up a game loop timer that calls the `actionPerformed`
     * method approximately every 16 milliseconds, aiming for a frame rate of around 60 frames per
     * second.
     */
    private void initializeGameLoop() {
         // Set up a game loop timer that calls actionPerformed every 16 ms (~60 FPS)
         gameLoopTimer = new Timer(16, this);
         gameLoopTimer.start();
    }

    
    /**
     * The function `changeGameState` updates the current state and changes the displayed screen based
     * on the new state using a CardLayout.
     * 
     * @param newState The `newState` parameter in the `changeGameState` method represents the new
     * state that you want to change the game to. It is a String type parameter that specifies the
     * state of the game that you want to switch to.
     */
    public void changeGameState(String newState) {
        // Update the currentState
        currentState = newState;

        // Change the displayed screen based on the newState
        cardLayout.show(cardPanel, newState);

    }

    /**
     * The function `switchToLevelSelectionScreen` creates a `LevelSelectionScreen` object, stops
     * gameplay music, adds the screen to a card panel, and shows the screen using a card layout.
     * 
     * @param currentPlayerData The `currentPlayerData` parameter is an instance of the `GameData`
     * class, which likely contains information about the current player's progress, achievements, and
     * other relevant data in the game. This data is used to initialize the `LevelSelectionScreen` and
     * customize the level selection options based on the player
     */
    public void switchToLevelSelectionScreen(GameData currentPlayerData) {
        LevelSelectionScreen levelSelectionScreen = new LevelSelectionScreen(this, currentPlayerData);
        AudioManager.getInstance().stopGameplayMusic();
        cardPanel.add(levelSelectionScreen, "LEVEL_SELECT");
        cardLayout.show(cardPanel, "LEVEL_SELECT");
    }

    /**
     * The function `switchToGameModeScreen` creates a `GameModeScreen` instance with the given
     * `currentPlayerData` and switches the card panel to display the game mode screen.
     * 
     * @param currentPlayerData The `currentPlayerData` parameter is an object of type `GameData` that
     * contains information about the current player's game data, such as their score, level,
     * achievements, etc. This data is used to initialize the `GameModeScreen` and display the
     * appropriate information for the player on the screen
     */
    public void switchToGameModeScreen(GameData currentPlayerData) {
        GameModeScreen gameModeScreen = new GameModeScreen(this, currentPlayerData);
        cardPanel.add(gameModeScreen, "GAME_MODE");
        cardLayout.show(cardPanel, "GAME_MODE");
    }

    /**
     * The function `switchToThemeBasedModeSelectionScreen` stops gameplay music, creates a
     * `ThemeBasedModeSelectionScreen` instance, adds it to a card panel, and shows it using a card
     * layout.
     * 
     * @param currentPlayerData The `currentPlayerData` parameter is an object of type `GameData` that
     * contains the data related to the current player in the game. This data could include information
     * such as the player's progress, achievements, preferences, and any other relevant details needed
     * for the game logic.
     */
    public void switchToThemeBasedModeSelectionScreen(GameData currentPlayerData) {
        AudioManager.getInstance().stopGameplayMusic();
        ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen = new ThemeBasedModeSelectionScreen(this, currentPlayerData);
        cardPanel.add(themeBasedModeSelectionScreen, "THEME_MODE");
        cardLayout.show(cardPanel, "THEME_MODE");
    }

   /**
    * The function `switchToDebugLevelSelection` creates a `LevelSelectionScreen` with debug data and
    * displays it on the card panel.
    * 
    * @param debugData The `debugData` parameter in the `switchToDebugLevelSelection` method is an
    * instance of the `GameData` class. It likely contains data related to the game that is
    * specifically used for debugging purposes. This data could include information about levels,
    * player progress, game settings, or any other relevant
    */
    public void switchToDebugLevelSelection(GameData debugData) {
        LevelSelectionScreen levelSelectionScreen = new LevelSelectionScreen(this, debugData);
        cardPanel.add(levelSelectionScreen, "LEVEL_SELECT_DEBUG");
        cardLayout.show(cardPanel, "LEVEL_SELECT_DEBUG");
    }

    
    /**
     * The function `switchToGameplay` creates a new `Level1Game` instance with the selected level,
     * player data, and screen, then adds it to a card panel and shows it.
     * 
     * @param playerData Player data containing information such as player's score, level progress, and
     * other relevant game data.
     * @param selectedLevel The `selectedLevel` parameter is an integer value that represents the level
     * selected by the player for gameplay. It is used to determine which level of the game should be
     * loaded and displayed to the player.
     * @param levelSelectionScreen The `levelSelectionScreen` parameter in the `switchToGameplay`
     * method is an instance of the `LevelSelectionScreen` class. It is being passed to the method to
     * potentially interact with or display information related to the level selection screen within
     * the game.
     */
    public void switchToGameplay(GameData playerData, int selectedLevel, LevelSelectionScreen levelSelectionScreen) {
       // AudioManager.getInstance().playGameplayMusic();
        Level1Game level1Game = new Level1Game(selectedLevel, playerData, levelSelectionScreen, this);
        cardPanel.add(level1Game, "GAME_PLAY");
        cardLayout.show(cardPanel, "GAME_PLAY");
    }

    /**
     * The function `switchToGameplay2` creates and displays a Level2Game with specified parameters in
     * a card layout.
     * 
     * @param playerData Player data containing information about the player's progress, score, and
     * other relevant game data.
     * @param selectedLevel The `selectedLevel` parameter is an integer value that represents the level
     * chosen by the player for gameplay. It is used to determine which level of the game should be
     * loaded and displayed for the player.
     * @param themeBasedModeSelectionScreen The parameter `themeBasedModeSelectionScreen` appears to be
     * an instance of the `ThemeBasedModeSelectionScreen` class. It is being passed as an argument to
     * the `switchToGameplay2` method along with `playerData` and `selectedLevel`. This parameter
     * likely represents the screen or
     */
    public void switchToGameplay2(GameData playerData, int selectedLevel, ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen) {
        // AudioManager.getInstance().playGameplayMusic();
        Level2Game level2Game = new Level2Game(selectedLevel, playerData, themeBasedModeSelectionScreen, this);
        cardPanel.add(level2Game, "GAME_PLAY");
        cardLayout.show(cardPanel, "GAME_PLAY");
    }

    /**
     * The `showHighScores` method retrieves the top scores from a game data file, creates a high score
     * screen with this data, adds it to a card panel, and displays it.
     */
    public void showHighScores() {
        List<GameData> topScores = GameDataManager.getTopScores("game_data.json");
        HighScoreScreen highScoreScreen = new HighScoreScreen(this, topScores); 
        cardPanel.add(highScoreScreen, "HIGH_SCORES");
        cardLayout.show(cardPanel, "HIGH_SCORES");
    }

    /**
     * The function `showInstructorDashboard` creates and displays an Instructor Dashboard screen,
     * adding it to a card panel and showing it using a card layout.
     */
    public void showInstructorDashboard() {
        InstructorDashboardScreen instructorScreen = new InstructorDashboardScreen(this);
        cardPanel.add(instructorScreen, "INSTRUCTOR");
        cardLayout.show(cardPanel, "INSTRUCTOR");
        instructorScreen.initialize(); // Now explicitly calling initialize
    }
    
    /**
     * The `setupGlobalShortcuts` function sets up global keyboard shortcuts for closing the game and
     * returning to the main menu in a Java application.
     */
    private void setupGlobalShortcuts() {
        JRootPane rootPane = mainFrame.getRootPane();
        
        // Shortcut for closing the game: CTRL + W
        KeyStroke closeKeyStroke = KeyStroke.getKeyStroke("control W");
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(closeKeyStroke, "CLOSE_GAME");
        rootPane.getActionMap().put("CLOSE_GAME", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the game
                System.exit(0);
            }
        });

        // Shortcut for returning to the main menu: CTRL + M
        KeyStroke menuKeyStroke = KeyStroke.getKeyStroke("control M");
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(menuKeyStroke, "MAIN_MENU");
        rootPane.getActionMap().put("MAIN_MENU", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to return to the main menu
                changeGameState("MAIN_MENU");
            }
        });

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    /**
     * The `closeGame` function closes the main window and ensures the application fully exits in Java.
     */
    public void closeGame() {
        mainFrame.dispose(); // Close the window and clean up
        System.exit(0); // Ensure the application fully exits
    }

    /**
     * The main function creates a new GameManager instance within the EventQueue.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameManager());
    }



}
