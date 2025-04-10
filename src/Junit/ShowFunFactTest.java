import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ShowFunFactTest {

    private QuizGame game;

    @Before
    public void setUp() {
        game = new QuizGame();
        // Initialize necessary fields if there are any
        game.currentLevelData.funFacts = new String[]{"Fun fact for question 1", "Fun fact for question 2"};
    }

    @Test
    public void testShowFunFactCorrectAnswer() {
        // Setup for a correct answer scenario
        boolean isCorrect = true;
        int questionIndex = 0;
        String correctAnswer = "A";

        game.showFunFact(isCorrect, questionIndex, correctAnswer);

        // Assuming we have a way to capture the message that would have been shown
        String expectedMessage = "Correct!\nFun Fact: Fun fact for question 1";
        assertEquals("The fun fact message for a correct answer should match", expectedMessage, game.lastShownMessage);
    }

    @Test
    public void testShowFunFactIncorrectAnswer() {
        // Setup for an incorrect answer scenario
        boolean isCorrect = false;
        int questionIndex = 1;
        String correctAnswer = "B";

        game.showFunFact(isCorrect, questionIndex, correctAnswer);

        // Assuming we have a way to capture the message that would have been shown
        String expectedMessage = "Incorrect. The correct answer is B.\nFun Fact: Fun fact for question 2";
        assertEquals("The fun fact message for an incorrect answer should match", expectedMessage, game.lastShownMessage);
    }

    @Test
    public void testShowFunFactNoFunFactAvailable() {
        // fun fact is available for the given index
        boolean isCorrect = true;
        int questionIndex = 10; // Index out of bounds for fun facts
        String correctAnswer = "A";

        game.showFunFact(isCorrect, questionIndex, correctAnswer);

        // Assuming we have a way to capture the message or the fact that no dialog was shown
        assertNull("No fun fact message should be shown if the index is out of bounds", game.lastShownMessage);
    }

}