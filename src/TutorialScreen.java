import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The `TutorialScreen` class extends `GameScreen` and provides a tutorial interface with various
 * buttons and tooltips for a game.
 * 
 * @author Ali Mohamed
 * @author Nikunj Patel
 */
public class TutorialScreen extends GameScreen {
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	//private ArrayList<JButton> answerOptions;
	private GameManager gameManager;

	// The `public TutorialScreen(GameManager gameManager)` constructor in the `TutorialScreen` class is
	// initializing a new instance of the `TutorialScreen` with a reference to the `GameManager` object
	// that is passed as a parameter. It sets the `gameManager` field of the `TutorialScreen` to the
	// provided `gameManager` object. Additionally, it calls the `initialize()` method to set up the
	// tutorial screen interface with buttons, tooltips, and images.
	public TutorialScreen(GameManager gameManager)	{
		this.gameManager = gameManager;
		initialize();

	}

	/**
	 * The `initialize` method sets up a graphical user interface for a game screen with buttons and
	 * tooltips.
	 */
	@Override
	protected void initialize() {
		
		JButton backToMain = new JButton();
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back.png"));
		backToMain.setIcon(backIcon);
		backToMain.setBounds(5, 540, 60, 60);
		backToMain.setBackground(null);
		backToMain.setBorderPainted(false); 
		backToMain.setContentAreaFilled(false); 
		backToMain.setActionCommand("back");
		backToMain.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        handleInput(e.getActionCommand()); 
    }
		});
	this.add(backToMain);

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.gray);
		this.setFocusable(true);
		this.setLayout(null);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/gameplay.png"));
		JLabel image = new JLabel(icon);
		image.setBounds(0,0,800,600);
		this.add(image);
		
		ImageIcon optionsIcon = new ImageIcon(getClass().getResource("/images/question.png"));
		
		ToolTipManager.sharedInstance().setInitialDelay(0);

		
		JButton options = new JButton();
		options.setIcon(optionsIcon);
		options.setBounds(70, 10, 60, 60);
		options.setBackground(null);
		options.setToolTipText("<html>Use this menu to pause the game. <br/>From there, you can either continue<br/>or exit back to level selection.</html>");
		this.add(options);
		
		JButton score = new JButton();
		score.setIcon(optionsIcon);
		score.setBounds(550, 10, 60, 60);
		score.setBackground(null);
		score.setToolTipText("<html>This is your score.<br/>You will be awarded points<br/>for each correct answer.</html>");
		this.add(score);
		
		//JButton hintsLeft = new JButton();
		//hintsLeft.setIcon(optionsIcon);
		//hintsLeft.setBounds(700, 40, 60, 60);
		//hintsLeft.setBackground(null);
		//hintsLeft.setToolTipText("<html>This is the amount<br/>of hints you have left.</html>");
		//this.add(hintsLeft);
		
		JButton location = new JButton();
		location.setIcon(optionsIcon);
		location.setBounds(370, 195, 60, 60);
		location.setBackground(null);
		location.setToolTipText("<html>This is the location that<br/>you must guess using one<br/>of the options below.</html>");
		this.add(location);
		
		JButton answer = new JButton();
		answer.setIcon(optionsIcon);
		answer.setBounds(370, 470, 60, 60);
		answer.setBackground(null);
		answer.setToolTipText("<html>Pick one of the options.<br/>Correct answers award points<br/>Fun fact displayed after answer.</html>");
		this.add(answer);
		
		JButton hint = new JButton();
		hint.setIcon(optionsIcon);
		hint.setBounds(475, 540, 60, 60);
		hint.setBackground(null);
		hint.setToolTipText("<html>This will give you<br/>a hint about the location.<br/>You have a set number of hints.</html>");
		this.add(hint);
		
		this.setComponentZOrder(options, 0);
		this.setComponentZOrder(score, 0);
		//this.setComponentZOrder(hintsLeft, 0);
		this.setComponentZOrder(location, 0);
		this.setComponentZOrder(answer, 0);
		this.setComponentZOrder(hint, 0);

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

	/**
	 * The handleInput function checks if the actionCommand is "back" and changes the game state to
	 * "MAIN_MENU" while playing a button click sound.
	 * 
	 * @param actionCommand The `actionCommand` parameter in the `handleInput` method is a string that
	 * represents the action triggered by the user. In this specific code snippet, the method checks if
	 * the `actionCommand` is equal to "back" and if so, it plays a button click sound using the `Audio
	 */
	@Override
	protected void handleInput(String actionCommand) {
		if ("back".equals(actionCommand)) {
			AudioManager.getInstance().playButtonClickSound();
			gameManager.changeGameState("MAIN_MENU"); 
		}
	}
	
}
