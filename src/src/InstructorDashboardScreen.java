import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class InstructorDashboardScreen extends GameScreen {
    
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    private GameManager gameManager;
    private final String INSTRUCTOR_PASSWORD = "123"; // Set your password here.
    private JPanel contentPanel;
    

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

    private boolean verifyPassword() {
        JPasswordField pf = new JPasswordField();
        int ok = JOptionPane.showConfirmDialog(null, pf, "Enter Instructor Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        return ok == JOptionPane.OK_OPTION && INSTRUCTOR_PASSWORD.equals(new String(pf.getPassword()));
    }

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
