import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class NewGameScreen extends GameScreen {

    private GameManager gameManager;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton createButton;
    private JLabel feedbackLabel;

    public NewGameScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        initialize();
    }

    @Override
    protected void initialize() {
        setLayout(new GridLayout(0, 1)); // Simple grid layout for form

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        createButton = new JButton("Create Profile");
        createButton.addActionListener(this::createProfileAction);
        add(createButton);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> gameManager.changeGameState("MAIN_MENU"));
        this.add(backButton);
        
        feedbackLabel = new JLabel("");
        add(feedbackLabel);
    }

    private void createProfileAction(ActionEvent e) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

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

        // Transition to Level Select screen (assuming you have this setup)
        gameManager.switchToLevelSelectionScreen(newGameData);
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
