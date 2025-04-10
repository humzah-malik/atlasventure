import javax.swing.*;
/**
 * Represents a generic game screen within the application. This abstract class
 * provides the structure for game screens, including initialization, activation,
 * updating, and deactivation of the screen. Implementing classes are responsible
 * for defining the specific behavior of these operations.
 * 
 * <p>The GameScreen class serves as a base for all specific screen types in the
 * game, such as menus, level selection screens, and actual game levels. It
 * extends {@link JPanel}, allowing each screen to be treated as a GUI component
 * that can be added to the game's window.</p>
 * 
 * <p>Usage of this class involves extending it and providing implementations for
 * the abstract methods defined within. This setup allows for a flexible
 * foundation that can accommodate various game screens with unique behaviors
 * and visuals.</p>
 * 
 * @version 1.0
 * @author Ali Mohamed
 */
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
