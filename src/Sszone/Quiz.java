package Sszone;
//
//import java.util.List;
//import java.util.Scanner;
//
//class Quiz {
//    private List<Question> questions;
//    private int score;
//
//    public Quiz(List<Question> questions) {
//        this.questions = questions;
//        this.score = 0;
//    }
//
//    public void start() {
//        Scanner scanner = new Scanner(System.in);
//
//        for (int i = 0; i < questions.size(); i++) {
//            Question question = questions.get(i);
//
//            System.out.println(question.getQuestionText());
//
//            String[] options = question.getOptions();
//            for (int j = 0; j < options.length; j++) {
//                System.out.println((j + 1) + ". " + options[j]);
//            }
//
//            int userAnswer;
//            try {
//                System.out.print("Your answer (1-" + options.length + "): ");
//                userAnswer = scanner.nextInt();
//
//                if (userAnswer < 1 || userAnswer > options.length) {
//                    System.out.println("Invalid answer! Please enter a number between 1 and " + options.length);
//                    i--;
//                    continue;
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input! Please enter a valid integer.");
//                scanner.nextLine();
//                i--;
//                continue;
//            } finally {
//                scanner.nextLine(); // Consume the newline character after the entered integer
//            }
//
//            int correctOptionIndex = question.getCorrectOption() - 1;
//            if (question.isCorrect(userAnswer)) {
//                System.out.println("Correct!\n");
//                score++;
//            } else {
//                System.out.println("Incorrect. The correct answer was: " + options[correctOptionIndex] + "\n");
//            }
//        }
//
//        System.out.println("Quiz complete. Your score: " + score + "/" + questions.size());
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    // Method to clear user responses
//    public void clearResponses() {
//        score = 0;
//    }
//}
//import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
class Quiz {
    private String title;
    private List<Question> questions;

    public Quiz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}