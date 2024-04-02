import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the screen for creating a new game profile, allowing the user to enter a username and password.
 * This class interacts with the GameManager to transition to different game states upon successful profile creation.
 *
 * @author Ali Mohamed
 * @author Nikunj Patel
 */
public class NewGameScreen extends GameScreen {

    private GameManager gameManager; // The game's state manager
    private JTextField usernameField; // Field for user to enter username
    private JPasswordField passwordField; // Field for user to enter password
    private JButton createButton; // Button to initiate profile creation
    private JLabel feedbackLabel; // Label to provide feedback to the user

    // The `public NewGameScreen(GameManager gameManager)` constructor in the `NewGameScreen` class is
    // initializing a new instance of the `NewGameScreen` class. It takes a `GameManager` object as a
    // parameter and assigns it to the `gameManager` instance variable of the `NewGameScreen` class.
    // After assigning the `gameManager`, it calls the `initialize()` method to set up the graphical
    // user interface components and layout for the new game screen.
    public NewGameScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        initialize();
    }

    /**
     * The `initialize` method sets up a GUI for creating a new profile with labels, text fields,
     * buttons, and feedback display.
     */
    @Override
    protected void initialize() {
        this.setLayout(null); // Use null layout for absolute positioning
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.gray);

        JLabel titleLabel = new JLabel("Create New Profile");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        titleLabel.setForeground(Color.black);
        titleLabel.setBounds(200, 50, 400, 50);
        this.add(titleLabel);

        int yStart = 150;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        usernameLabel.setForeground(Color.black);
        usernameLabel.setBounds(200, yStart, 150, 30);
        this.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(350, yStart, 250, 30);
        this.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(200, yStart + 50, 150, 30);
        this.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(350, yStart + 50, 250, 30);
        this.add(passwordField);

        createButton = new JButton("Create Profile");
        createButton.setBounds(350, yStart + 100, 150, 30);
        createButton.addActionListener(this::createProfileAction);
        this.add(createButton);
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(350, yStart + 150, 150, 30);
        backButton.addActionListener(e ->{ 
            gameManager.changeGameState("MAIN_MENU");
            AudioManager.getInstance().playButtonClickSound();
        });
        this.add(backButton);
        
        feedbackLabel = new JLabel("");
        feedbackLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        feedbackLabel.setForeground(Color.red);
        feedbackLabel.setBounds(200, yStart + 200, 400, 30);
        feedbackLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(feedbackLabel);
    }

    /**
     * The `createProfileAction` function creates a new user profile with a unique username and hashed
     * password, performs basic validation, checks for existing usernames, and saves the profile data.
     * 
     * @param e The `e` parameter in the `createProfileAction` method is of type `ActionEvent`. This
     * parameter represents the action event that occurred, triggering the method to be executed. In
     * this context, it is commonly used to handle user interactions with GUI components, such as
     * buttons, that trigger the creation
     */
    private void createProfileAction(ActionEvent e) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        AudioManager.getInstance().playButtonClickSound();
        // Basic validation
        if (username.isEmpty() || password.isEmpty()) {
            feedbackLabel.setText("Username and password cannot be empty.");
            return;
        }

        // Check if username already exists
        HashMap<String, GameData> gameDataMap = GameDataManager.loadGameData("game_data.json");
        if (gameDataMap != null && gameDataMap.containsKey(username)) {
            feedbackLabel.setText("Username already exists. Please choose another.");
            return;
        }

        // Create new GameData entry
        if (gameDataMap == null) gameDataMap = new HashMap<>();
        GameData newGameData = new GameData(username, 0, 0, 0, new ArrayList<>());
        newGameData.setPassword(GameDataManager.toSHA1(password)); // Hash the password
        gameDataMap.put(username, newGameData);

        // Save game data
        GameDataManager.saveGameData(gameDataMap, "game_data.json");

        feedbackLabel.setText("Profile created successfully.");
        gameManager.switchToGameModeScreen(newGameData);
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
}
