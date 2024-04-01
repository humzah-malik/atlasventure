import java.util.ArrayList;
import java.util.List;

public class CustomLevelData {
    private List<String> questions;
    private List<String[]> options;
    private List<String> correctAnswers;
    private List<String> hints;
    private List<String> imagePaths;
    private List<String[]> funFacts;

    public CustomLevelData() {
        this.questions = new ArrayList<>();
        this.options = new ArrayList<>();
        this.correctAnswers = new ArrayList<>();
        this.hints = new ArrayList<>();
        this.imagePaths = new ArrayList<>();
        this.funFacts = new ArrayList<>();
    }

    // Add a question and its details
    public void addQuestion(String question, String[] options, String correctAnswer, String hint, String imagePath, String[] funFact) {
        this.questions.add(question);
        this.options.add(options);
        this.correctAnswers.add(correctAnswer);
        this.hints.add(hint);
        this.imagePaths.add(imagePath);
        this.funFacts.add(funFact);
    }

    // Getters
    public List<String> getQuestions() {
        return questions;
    }

    public List<String[]> getOptions() {
        return options;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public List<String> getHints() {
        return hints;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public List<String[]> getFunFacts() {
        return funFacts;
    }
}
