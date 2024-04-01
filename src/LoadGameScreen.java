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
        this.setLayout(null); // Use null layout for absolute positioning
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.gray);

        JLabel titleLabel = new JLabel("Log In");
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

        loginButton = new JButton("Log In");
        loginButton.setBounds(350, yStart + 100, 150, 30);
        loginButton.addActionListener(this::loginAction);
        this.add(loginButton);
        
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

    private void loginAction(ActionEvent e) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        AudioManager.getInstance().playButtonClickSound();
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
        throw new UnsupportedOperationException("Unimplemented method 'updateScreen'");
    }

    @Override
    public void activate() {
        throw new UnsupportedOperationException("Unimplemented method 'activate'");
    }

    @Override
    public void deactivate() {
        throw new UnsupportedOperationException("Unimplemented method 'deactivate'");
    }

    @Override
    protected void handleInput(String actionCommand) {
        throw new UnsupportedOperationException("Unimplemented method 'handleInput'");
    }
}
