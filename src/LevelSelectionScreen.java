import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class LevelSelectionScreen extends GameScreen {
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private ArrayList<JButton> menuOptions;
	private String gameMode;
	GameManager gameManager;
	
	public LevelSelectionScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		//this.gameMode = selectedGameMode;
		initialize();
		
	}

	@Override
	protected void initialize() {
	    this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	    this.setBackground(Color.gray);
	    this.setFocusable(true);
	    this.setLayout(null); // Consider using a layout manager for more complex layouts
	    
	    JLabel title = new JLabel(gameMode);
		title.setHorizontalAlignment(JLabel.CENTER); 
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		title.setForeground(Color.black);
		title.setSize(400, 100);
        title.setLocation((SCREEN_WIDTH - title.getWidth()) / 2, 0);
        this.add(title);
	    
	    ImageIcon backIcon = new ImageIcon("back.png"); // Make sure this icon file exists
	    JLabel backLabel = new JLabel(backIcon); // Changed to JLabel to display the icon only
	    backLabel.setBounds(10, 10, backIcon.getIconWidth(), backIcon.getIconHeight());
	    this.add(backLabel);

	    menuOptions = new ArrayList<JButton>();

	    ImageIcon lock = new ImageIcon("lock.png"); // Make sure this icon file exists
	    ImageIcon unlock = new ImageIcon("unlock.png"); // Make sure this icon file exists

	    // The X position for the icons and buttons needs to be calculated based on their widths
	    int iconX = (SCREEN_WIDTH - 300) / 2 - lock.getIconWidth() - 10; // 10 is the spacing between the icon and button
	    int buttonX = iconX + lock.getIconWidth() + 10;

	    for (int i = 0, y = 160; i < 5; i++, y += 60) {
	        ImageIcon icon = i == 0 ? lock : unlock;
	        JLabel iconLabel = new JLabel(icon);
	        iconLabel.setBounds(iconX, y + (50 - icon.getIconHeight()) / 2, icon.getIconWidth(), icon.getIconHeight());
	        this.add(iconLabel);

	        JButton currentButton = new JButton("Level " + (i + 1));
	        Border blackBorder = BorderFactory.createLineBorder(Color.black, 3);
	        currentButton.setBorder(blackBorder);
	        currentButton.setBounds(buttonX, y, 300, 50);
	        currentButton.setHorizontalAlignment(SwingConstants.CENTER); // This centers the text in the button
	        currentButton.setBackground(Color.white);
	        currentButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
	        this.add(currentButton);
	        menuOptions.add(currentButton); // Store the button
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'handleInput'");
	}
	
	
	
}