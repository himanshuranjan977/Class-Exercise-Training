public class StringFive {
    public static void main(String[] args) {
        String sentence = "Today is a very nice day for learning java";

        int count = 0;

        // Count the number of 'a' characters
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == 'a') {
                count++;
            }
        }

        // Print the result
        System.out.println("Number of 'a' in the sentence: " + count);

    }

}
