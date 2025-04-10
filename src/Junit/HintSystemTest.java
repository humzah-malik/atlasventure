package com.mycompany.classtesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HintSystemTest {
    private HintSystem hintSystem;
    private Question question;

    @BeforeEach
    void setUp() {
        // Initial setup with 1 free hint, hint cost of 10 points, and player starting with 15 points
        hintSystem = new HintSystem(1, 10, 15);
        question = new Question("What is the capital of France?", "Paris", "It's the City of Light.", "Paris is known as the City of Light.", "Lyon", "Marseille", "Paris", "Toulouse");
    }

    @Test
    void provideHint_WithFreeHint() {
        String hint = hintSystem.provideHint(question);
        assertEquals("It's the City of Light.", hint, "Should provide a hint if there are free hints available");
    }

    @Test
    void checkFreeHintAvailability() {
        assertTrue(hintSystem.checkFreeHintAvailability(), "Should return true if there is at least one free hint available");
    }

    @Test
    void deductPoints() {
        boolean result = hintSystem.deductPoints(5);
        assertTrue(result, "Should return true and deduct points when there are enough points");
        assertEquals(10, hintSystem.getPlayerPoints(), "Player points should be deducted by the specified amount");
    }

    @Test
    void confirmPurchase() {
        assertTrue(hintSystem.confirmPurchase(), "Should confirm purchase if player points are equal or greater than hint cost");
    }

    @Test
    void addPoints() {
        hintSystem.addPoints(10);
        assertEquals(25, hintSystem.getPlayerPoints(), "Adding points should increase playerPoints by the specified amount");
    }
}