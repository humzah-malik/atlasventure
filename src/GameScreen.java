import javax.swing.*;

public abstract class GameScreen extends JPanel {
	
    /**
     * Initializes the screen. This method should set up the initial state and UI components.
     */
    protected abstract void initialize();

    /**
     * Updates the screen's content. This method is called periodically to refresh the screen's content
     * based on game state or user interactions.
     */
    public abstract void updateScreen();

    /**
     * Activates the screen. This method is called when the screen becomes the active screen being displayed.
     */
    public abstract void activate();

    /**
     * Deactivates the screen. This method is called when the screen is no longer the active screen being displayed.
     */
    public abstract void deactivate();

    /**
     * Handles user input. This method processes user inputs, such as keyboard strokes or mouse clicks,
     * and takes appropriate actions based on the input.
     */
    protected abstract void handleInput(String actionCommand);
}
