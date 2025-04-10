
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameManagerTest {

    private GameManager gameManager;

    @Before public void setUp() {
        gameManager = new GameManager();
    }

    @After
    public void tearDown() {
        gameManager.closeGame();
    }

    @Test
    public void testInitialStateMainMenu() {
        assertEquals("After initialization, the game state should be 'MAIN_MENU'", "MAIN_MENU", gameManager.getCurrentState());
    }

    @Test
    public void testChangeGameState_NewGame() {
        gameManager.changeGameState("NEW_GAME");
        assertEquals("The game state should change to 'NEW_GAME'", "NEW_GAME", gameManager.getCurrentState());
    }
    
    @Test
    public void testChangeGameState_LoadGame() {
        gameManager.changeGameState("LOAD_GAME");
        assertEquals("The game state should change to 'LOAD_GAME'", "LOAD_GAME", gameManager.getCurrentState());
    }

    @Test public void testChangeGameState_DebugMode() {
        gameManager.changeGameState("DEBUG_MODE");
        assertEquals("The game state should change to 'DEBUG_MODE'", "DEBUG_MODE", gameManager.getCurrentState());
    }

    @Test
    public void testChangeGameState_InvalidState() {
        gameManager.changeGameState("INVALID_STATE");
        assertNotNull("After attempting to change to an invalid state, currentState should not be null", gameManager.getCurrentState());
    }

    @Test(expected = NullPointerException.class)
    public void testSwitchToLevelSelectionScreen_NullPlayerData() {
        gameManager.switchToLevelSelectionScreen(null);
    }

    @Test(expected = NullPointerException.class)
    public void testSwitchToGameModeScreen_NullPlayerData() {
        gameManager.switchToGameModeScreen(null);
    }

    @Test public void testCloseGame() {
        gameManager.closeGame();
        // Expected behavior: game window is closed, program exits. Can't assert this with JUnit directly.
    }

    // This is just a sample test. The GameManager might not directly reveal all state changes or // expose components for direct testing. Adjustments in the GameManager's design might be needed
    // to make it more testable (e.g., getter methods for state, or events that can be listened to // for UI changes).
}
