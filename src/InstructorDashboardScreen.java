import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

/**
 * The {@code InstructorDashboardScreen} class creates a screen where an instructor can view 
 * high score data and other game-related statistics. This screen is protected by a password.
 * Extends {@link GameScreen} to adhere to the application's screen structure.
 *
 * @author Ali Mohamed
 * @author Nikunj Patel
 * @version 1.0
 */

public class InstructorDashboardScreen extends GameScreen {
    
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    private GameManager gameManager;
    private final String INSTRUCTOR_PASSWORD = "123"; // Set your password here.
    private JPanel contentPanel;
    

    // This constructor `public InstructorDashboardScreen(GameManager gameManager)` is initializing an
    // instance of the `InstructorDashboardScreen` class with a reference to a `GameManager` object.
    public InstructorDashboardScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        
        if (!verifyPassword()) {
            // If password verification fails, change state back to main menu.
            SwingUtilities.invokeLater(() -> gameManager.changeGameState("MAIN_MENU"));
        } else {
            // If verification is successful, proceed to load UI components and player data.
            SwingUtilities.invokeLater(this::initializeUIComponents);
        }
    }

    /**
     * The `initializeUIComponents` method sets up the user interface components for displaying player
     * data with a scrollable panel.
     */
    private void initializeUIComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.gray);
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        // Top panel with back button and title
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);
        
        // Content panel for displaying player data
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.gray);

        // Scroll pane to enable scrolling through the player data
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Load and display the player data
        loadAndDisplayPlayerData();
    }

    /**
     * The `createTopPanel` function in Java creates a JPanel with a back button and a title for an
     * Instructor Dashboard interface.
     * 
     * @return The method `createTopPanel()` returns a `JPanel` component that contains a top panel
     * with a back button on the left side and a title "Instructor Dashboard" centered in the panel.
     */
    private JPanel createTopPanel() {
        // Main top panel with BorderLayout
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.gray);
        topPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, 80));
    
        // Left-aligned panel for the back button
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.setOpaque(false); // Make it transparent
    
        JButton backToMain = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
        backToMain.setPreferredSize(new Dimension(60, 60)); // Adjust as needed
        backToMain.setBorderPainted(false);
        backToMain.setContentAreaFilled(false);
        backToMain.addActionListener(e ->{ 
            gameManager.changeGameState("MAIN_MENU");
            AudioManager.getInstance().playButtonClickSound();
        });
        backButtonPanel.add(backToMain);
    
        // Add the back button panel to the WEST side of the topPanel
        topPanel.add(backButtonPanel, BorderLayout.WEST);
    
        // Center-aligned panel for the title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false); // Make it transparent
    
        JLabel titleLabel = new JLabel("Instructor Dashboard");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        titleLabel.setForeground(Color.black);
        titlePanel.add(titleLabel);
    
        // Add the title panel to the CENTER of the topPanel
        topPanel.add(titlePanel, BorderLayout.CENTER);
    
        return topPanel;
    }

    /**
     * The function `verifyPassword` prompts the user to enter a password and returns true if the
     * entered password matches a predefined instructor password.
     * 
     * @return The method `verifyPassword()` is returning a boolean value. It returns `true` if the
     * user clicks OK in the dialog and the entered password matches the `INSTRUCTOR_PASSWORD`,
     * otherwise it returns `false`.
     */
    private boolean verifyPassword() {
        JPasswordField pf = new JPasswordField();
        int ok = JOptionPane.showConfirmDialog(null, pf, "Enter Instructor Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        return ok == JOptionPane.OK_OPTION && INSTRUCTOR_PASSWORD.equals(new String(pf.getPassword()));
    }

    /**
     * The function `loadAndDisplayPlayerData` removes existing content, loads player data from a file,
     * creates panels for each player, adds them to a panel, and then refreshes the display.
     */
    private void loadAndDisplayPlayerData() {
        contentPanel.removeAll();

        List<GameData> players = GameDataManager.getInfo(GameDataManager.FILE_PATH);

        for (GameData player : players) {
            JPanel playerPanel = createPlayerInfoPanel(player);
            contentPanel.add(playerPanel);
        }
        System.out.println("Loaded players: " + players.size());

        contentPanel.revalidate();
        contentPanel.repaint();

    }

   /**
    * The function creates a JPanel displaying player information such as username, score, level
    * completed, and hints used.
    * 
    * @param data The `data` parameter in the `createPlayerInfoPanel` method is of type `GameData`. It
    * contains information about the player such as their username, score, level completed, and hints
    * used.
    * @return The method `createPlayerInfoPanel` returns a `JPanel` that displays player information
    * such as username, score, level completed, and hints used.
    */
    private JPanel createPlayerInfoPanel(GameData data) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Player Info"));

        panel.add(new JLabel("Username:"));
        panel.add(new JLabel(data.getPlayerUsername()));
        panel.add(new JLabel("Score:"));
        panel.add(new JLabel(String.valueOf(data.getScore())));
        panel.add(new JLabel("Level Completed:"));
        panel.add(new JLabel(String.valueOf(data.getLevelCompleted())));
        panel.add(new JLabel("Hints Used:"));
        panel.add(new JLabel(String.valueOf(data.getHintsUsed())));

        return panel;
    }

    @Override
    protected void initialize() {
    }

    @Override
    public void updateScreen() {
    }

    @Override
    public void activate() {
    }

    @Override
    public void deactivate() {
    }

    @Override
    protected void handleInput(String actionCommand) {
        
    }
}
