import javax.swing.JFrame;

/**
 * The `GameFrame` class in Java initializes screens for a game application and sets up the frame for
 * the game.
 */
public class GameFrame extends JFrame {
	
	// The `public GameFrame()` method is a constructor for the `GameFrame` class in Java. Inside this
	// constructor, several screens for a game application are being initialized:
	// The `public GameFrame()` method is a constructor for the `GameFrame` class in Java. Inside this
	// constructor, several screens for a game application are being initialized:
	// The `public GameFrame()` method is a constructor for the `GameFrame` class in Java. Inside this
	// constructor, several screens for a game application are being initialized:
	public GameFrame() {
		MainMenuScreen mainMenu = new MainMenuScreen(null);
		HighScoreScreen highScores = new HighScoreScreen(null, null);
		//GameplayScreen gameplay = new GameplayScreen();
		InstructorDashboardScreen dashboard = new InstructorDashboardScreen(null);
		GameModeScreen gameMode = new GameModeScreen(null, null);
		TutorialScreen tutorial = new TutorialScreen(null);
		
		this.add(tutorial);
		
		this.setTitle("AtlasVenture");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
}