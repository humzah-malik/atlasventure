import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameManager implements ActionListener {
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String currentState;
    private Timer gameLoopTimer;

    public GameManager() {
        initializeGameWindow();
        initializeGameLoop();
        
        changeGameState("MAIN_MENU");

    }

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

    private void initializeGameLoop() {
         // Set up a game loop timer that calls actionPerformed every 16 ms (~60 FPS)
         gameLoopTimer = new Timer(16, this);
         gameLoopTimer.start();
    }

    
    /** 
     * @param newState
     */
    public void changeGameState(String newState) {
        // Update the currentState
        currentState = newState;

        // Change the displayed screen based on the newState
        cardLayout.show(cardPanel, newState);

    }

    public void switchToLevelSelectionScreen(GameData currentPlayerData) {
        LevelSelectionScreen levelSelectionScreen = new LevelSelectionScreen(this, currentPlayerData);
        AudioManager.getInstance().stopGameplayMusic();
        cardPanel.add(levelSelectionScreen, "LEVEL_SELECT");
        cardLayout.show(cardPanel, "LEVEL_SELECT");
    }

    public void switchToGameModeScreen(GameData currentPlayerData) {
        GameModeScreen gameModeScreen = new GameModeScreen(this, currentPlayerData);
        cardPanel.add(gameModeScreen, "GAME_MODE");
        cardLayout.show(cardPanel, "GAME_MODE");
    }

    public void switchToThemeBasedModeSelectionScreen(GameData currentPlayerData) {
        AudioManager.getInstance().stopGameplayMusic();
        ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen = new ThemeBasedModeSelectionScreen(this, currentPlayerData);
        cardPanel.add(themeBasedModeSelectionScreen, "THEME_MODE");
        cardLayout.show(cardPanel, "THEME_MODE");
    }

    public void switchToDebugLevelSelection(GameData debugData) {
        LevelSelectionScreen levelSelectionScreen = new LevelSelectionScreen(this, debugData);
        cardPanel.add(levelSelectionScreen, "LEVEL_SELECT_DEBUG");
        cardLayout.show(cardPanel, "LEVEL_SELECT_DEBUG");
    }

    
    public void switchToGameplay(GameData playerData, int selectedLevel, LevelSelectionScreen levelSelectionScreen) {
        AudioManager.getInstance().playGameplayMusic();
        Level1Game level1Game = new Level1Game(selectedLevel, playerData, levelSelectionScreen, this);
        cardPanel.add(level1Game, "GAME_PLAY");
        cardLayout.show(cardPanel, "GAME_PLAY");
    }

    public void switchToGameplay2(GameData playerData, int selectedLevel, ThemeBasedModeSelectionScreen themeBasedModeSelectionScreen) {
        AudioManager.getInstance().playGameplayMusic();
        Level2Game level2Game = new Level2Game(selectedLevel, playerData, themeBasedModeSelectionScreen, this);
        cardPanel.add(level2Game, "GAME_PLAY");
        cardLayout.show(cardPanel, "GAME_PLAY");
    }

    public void showHighScores() {
        List<GameData> topScores = GameDataManager.getTopScores("game_data.json");
        HighScoreScreen highScoreScreen = new HighScoreScreen(this, topScores); 
        cardPanel.add(highScoreScreen, "HIGH_SCORES");
        cardLayout.show(cardPanel, "HIGH_SCORES");
    }

    public void showInstructorDashboard() {
        InstructorDashboardScreen instructorScreen = new InstructorDashboardScreen(this);
        cardPanel.add(instructorScreen, "INSTRUCTOR");
        cardLayout.show(cardPanel, "INSTRUCTOR");
        instructorScreen.initialize(); // Now explicitly calling initialize
    }
    
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

    public void closeGame() {
        mainFrame.dispose(); // Close the window and clean up
        System.exit(0); // Ensure the application fully exits
    }

    // Main method
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameManager());
    }



}
