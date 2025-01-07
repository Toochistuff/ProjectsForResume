import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

class Rabin {
    public final static int d = 256;  // Radix value (base for ASCII)

    /*
     * Rabin-Karp search for a pattern in text using a prime number q for hashing
     */
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;  // hash value for pattern
        int t = 0;  // hash value for text
        int h = 1;

        // Calculate the value of h = pow(d, M-1) % q
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the initial hash value for pattern and first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over the text
        for (i = 0; i <= N - M; i++) {
            // If hash values of pattern and current text window match
            if (p == t) {
                // Check characters one by one to confirm match
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                // If full match is found
                if (j == M) {
                    System.out.print(i + " ");
                }
            }

            // Calculate hash for the next window of text
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0) {
                    t = (t + q);  // Ensure non-negative hash
                }
            }
        }
    }

    // Generate a file with random 'a' and 'b' characters
    static void generateRandomTextFile(String filename, int length) throws IOException {
        FileWriter writer = new FileWriter(filename);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            writer.write(random.nextBoolean() ? 'a' : 'b');
        }
        writer.close();
    }

    // Read file content into a String
    static String readTextFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        return content.toString();
    }

    public static void main(String[] args) {












        String filename = "random_text.txt";
        int textLength = 1000000;  // Adjust as needed
        int q = 101;  // Prime number for hashing
        String pattern = "aaba";  // Pattern to search for


















        

        try {
            // Generate a random text file
            generateRandomTextFile(filename, textLength);

            // Read the generated file content
            String txt = readTextFromFile(filename);

            // Measure start time
            long startTime = System.nanoTime();

            // Run the search function
            search(pattern, txt, q);

            // Measure end time
            long endTime = System.nanoTime();
            // Calculate elapsed time
            long duration = endTime - startTime;

            // Display runtime
            System.out.println("\nRuntime: " + duration + " ns");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
