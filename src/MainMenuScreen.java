import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The `MainMenuScreen` class in Java represents the main menu screen of a game with various menu
 * options and functionality.
 * 
 * @author Ali Mohamed
 * @author Nikunj Patel
 */
public class MainMenuScreen extends GameScreen {
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private int selectedOption;
	private ArrayList<JButton> menuOptions;
	private GameManager gameManager;

	
	// The `public MainMenuScreen(GameManager gameManager)` constructor in the `MainMenuScreen` class is
    // initializing a new instance of the `MainMenuScreen` with a reference to a `GameManager` object. It
    // sets the `gameManager` field of the `MainMenuScreen` to the provided `gameManager` parameter and
    // then calls the `initialize()` method to set up the main menu screen with various components such as
    // buttons, labels, and event listeners.
    public MainMenuScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();

	}
	
	

    /**
     * The `initialize` method sets up the main menu interface with buttons for various options, music
     * controls, project details, and background image.
     */
    @Override
	protected void initialize() {
		
		AudioManager.getInstance().playMenuMusic();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.gray);
		this.setFocusable(true);
		this.setLayout(null);
		
		JLabel title = new JLabel("AtlasVenture");
		title.setHorizontalAlignment(JLabel.CENTER); 
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		title.setForeground(Color.white);
		title.setSize(400, 100);
        title.setLocation((SCREEN_WIDTH - title.getWidth()) / 2, 0);
        this.add(title); 
		
        JButton musicoff = new JButton(new ImageIcon(getClass().getResource("/images/music-off.png")));
        musicoff.setBounds(-5, 10, 60, 60);
        musicoff.setBackground(null);
        musicoff.setBorderPainted(false);
        musicoff.setContentAreaFilled(false);
        musicoff.addActionListener(e ->{ 
            AudioManager.getInstance().stopMenuMusic();
            AudioManager.getInstance().stopGameplayMusic();
            AudioManager.getInstance().playButtonClickSound();
        });
        this.add(musicoff);

        JButton musicon = new JButton(new ImageIcon(getClass().getResource("/images/music-on.png")));
        musicon.setBounds(45, 10, 60, 60);
        musicon.setBackground(null);
        musicon.setBorderPainted(false);
        musicon.setContentAreaFilled(false);
        musicon.addActionListener(e ->{ 
            AudioManager.getInstance().playMenuMusic();
            AudioManager.getInstance().playButtonClickSound();
        });
        this.add(musicon);

		menuOptions = new ArrayList<JButton>();

        String[] options = {"New Game", "Load Saved Game", "Tutorial", "High Scores", 
                            "Instructor Dashboard", "Debug Mode", "Exit"};
    
        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AudioManager.getInstance().playButtonClickSound();
                    handleInput(e.getActionCommand());
                    
                }
            });
            button.setBounds(25, 115 + 60 * menuOptions.size(), 300, 50);
            button.setBackground(Color.white);
            button.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            this.add(button);
            menuOptions.add(button);
        }
		
		String paragraph = "<html>Team 43<br/>"
                + "Ali, Het, Nikunj, Hamza, Prabnoor<br/>"
                + "Winter 2024<br/>"
                + "CS2212 Western University</html>";
        JLabel projectDetails = new JLabel(paragraph);
        projectDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        projectDetails.setForeground(Color.WHITE);
        projectDetails.setSize(250, 100);
        projectDetails.setLocation(600, 500);
        this.add(projectDetails);
        
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/earth.jpg"));
		JLabel image = new JLabel(icon);
		image.setBounds(100,0,700,600);
		this.add(image);
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
	
	public void selectNextOption() {
        selectedOption = (selectedOption + 1) % menuOptions.size();
        updateScreen();
    }

    public void selectPreviousOption() {
        selectedOption = (selectedOption - 1 + menuOptions.size()) % menuOptions.size();
        updateScreen();
    }

	
	/**
     * The handleInput method processes different action commands to change game states, show high scores,
     * display instructor dashboard, enable debug mode, or close the game.
     * 
     * @param actionCommand The `handleInput` method takes a parameter `actionCommand` which represents
     * the action to be performed in the game. The method checks the value of `actionCommand` and performs
     * different actions based on its value. The possible values for `actionCommand` in this case are "New
     * Game", "
     */
    protected void handleInput(String actionCommand) {
		if (gameManager == null) {
            System.err.println("GameManager is not initialized.");
            return;
        }
    
        switch (actionCommand) {
            case "New Game":
                gameManager.changeGameState("NEW_GAME");
                break;
            case "Load Saved Game":
                gameManager.changeGameState("LOAD_GAME");
                break;
            case "Tutorial":
                gameManager.changeGameState("TUTORIAL");
                break;
            case "High Scores":
                gameManager.showHighScores();
                break;
            case "Instructor Dashboard":
                gameManager.showInstructorDashboard();
                break;
            case "Debug Mode":
                gameManager.changeGameState("DEBUG_MODE");
                break;
            case "Exit":
                gameManager.closeGame();
                break;
            default:
                System.err.println("Unrecognized action command: " + actionCommand);
                break;
        }
	}



	
	
	

}
