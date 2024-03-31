import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DebugMode extends JPanel {
    private final String DEBUG_PASSWORD = "123";
    private GameManager gameManager;

    public DebugMode(GameManager gameManager) {
        this.gameManager = gameManager;
        initialize();
    }

    private void initialize() {
        setLayout(null); 
        setBackground(Color.gray);
        setPreferredSize(new Dimension(800, 600));

        JLabel titleLabel = new JLabel("Debug Mode");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        titleLabel.setForeground(Color.black);
        titleLabel.setBounds(300, 50, 200, 50);
        add(titleLabel);

        JLabel passwordLabel = new JLabel("Enter Debug Password:");
        passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(250, 150, 300, 30);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(250, 200, 300, 30);
        add(passwordField);

        JButton enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        enterButton.setBounds(250, 250, 100, 30);
        add(enterButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        backButton.setBounds(450, 250, 100, 30);
        backButton.addActionListener(e ->{ 
            AudioManager.getInstance().playButtonClickSound();    
            gameManager.changeGameState("MAIN_MENU");
        });
        add(backButton);

        JLabel statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        statusLabel.setForeground(Color.RED);
        statusLabel.setBounds(250, 300, 300, 30);
        add(statusLabel);

        enterButton.addActionListener(e -> {
            String enteredPassword = new String(passwordField.getPassword());
            AudioManager.getInstance().playButtonClickSound();
            if (DEBUG_PASSWORD.equals(enteredPassword)) {
                statusLabel.setText("Access Granted");
                
                GameData debugData = createDebugGameData(5); 
                gameManager.switchToGameModeScreen(debugData);
                statusLabel.setText("Access Denied");
            }
        });
    }
    
    private GameData createDebugGameData(int totalLevels) {
        ArrayList<Integer> levelsCompleted = new ArrayList<>();
        for (int i = 1; i <= totalLevels; i++) {
            levelsCompleted.add(i);
        }
        
        return new GameData("DebugPlayer", 9999, 0, totalLevels, levelsCompleted);
    }
}

