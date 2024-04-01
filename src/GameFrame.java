
import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	public GameFrame() {
		MainMenuScreen mainMenu = new MainMenuScreen(null);
		HighScoreScreen highScores = new HighScoreScreen(null, null);
		//GameplayScreen gameplay = new GameplayScreen();
		InstructorDashboardScreen dashboard = new InstructorDashboardScreen(null);
		GameModeScreen gameMode = new GameModeScreen(null, null);
		TutorialScreen tutorial = new TutorialScreen(null);
		
//		this.add(mainMenu);
//		this.add(highScores);
//		this.add(gameplay);
//		this.add(dashboard);
//		this.add(gameMode);
		this.add(tutorial);
		
		this.setTitle("AtlasVenture");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
}