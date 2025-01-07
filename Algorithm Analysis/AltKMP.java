import java.util.ArrayList;

class AltKMP {
    /*
     * Builds the LPS array with two parameters, pattern and
     * an array representing the length of the longest proper
     * prefix that's also a suffix 
     */
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

    /*
     * Search method that executes the KMP algorithm given a
     * text and a pattern, returning the starting index of any
     * matches found.
     */
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
        String txt = "aabaacaadaabaabaaabbababbbababababababaaaa";
        String pat = "bb";
        long startTime = System.nanoTime();
        ArrayList<Integer> res = search(pat, txt);
        long endTime = System.nanoTime();
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
        System.out.println();
        long duration = endTime - startTime;
        System.out.println("Runtime (nanoseconds): " + duration);
    }
}
