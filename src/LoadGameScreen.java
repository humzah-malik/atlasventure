import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class LoadGameScreen extends GameScreen {

    private GameManager gameManager;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel feedbackLabel;

    public LoadGameScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        initialize();
    }

    @Override
    protected void initialize() {
        setLayout(new GridLayout(0, 1)); // Use a simple grid layout

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Log In");
        loginButton.addActionListener(this::loginAction);
        add(loginButton);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> gameManager.changeGameState("MAIN_MENU"));
        this.add(backButton);

        feedbackLabel = new JLabel("");
        add(feedbackLabel);

    }

    private void loginAction(ActionEvent e) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        // Basic validation
        if (username.isEmpty() || password.isEmpty()) {
            feedbackLabel.setText("Username and password cannot be empty.");
            return;
        }

        // Load game data
        HashMap<String, GameData> gameDataMap = GameDataManager.loadGameData("game_data.json");
        if (gameDataMap == null || !gameDataMap.containsKey(username)) {
            feedbackLabel.setText("Username does not exist.");
            return;
        }

        // Validate password
        GameData playerData = gameDataMap.get(username);
        if (playerData != null && GameDataManager.toSHA1(password).equals(playerData.getPassword())) {
            feedbackLabel.setText("Login successful.");
            gameManager.switchToGameModeScreen(playerData);
        } else {
            feedbackLabel.setText("Invalid username or password.");
        }
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
