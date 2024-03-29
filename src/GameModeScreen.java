import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	public GameModeScreen()	{
		
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
        
        JButton backToMain = new JButton();
		ImageIcon backIcon = new ImageIcon("back.png");
		backToMain.setIcon(backIcon);
		backToMain.setBounds(10, 10, 60, 60);
		backToMain.setBackground(null);
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
        
        menuOptions = new ArrayList<JButton>();
        
        menuOptions.add(new JButton("Classic"));
        menuOptions.add(new JButton("Theme-Based"));
        menuOptions.add(new JButton("My Question Set"));
        menuOptions.add(new JButton("Create Question Set"));
        
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
