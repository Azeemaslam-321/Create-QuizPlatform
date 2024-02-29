package Sszone;
//class Question {
//    private String questionText;
//    private String[] options;
//    private int correctOption;
//
//    public Question(String questionText, String[] options, int correctOption) {
//        this.questionText = questionText;
//        this.options = options;
//        this.correctOption = correctOption;
//    }
//
//    public String getQuestionText() {
//        return questionText;
//    }
//
//    public String[] getOptions() {
//        return options;
//    }
//
//    public boolean isCorrect(int userAnswer) {
//        return userAnswer == correctOption;
//    }
//
//    public int getCorrectOption() {
//        return correctOption;
//    }
//}
//
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
class Question {
    private String text;
    private List<String> options;
    private int correctOptionIndex;

    public Question(String text, List<String> options, int correctOptionIndex) {
        this.text = text;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

class QuizManager {
    private List<Quiz> quizzes;

    public QuizManager() {
        this.quizzes = new ArrayList<>();
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public List<Quiz> getQuizzesByUser(User user) {
        // Implement logic to get quizzes created by the user
        // This part depends on your specific requirements and design
        return new ArrayList<>();
    }

    public List<Quiz> getAllQuizzes() {
        // Implement logic to get all available quizzes
        // This part depends on your specific requirements and design
        return quizzes;
    }
}