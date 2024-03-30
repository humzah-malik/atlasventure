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
        backToMain.addActionListener(e -> gameManager.changeGameState("MAIN_MENU"));
        this.add(backToMain);
        
        JLabel playModes = new JLabel("Play");
        playModes.setHorizontalAlignment(JLabel.CENTER); 
        playModes.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        playModes.setForeground(Color.black);
        playModes.setSize(150, 50);
        playModes.setLocation((SCREEN_WIDTH - playModes.getWidth()) / 2, 120);
        this.add(playModes);
        
        JLabel createMode = new JLabel("Create");
        createMode.setHorizontalAlignment(JLabel.CENTER); 
        createMode.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        createMode.setForeground(Color.black);
        createMode.setSize(150, 50);
        createMode.setLocation((SCREEN_WIDTH - createMode.getWidth()) / 2, 400);
        this.add(createMode);
        
        menuOptions = new ArrayList<>();
    
    JButton classicButton = new JButton("Classic");
    JButton themeBasedButton = new JButton("Theme-Based");
    JButton myQuestionSetButton = new JButton("My Question Set");
    JButton createQuestionSetButton = new JButton("Create Question Set");
    
    menuOptions.add(classicButton);
    menuOptions.add(themeBasedButton);
    menuOptions.add(myQuestionSetButton);
    menuOptions.add(createQuestionSetButton);
    
    // Define the action commands for each button
    classicButton.setActionCommand("LEVEL_SELECT");
    themeBasedButton.setActionCommand("THEME_BASED_MODE");
    myQuestionSetButton.setActionCommand("MY_QUESTION_SET");
    createQuestionSetButton.setActionCommand("CREATE_QUESTION_SET");
    
    // Add a single ActionListener for all buttons and handle based on action command
    ActionListener buttonListener = e -> {
        String command = e.getActionCommand();
        switch (command) {
            case "LEVEL_SELECT":
                gameManager.switchToLevelSelectionScreen(playerData);
                break;
            case "THEME_BASED_MODE":
                gameManager.changeGameState("THEME_BASED_MODE");
                break;
            case "MY_QUESTION_SET":
                gameManager.changeGameState("MY_QUESTION_SET");
                break;
            case "CREATE_QUESTION_SET":
                gameManager.changeGameState("CREATE_QUESTION_SET");
                break;
        }
    };
    
    // Assign the listener to each button
    classicButton.addActionListener(buttonListener);
    themeBasedButton.addActionListener(buttonListener);
    myQuestionSetButton.addActionListener(buttonListener);
    createQuestionSetButton.addActionListener(buttonListener);
        
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
