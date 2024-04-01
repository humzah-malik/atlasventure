public class CustomLevelData {
    private String question;
    private String answer;
    private String hint;
    private String imagePath;

    public CustomLevelData() {
    }

    public CustomLevelData(String question, String answer, String hint, String imagePath) {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.imagePath = imagePath;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
