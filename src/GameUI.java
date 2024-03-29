//GameUI.java

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GameUI extends JFrame {
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton saveButton;
    private JButton loadButton;
    private JTextArea gameDataDisplay;

    public GameUI() {
        setTitle("Game UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        gameDataDisplay = new JTextArea();
        gameDataDisplay.setEditable(false);

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Username:"));
        topPanel.add(usernameField);
        topPanel.add(new JLabel("Password:"));
        topPanel.add(passwordField);
        topPanel.add(saveButton);
        topPanel.add(loadButton);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(gameDataDisplay), BorderLayout.CENTER);

        saveButton.addActionListener(new SaveButtonListener());
        loadButton.addActionListener(new LoadButtonListener());
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            if (!username.isEmpty()) {
                GameData gameData = new GameData();
                gameData.setPlayerUsername(username);
                String password = GameDataManager.toSHA1(passwordField.getText());
                gameData.setPassword(password);

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save Game Data");
                int userSelection = fileChooser.showSaveDialog(GameUI.this);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    String filePath = fileToSave.getAbsolutePath();
                    HashMap < String, GameData > gameDataMap = GameDataManager
                            .loadGameData(GameDataManager.getCorrectJSONPath(filePath));
                    if (gameDataMap == null)
                        gameDataMap = new HashMap < > ();
                    gameDataMap.put(usernameField.getText(), gameData);
                    GameDataManager.saveGameData(gameDataMap, filePath);
                    gameDataDisplay.setText("Game data saved for user: " + username + " to file: " + filePath);
                } else {
                    gameDataDisplay.setText("Save operation cancelled by user.");
                }
            } else {
                gameDataDisplay.setText("Please enter a username.");
            }
        }
    }

    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String password = GameDataManager.toSHA1(passwordField.getText());

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON Files", "json");
            fileChooser.setFileFilter(filter);
            fileChooser.setDialogTitle("Load Game Data");

            int userSelection = fileChooser.showOpenDialog(GameUI.this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToLoad = fileChooser.getSelectedFile();
                String filePath = fileToLoad.getAbsolutePath();
                Map < String, GameData > gameDataMap = GameDataManager
                        .loadGameData(GameDataManager.getCorrectJSONPath(filePath));
                if (gameDataMap != null) {
                    GameData gameData = gameDataMap.get(usernameField.getText());
                    boolean path = gameData != null;
                    boolean correctPassword = true;
                    if (path)
                        correctPassword = gameData.getPassword().equals(password);
                    if (path && correctPassword) {
                        gameDataDisplay.setText("Game data loaded for user: " + gameData.getPlayerUsername() + "\n" +
                                "Score: " + gameData.getScore() + "\n" +
                                "Hints Used: " + gameData.getHintsUsed() + "\n" +
                                "Level Completed: " + gameData.getLevelCompleted() + "\n" +
                                "Levels Left: " + gameData.getLevelsLeft());
                    } else
                    if (!correctPassword) {
                        gameDataDisplay.setText("Incorrect Password");
                    } else {
                        if (passwordField.getText().isEmpty() || usernameField.getText().isEmpty()) {
                            gameDataDisplay.setText("You cannot load a game without entering the correct credentials");
                        } else
                            gameDataDisplay.setText("No game data found for this user");
                    }

                }
            }
            else {
                gameDataDisplay.setText("Load operation cancelled by user.");
            }
        }
    }
}