import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ThemeBasedModeSelectionScreen extends GameScreen {

    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    private ArrayList<JButton> themeOptions;
    private GameManager gameManager;
    private GameData playerData;

    public ThemeBasedModeSelectionScreen(GameManager gameManager, GameData currentPlayerData) {
        this.gameManager = gameManager;
        this.playerData = currentPlayerData;
        initialize();
    }

    @Override
    protected void initialize() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.setLayout(null);

        JLabel title = new JLabel("Select Theme");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setForeground(Color.black);
        title.setSize(400, 100);
        title.setLocation((SCREEN_WIDTH - title.getWidth()) / 2, 0);
        this.add(title);

        JButton backToMain = new JButton(new ImageIcon(getClass().getResource("/images/back.png")));
        backToMain.setBounds(10, 10, 60, 60);
        backToMain.setBackground(null);
        backToMain.setBorderPainted(false);
        backToMain.setContentAreaFilled(false);
        backToMain.addActionListener(e ->{ 
            gameManager.switchToGameModeScreen(playerData);
            AudioManager.getInstance().playButtonClickSound();
        });
        this.add(backToMain);

        themeOptions = new ArrayList<>();

        JButton landmarksButton = new JButton("Landmarks");
        JButton languagesButton = new JButton("Traditional Clothing");
        JButton cultureButton = new JButton("Culture/Traditions");

        themeOptions.add(landmarksButton);
        themeOptions.add(languagesButton);
        themeOptions.add(cultureButton);

        for (int i = 0, y = 180; i < themeOptions.size(); i++, y += 80) {
            JButton currentButton = themeOptions.get(i);
            currentButton.setBounds(250, y, 300, 50);
            currentButton.setBackground(Color.white);
            currentButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            currentButton.addActionListener(new ThemeModeActionListener(gameManager, currentButton.getText()));
            this.add(currentButton);
        }
    }

    @Override
    public void updateScreen() {
        repaint();
    }

    @Override
    public void activate() {
        this.setVisible(true);
    }

    @Override
    public void deactivate() {
        this.setVisible(false);
    }

    @Override
    protected void handleInput(String actionCommand) {
    }

    private class ThemeModeActionListener implements ActionListener {
        private final GameManager gameManager;
        private final String themeMode;

        public ThemeModeActionListener(GameManager gameManager, String themeMode) {
            this.gameManager = gameManager;
            this.themeMode = themeMode;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AudioManager.getInstance().playButtonClickSound();
            System.out.println("Selected theme mode: " + themeMode);
        }
    }
}

