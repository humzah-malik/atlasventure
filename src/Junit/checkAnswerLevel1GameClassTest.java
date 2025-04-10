import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckAnswerLevel1GameClassTest {

    private QuizController quizController;

    @Before
    public void setUp() {
        quizController = new QuizController();
    }

    @Test
    public void testCorrectAnswerIncreasesPoints() {
        quizController.checkAnswer("A", "A");
        assertTrue("Answer should be marked correct", quizController.isAnswerCorrect);
        assertEquals("Total points should increase by 10", 10, quizController.totalPoints);
    }

    @Test
    public void testIncorrectAnswerDoesNotIncreasePoints() {
        // Starting with some points
        quizController.totalPoints = 10;
        quizController.checkAnswer("B", "A");
        assertFalse("Answer should be marked incorrect", quizController.isAnswerCorrect);
        assertEquals("Total points should remain unchanged", 10, quizController.totalPoints);
    }

    @Test
    public void testCorrectAnswerTwiceIncreasesPointsOnce() {
        // First correct answer
        quizController.checkAnswer("A", "A");
        // Same correct answer again
        quizController.checkAnswer("A", "A");
        assertEquals("Total points should increase by 10 only once", 10, quizController.totalPoints);
    }

    @Test
    public void testIncorrectFollowedByCorrectAnswer() {
        // Incorrect answer first
        quizController.checkAnswer("B", "A");
        // Correct answer next
        quizController.checkAnswer("A", "A");
        assertEquals("Total points should be 10 after correct answer", 10, quizController.totalPoints);
    }

    @Test
    public void testNullAnswer() {
        // Starting with some points
        quizController.totalPoints = 10;
        quizController.checkAnswer(null, "A");
        assertFalse("Null answer should be treated as incorrect", quizController.isAnswerCorrect);
        assertEquals("Total points should remain unchanged with null answer", 10, quizController.totalPoints);
    }

    @Test
    public void testEmptyAnswer() {
        quizController.totalPoints = 10;
        quizController.checkAnswer("", "A");
        assertFalse("Empty answer should be treated as incorrect", quizController.isAnswerCorrect);
        assertEquals("Total points should remain unchanged with empty answer", 10, quizController.totalPoints);
    }

}