import java.util.Scanner;

public class CheckSensitiveWords {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sentence
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        // Convert to lowercase for case-insensitive comparison
        String lowerSentence = sentence.toLowerCase();

        // Check for presence of "kill" or "murder"
        if (lowerSentence.contains("kill") || lowerSentence.contains("murder")) {
            System.out.println("The sentence contains sensitive words like 'Kill' or 'Murder'.");
        } else {
            System.out.println("No sensitive words found.");
        }

        sc.close();
    }
}
