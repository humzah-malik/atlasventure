
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Represents a game mode selection screen where players can choose between different types of game modes.
 * Extends the GameScreen to utilize common functionalities and UI standards for game screens.
 *
 * @version 1.0
 * @author Ali Mohamed
 */

public class GameModeScreen extends GameScreen {
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private ArrayList<JButton> menuOptions;
	private GameManager gameManager;
	private GameData playerData;
	public GameModeScreen(GameManager gameManager, GameData playerData)	{
		this.playerData = playerData;
		this.gameManager = gameManager;
		initialize();
		
	}
	
	/**
	 * The `initialize` method sets up a game options screen with title, buttons for different play modes,
	 * and button actions to switch game states.
	 */
	@Override
	protected void initialize() {
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.gray);
		this.setFocusable(true);
		this.setLayout(null);
		
		JLabel title = new JLabel("Game Options");
		title.setHorizontalAlignment(JLabel.CENTER); 
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
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
            gameManager.changeGameState("MAIN_MENU");
            AudioManager.getInstance().playButtonClickSound();
        });
        this.add(backToMain);
        
        JLabel playModes = new JLabel("Play");
        playModes.setHorizontalAlignment(JLabel.CENTER); 
        playModes.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        playModes.setForeground(Color.black);
        playModes.setSize(150, 50);
        playModes.setLocation((SCREEN_WIDTH - playModes.getWidth()) / 2, 120);
        this.add(playModes);
        
        
        menuOptions = new ArrayList<>();
    
    JButton classicButton = new JButton("Classic");
    JButton themeBasedButton = new JButton("Theme-Based");
    
    menuOptions.add(classicButton);
    menuOptions.add(themeBasedButton);
    
    // Define the action commands for each button
    classicButton.setActionCommand("LEVEL_SELECT");
    themeBasedButton.setActionCommand("THEME_MODE");
    
    // Add a single ActionListener for all buttons and handle based on action command
    ActionListener buttonListener = e -> {
        String command = e.getActionCommand();
        AudioManager.getInstance().playButtonClickSound();
        switch (command) {
            case "LEVEL_SELECT":
                gameManager.switchToLevelSelectionScreen(playerData);
                break;
            case "THEME_MODE":
                gameManager.switchToThemeBasedModeSelectionScreen(playerData);
                break;
        }
    };
    
    classicButton.addActionListener(buttonListener);
    themeBasedButton.addActionListener(buttonListener);
        
        for(int i = 0, y = 180; i < menuOptions.size(); i++, y+=60) {
			JButton currentButton = menuOptions.get(i);
	        Border blackBorder = BorderFactory.createLineBorder(Color.black, 3);
	        currentButton.setBorder(blackBorder);
	        
	        if(i == 3) {
	        	currentButton.setBounds(250,460,300,50);
	        }
	        else {
	        	currentButton.setBounds(250,y,300,50);
	        }
			currentButton.setBackground(Color.white);
			currentButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
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

}
