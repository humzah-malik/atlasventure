import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends GameScreen {
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private int selectedOption;
	private ArrayList<JButton> menuOptions;
	private GameManager gameManager;
	
	public MainMenuScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();

	}
	
	

    @Override
	protected void initialize() {
		
		
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
		
		menuOptions = new ArrayList<JButton>();

        String[] options = {"New Game", "Load Saved Game", "Tutorial", "High Scores", 
                            "Instructor Dashboard", "Debug Mode", "Exit"};
    
        for (String option : options) {
            JButton button = new JButton(option);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
                gameManager.changeGameState("HIGH_SCORES");
                break;
            case "Instructor Dashboard":
                gameManager.changeGameState("INSTRUCTOR");
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
