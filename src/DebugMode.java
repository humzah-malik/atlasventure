import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebugMode extends JPanel {
    private final String DEBUG_PASSWORD = "devPassword123";
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
                    gameManager.changeGameState("MAIN_MENU");
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
}
