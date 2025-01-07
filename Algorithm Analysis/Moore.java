import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

class Moore {
    static final int TEXT_LENGTH = 1000000;  // Adjust as needed for test size
    static final int NO_OF_CHARS = 256;

    // Method to generate a file with random 'a' and 'b' characters
    static void generateRandomTextFile(String filename, int length) throws IOException {
        FileWriter writer = new FileWriter(filename);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            writer.write(random.nextBoolean() ? 'a' : 'b');
        }
        writer.close();
    }

    // Method to read file content into a char array
    static char[] readTextFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        return content.toString().toCharArray();
    }

    // Gets the maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Preprocessing function for the bad character heuristic
    static void badCharHeuristic(char[] str, int size, int[] badchar) {
        for (int i = 0; i < NO_OF_CHARS; i++) {
            badchar[i] = -1;  // Initialize all to -1
        }
        for (int i = 0; i < size; i++) {
            badchar[str[i]] = i;  // Record the last occurrence of each character
        }
    }

    /*
     * Boyer-Moore pattern searching function that uses the bad character heuristic
     */
    static void search(char[] txt, char[] pat) {
        int m = pat.length;
        int n = txt.length;
        int[] badchar = new int[NO_OF_CHARS];

        // Preprocess pattern to fill the bad character array
        badCharHeuristic(pat, m, badchar);

        int s = 0;  // s is the shift of the pattern with respect to text
        long startTime = System.nanoTime();
        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing j while characters of pattern and text are matching
            while (j >= 0 && pat[j] == txt[s + j])
                j--;

            // If pattern is present at the current shift, print the index
            if (j < 0) {
                System.out.print(s + " ");
                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
            } else {
                // Shift pattern to align with the last occurrence of the bad character
                s += max(1, j - badchar[txt[s + j]]);
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("\n" + "Runtime: " + duration + " ns");
    }

    public static void main(String[] args) {
        String filename = "random_text.txt";
        try {
            // Step 1: Generate the random text file
            generateRandomTextFile(filename, TEXT_LENGTH);

            // Step 2: Read the generated file content into the 'txt' char array
            char[] txt = readTextFromFile(filename);






















            char[] pat = "aaba".toCharArray();





















            // Run the search algorithm
            search(txt, pat);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
