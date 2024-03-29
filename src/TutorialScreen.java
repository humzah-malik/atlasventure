import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class TutorialScreen extends GameScreen {
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private ArrayList<JButton> answerOptions;
	private GameManager gameManager;

	public TutorialScreen(GameManager gameManager)	{
		gameManager = this.gameManager;
		initialize();

	}

	@Override
	protected void initialize() {
		
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
		options.setOpaque(false);
		options.setContentAreaFilled(false);
		options.setBorderPainted(false);
		options.setToolTipText("<html>Use this menu to pause the game. <br/>From there, you can either continue<br/>or exit back to level selection.</html>");
		this.add(options);
		
		JButton score = new JButton();
		score.setIcon(optionsIcon);
		score.setBounds(550, 10, 60, 60);
		options.setOpaque(false);
		options.setContentAreaFilled(false);
		options.setBorderPainted(false);
		score.setToolTipText("<html>This is your score.<br/>You will be awarded points<br/>for each correct answer.</html>");
		this.add(score);
		
		JButton hintsLeft = new JButton();
		hintsLeft.setIcon(optionsIcon);
		hintsLeft.setBounds(700, 40, 60, 60);
		hintsLeft.setBackground(null);
		hintsLeft.setToolTipText("<html>This is the amount<br/>of hints you have left.</html>");
		this.add(hintsLeft);
		
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
