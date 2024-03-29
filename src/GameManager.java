import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        LevelSelectionScreen levelSelectionScreen = new LevelSelectionScreen(this);
        cardPanel.add(levelSelectionScreen, "LEVEL_SELECT");

        HighScoreScreen highScoreScreen = new HighScoreScreen(this);
        cardPanel.add(highScoreScreen, "HIGH_SCORES");

        DebugMode dpassScreen = new DebugMode(this);
        cardPanel.add(dpassScreen, "DEBUG_MODE");

        //GameplayScreen gameplayScreen = new GameplayScreen(this);
        //cardPanel.add(gameplayScreen, "GAMEPLAY");

        TutorialScreen tutorialScreen = new TutorialScreen(this);
        cardPanel.add(tutorialScreen, "TUTORIAL");

        //ProgressScreen progressScreen = new ProgressScreen(this);
        //cardPanel.add(progressScreen, "PROGRESS");

        InstructorDashboardScreen instructorDashboard = new InstructorDashboardScreen(this);
        cardPanel.add(instructorDashboard, "INSTRUCTOR");

        // Add the card panel to the main frame
        mainFrame.add(cardPanel);

        // Display the main window
        mainFrame.setVisible(true);
    }

    private void initializeGameLoop() {
         // Set up a game loop timer that calls actionPerformed every 16 ms (~60 FPS)
         gameLoopTimer = new Timer(16, this);
         gameLoopTimer.start();
    }

    public void changeGameState(String newState) {
        // Update the currentState
        currentState = newState;

        // Change the displayed screen based on the newState
        cardLayout.show(cardPanel, newState);

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
