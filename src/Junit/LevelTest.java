package com.mycompany.classtesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    private Level level;
    private Question question1;
    private Question question2;

    @BeforeEach
    void setUp() {
        level = new Level(1);
        question1 = new Question("What is the capital of France?", "Paris", "It's the City of Light.", "Paris is known as the City of Light.", "Lyon", "Marseille", "Paris", "Toulouse");
        question2 = new Question("What is the capital of Italy?", "Rome", "It's not Venice.", "Rome has the Colosseum.", "Venice", "Milan", "Rome", "Naples");
    }

    @Test
    void addQuestion() {
        level.addQuestion(question1);
        assertEquals("It's the City of Light.", level.getNextQuestion().getHint(), "The question should be added to the level");
    }

    @Test
    void getNextQuestion() {
        level.addQuestion(question1);
        level.addQuestion(question2);
        assertNotNull(level.getNextQuestion(), "Should return the next question");
        assertNotNull(level.getNextQuestion(), "Should return the next question after the first");
        assertNull(level.getNextQuestion(), "Should return null when there are no more questions");
    }

    @Test
    void resetLevel() {
        level.addQuestion(question1);
        level.getNextQuestion(); // Move to the next question
        level.calculateScore(true); // Increase score
        level.resetLevel();
        assertEquals(-1, level.currentQuestionIndex, "After reset, currentQuestionIndex should be -1");
        assertEquals(0, level.score, "After reset, score should be 0");
    }

    @Test
    void calculateScore() {
        assertEquals(1, level.calculateScore(true), "Score should increase by 1 if the answer is correct");
        assertEquals(1, level.calculateScore(false), "Score should not change if the answer is incorrect");
    }

    @Test
    void isLevelCompleted() {
        level.addQuestion(question1);
        level.getNextQuestion();
        assertFalse(level.isLevelCompleted(), "Level should not be completed if there are unanswered questions");
        level.getNextQuestion(); // Attempt to get another question, which doesn't exist
        assertTrue(level.isLevelCompleted(), "Level should be completed when all questions are answered");
    }

    @Test
    void getLevelNum() {
        assertEquals(1, level.getLevelNum(), "Should return the correct level number");
    }

    @Test
    void isReadyToUnlockNextLevel() {
        level.addQuestion(question1);
        level.getNextQuestion(); // Assume this question is answered
        assertFalse(level.isReadyToUnlockNextLevel(), "Should not be ready to unlock the next level if not all questions are answered");
        level.getNextQuestion(); // Move past the last question
        assertTrue(level.isReadyToUnlockNextLevel(), "Should be ready to unlock the next level when all questions are answered");
    }
}