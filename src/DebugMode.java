import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DebugMode extends JPanel {
    private final String DEBUG_PASSWORD = "123";
    private GameManager gameManager;

    public DebugMode(GameManager gameManager) {
        this.gameManager = gameManager;
        initialize();
    }

    private void initialize() {
        
        setLayout(new FlowLayout());

        JButton backButton = new JButton("back");
        add(backButton);

        JLabel passwordLabel = new JLabel("Enter Debug Password:");
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(10);
        add(passwordField);

        JButton enterButton = new JButton("Enter");
        add(enterButton);

        JLabel statusLabel = new JLabel(" ");
        add(statusLabel);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPassword = new String(passwordField.getPassword());
                if (DEBUG_PASSWORD.equals(enteredPassword)) {
                    statusLabel.setText("Access Granted");
                    // Assuming you have 5 levels, for example
                    GameData debugData = createDebugGameData(5); // Creates a GameData instance with all levels unlocked
                    gameManager.switchToDebugLevelSelection(debugData); // A new method in GameManager for this purpose
                } else {
                    statusLabel.setText("Access Denied");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    gameManager.changeGameState("MAIN_MENU");
              
            }
        });
    }
    
    private GameData createDebugGameData(int totalLevels) {
    ArrayList<Integer> levelsLeft = new ArrayList<>();
    for (int i = 1; i <= totalLevels; i++) {
        levelsLeft.add(i); // Assuming levels are numbered starting from 1
    }
    // Set high numbers to ensure all levels are unlocked and considered "completed"
    return new GameData("DebugPlayer", 9999, 0, totalLevels, levelsLeft);
}
}
