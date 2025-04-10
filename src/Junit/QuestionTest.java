package com.mycompany.classtesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Question question;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        question = new Question("What is the capital of France?", "Paris", "It's the City of Light.", "Paris is known as the City of Light.", "Lyon", "Marseille", "Paris", "Toulouse");
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); // Reset System.out to its original state
    }

    @Test
    void displayQuestion() {
        question.displayQuestion();
        String expectedOutput = "What is the capital of France?\n1. Lyon\n2. Marseille\n3. Paris\n4. Toulouse\n";
        assertEquals(expectedOutput, outContent.toString(), "displayQuestion should print the question and options correctly");
    }

    @Test
    void revealAnswer() {
        question.revealAnswer();
        String expectedOutput = "Correct answer: Paris\n";
        assertEquals(expectedOutput, outContent.toString(), "revealAnswer should reveal the correct answer");
    }

    @Test
    void displayFunFact() {
        question.displayFunFact();
        String expectedOutput = "Fun Fact: Paris is known as the City of Light.\n";
        assertEquals(expectedOutput, outContent.toString(), "displayFunFact should display the fun fact correctly");
    }
}