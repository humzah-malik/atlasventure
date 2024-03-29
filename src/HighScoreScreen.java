import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class HighScoreScreen extends GameScreen {

	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private GameManager gameManager;
	
	public HighScoreScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();
		
	}
	
	@Override
	protected void initialize() {
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.gray);
		this.setFocusable(true);
		this.setLayout(null);
		
		JLabel title = new JLabel("High Scores");
		title.setHorizontalAlignment(JLabel.CENTER); 
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		title.setForeground(Color.black);
		title.setSize(400, 100);
        title.setLocation((SCREEN_WIDTH - title.getWidth()) / 2, 0);
        this.add(title); 
        
        JPanel greyPanel = new JPanel();
        greyPanel.setBackground(Color.white);
        greyPanel.setBounds(100, 150, 600, 400);
        greyPanel.setLayout(null);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.black, 5);
        greyPanel.setBorder(blackBorder);
        
        ArrayList<JLabel> leaderboardHeaders = new ArrayList<JLabel>();
        JLabel number = new JLabel("#");
        JLabel name = new JLabel("Name");
        JLabel score = new JLabel("Score");
        
        leaderboardHeaders.add(number);
        leaderboardHeaders.add(name);
        leaderboardHeaders.add(score);
        
		for(int i = 0, x = 50; i < leaderboardHeaders.size(); i++, x += 200) {
			JLabel currentLabel = leaderboardHeaders.get(i);
			currentLabel.setHorizontalAlignment(JLabel.CENTER); 
			currentLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
			currentLabel.setForeground(Color.black);
			currentLabel.setSize(100, 50);
			currentLabel.setLocation(x, 25);
			greyPanel.add(currentLabel);
		}
		
		this.add(greyPanel);
		
		JButton backToMain = new JButton();
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back.png"));
		backToMain.setIcon(backIcon);
		backToMain.setBounds(10, 10, 60, 60);
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

	
	protected void handleInput(String actionCommand) {
		if ("back".equals(actionCommand)) {
			gameManager.changeGameState("MAIN_MENU"); 
		}
		
	}
	

}


