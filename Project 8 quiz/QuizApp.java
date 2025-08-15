import java.util.ArrayList;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Questions
        ArrayList<String> questions = new ArrayList<>();
        questions.add("What are Java loops?");
        questions.add("What is enhanced for-loop?");
        questions.add("How do you handle multiple user inputs?");
        questions.add("How is a switch-case different from if-else?");
        questions.add("What are collections in Java?");
        questions.add("What is ArrayList?");
        questions.add("How to iterate using iterators?");
        questions.add("What is a Map?");
        questions.add("How to sort a list?");
        questions.add("How to shuffle elements?");

        // Options
        ArrayList<String[]> options = new ArrayList<>();
        options.add(new String[]{"Conditional statements", "Repetitive execution blocks", "Error handlers", "None"});
        options.add(new String[]{"Loop using index", "Loop for collections/arrays", "Loop for conditions only", "Infinite loop"});
        options.add(new String[]{"Scanner / BufferedReader", "Using loops", "Using recursion", "None"});
        options.add(new String[]{"Only compares equality", "Can compare ranges", "Runs faster", "None"});
        options.add(new String[]{"Frameworks", "Data structures for storing objects", "Files", "None"});
        options.add(new String[]{"Fixed-size array", "Resizable array", "Hash-based collection", "Tree-based list"});
        options.add(new String[]{"Using while loop", "Using Iterator object", "Using recursion", "None"});
        options.add(new String[]{"Key-Value pair collection", "Only values", "Only keys", "None"});
        options.add(new String[]{"Collections.sort()", "Manually swapping", "TreeMap", "None"});
        options.add(new String[]{"Collections.shuffle()", "Random()", "Manually swapping", "None"});

        // Correct answers (index based)
        int[] correctAnswers = {1, 1, 0, 0, 1, 1, 1, 0, 0, 0};

        int score = 0;

        // Quiz loop
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQ" + (i + 1) + ": " + questions.get(i));
            String[] opts = options.get(i);
            for (int j = 0; j < opts.length; j++) {
                System.out.println((j + 1) + ". " + opts[j]);
            }

            System.out.print("Your answer: ");
            int ans = sc.nextInt() - 1; // convert to 0-based

            if (ans == correctAnswers[i]) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + opts[correctAnswers[i]]);
            }
        }

        // Final score
        System.out.println("\nYour Score: " + score + "/" + questions.size());
        if (score == questions.size()) {
            System.out.println("🎉 Excellent! Full marks!");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good job! Keep improving.");
        } else {
            System.out.println("📚 Better luck next time!");
        }

        sc.close();
    }
}
