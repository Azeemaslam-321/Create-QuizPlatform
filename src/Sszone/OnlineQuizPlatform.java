package Sszone;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class OnlineQuizPlatform {
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//           
//            List<Question> questions = new ArrayList<>();
//
//            
//            questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid"}, 2));
//            questions.add(new Question("Which programming language is this quiz written in?", new String[]{"Java", "Python", "C++"}, 1));
//            questions.add(new Question("What is the largest planet in our solar system?", new String[]{"Mars", "Jupiter", "Saturn"}, 2));
//            questions.add(new Question("Who is the author of 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "J.K. Rowling", "George Orwell"}, 1));
//            questions.add(new Question("What is the capital of Japan?", new String[]{"Seoul", "Beijing", "Tokyo"}, 3));
//
//            
//            Quiz quiz = new Quiz(questions);
//
//            // Start the quiz
//            quiz.start();
//
//            // Print a message based on the user's performance
//            int totalQuestions = questions.size();
//            int userScore = quiz.getScore();
//
//            if (userScore == totalQuestions) {
//                System.out.println("Congratulations! You answered all questions correctly. You're a quiz master!");
//            } else if (userScore == 0) {
//                System.out.println("Oops! You didn't answer any questions correctly. Don't worry; practice makes perfect!");
//            } else {
//                System.out.println("Not bad! You got " + userScore + " out of " + totalQuestions + " questions correct. Keep it up!");
//            }
//
//        } catch (Exception e) {
//            System.out.println("An unexpected error occurred: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Implement user authentication
        User currentUser = authenticateUser(scanner);

        // Implement quiz creation, editing, and browsing
        QuizManager quizManager = new QuizManager();
        createEditBrowseQuizzes(currentUser, quizManager, scanner);

        // Close resources
        scanner.close();
    }

    private static User authenticateUser(Scanner scanner) {
        // Implement user authentication logic
        // For simplicity, let's assume a predefined user
        return new User("exampleUser", "password");
    }

    private static void createEditBrowseQuizzes(User user, QuizManager quizManager, Scanner scanner) {
        // Implement quiz creation, editing, and browsing logic
        System.out.println("Welcome, " + user.getUsername() + "!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new quiz");
            System.out.println("2. Edit existing quizzes");
            System.out.println("3. Browse available quizzes");
            System.out.println("4. Exit");

            int choice = getIntInput(scanner, "Enter your choice (1-4): ");

            switch (choice) {
                case 1:
                    createNewQuiz(user, quizManager, scanner);
                    break;
                case 2:
                    editQuizzes(user, quizManager, scanner);
                    break;
                case 3:
                    browseQuizzes(quizManager);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void createNewQuiz(User user, QuizManager quizManager, Scanner scanner) {
        System.out.println("\nCreating a new quiz...");
        System.out.print("Enter the title of the quiz: ");
        String title = scanner.nextLine();

        List<Question> questions = new ArrayList<>();

        while (true) {
            System.out.println("\nAdding a new question:");

            System.out.print("Enter the question text: ");
            String questionText = scanner.nextLine();

            List<String> options = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter option " + (i + 1) + ": ");
                options.add(scanner.nextLine());
            }

            System.out.print("Enter the correct option number (1-4): ");
            int correctOption = getIntInput(scanner, "");

            questions.add(new Question(questionText, options, correctOption));

            System.out.print("Do you want to add another question? (yes/no): ");
            String addAnother = scanner.nextLine().toLowerCase();

            if (!addAnother.equals("yes")) {
                break;
            }
        }

        Quiz quiz = new Quiz(title, questions);
        quizManager.addQuiz(quiz);
        System.out.println("Quiz created successfully!");
    }

    private static void editQuizzes(User user, QuizManager quizManager, Scanner scanner) {
        System.out.println("\nEditing existing quizzes...");

        List<Quiz> userQuizzes = quizManager.getQuizzesByUser(user);

        if (userQuizzes.isEmpty()) {
            System.out.println("You have no quizzes to edit.");
            return;
        }

        System.out.println("Your quizzes:");
        for (int i = 0; i < userQuizzes.size(); i++) {
            System.out.println((i + 1) + ". " + userQuizzes.get(i).getTitle());
        }

        int quizIndex = getIntInput(scanner, "Enter the number of the quiz you want to edit: ");
        if (quizIndex < 1 || quizIndex > userQuizzes.size()) {
            System.out.println("Invalid quiz number.");
            return;
        }

        Quiz selectedQuiz = userQuizzes.get(quizIndex - 1);
        System.out.println("Editing quiz: " + selectedQuiz.getTitle());

        // Add logic to edit the selected quiz (questions, options, etc.)
        // This part depends on your specific requirements and design
    }

    private static void browseQuizzes(QuizManager quizManager) {
        System.out.println("\nBrowsing available quizzes...");

        List<Quiz> allQuizzes = quizManager.getAllQuizzes();

        if (allQuizzes.isEmpty()) {
            System.out.println("No quizzes available.");
            return;
        }

        System.out.println("Available quizzes:");
        for (int i = 0; i < allQuizzes.size(); i++) {
            System.out.println((i + 1) + ". " + allQuizzes.get(i).getTitle());
        }

        // Add logic for user to view details or take a quiz
        // This part depends on your specific requirements and design
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
