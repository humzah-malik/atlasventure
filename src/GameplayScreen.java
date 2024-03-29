import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class GameplayScreen extends GameScreen{
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private ArrayList<JButton> answerOptions;
	private int playerScore;
	
	public GameplayScreen() {
		
		initialize();
		
	}
	
	@Override
	protected void initialize() {
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.gray);
		this.setFocusable(true);
		this.setLayout(null);
		
		JLabel score = new JLabel("Score: 40");
		score.setHorizontalAlignment(JLabel.CENTER); 
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		score.setForeground(Color.black);
		score.setSize(400, 75);
		score.setLocation((SCREEN_WIDTH - score.getWidth()) / 2, 0);
        this.add(score); 
        
        JLabel hintsLeft = new JLabel("Hints left: 3");
        hintsLeft.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        hintsLeft.setForeground(Color.black);
        hintsLeft.setBounds(680, 10, 120, 30);
		this.add(hintsLeft);
        
        JButton options = new JButton();
		ImageIcon optionsIcon = new ImageIcon("options.png");
		options.setIcon(optionsIcon);
		options.setBounds(10, 10, 60, 60);
		options.setBackground(null);
		this.add(options);
		
		Border blackBorder = BorderFactory.createLineBorder(Color.black, 3);
		
		ImageIcon colosseum = new ImageIcon("colosseum.jpeg");
		JLabel location = new JLabel(colosseum);
		location.setBounds(175, 75, 450, 300);
		location.setBorder(blackBorder);
		this.add(location);
        
		JLabel question = new JLabel("What is the location in the image?");
		question.setBounds(150, 385, 500, 40);
		question.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		question.setForeground(Color.black);
		question.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(question);
		
        answerOptions = new ArrayList<JButton>();
        answerOptions.add(new JButton("Option 1"));
        answerOptions.add(new JButton("Option 2"));
        answerOptions.add(new JButton("Option 3"));
        answerOptions.add(new JButton("Option 4"));
		
		for(int i = 0, y = 435; i < answerOptions.size(); i+=1, y+=32.5) {
			JButton currentButton = answerOptions.get(i);
			
			if(i % 2 == 0) {
				currentButton.setBounds(60, y, 300, 50);
				JButton nextButton = answerOptions.get(i+1);
				nextButton.setBounds(440, y, 300, 50);
			}
	        
			currentButton.setBorder(blackBorder);
			currentButton.setBackground(Color.white);
			currentButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			this.add(currentButton);
		}
        
		ImageIcon hint = new ImageIcon("bulb.png");
		JButton useHint = new JButton("Use Hint", hint);
		useHint.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		useHint.setBounds(325, 565, 150, 30);
		useHint.setBackground(null);
		this.add(useHint);
        
		
		
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
	
	public void pauseGame() {
		
	}
	
	public void resumeGame() {
		
	}
	
	public void endGame() {
		
	}
	
	@Override
	protected void handleInput(String actionCommand) {
	}

}
