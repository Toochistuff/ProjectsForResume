import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class KMP {
    static final int TEXT_LENGTH = 1000000;  // Adjust the length as needed

    // Method to generate a file with random 'a' and 'b' characters
    static void generateRandomTextFile(String filename, int length) throws IOException {
        FileWriter writer = new FileWriter(filename);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            writer.write(random.nextBoolean() ? 'a' : 'b');
        }
        writer.close();
    }

    // Method to read file content into a String
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

    static void constructLps(String pat, int[] lps) {
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();
        constructLps(pat, lps);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    res.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String filename = "random_text.txt";
        try {
            // Step 1: Generate the random text file
            generateRandomTextFile(filename, TEXT_LENGTH);

            // Step 2: Read the generated file content into the 'txt' variable
            String txt = readTextFromFile(filename);









            // Define the pattern to search for
            String pat = "aaba";













            

            // Run the search algorithm
            long startTime = System.nanoTime();
            ArrayList<Integer> res = search(pat, txt);
            long endTime = System.nanoTime();

            // Print the results
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            long duration = endTime - startTime;
            System.out.println("Runtime (nanoseconds): " + duration);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
