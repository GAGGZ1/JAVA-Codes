import java.util.Arrays;

public class KMPAlgorithm {

    // Function to build the LPS (Longest Prefix Suffix) array
    public static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int i = 0, j = 1;

        // Initialize LPS array for the first character
        lps[0] = 0;

        // Iterate through the pattern
        while (j < m) {
            // Case 1: Match
            if (pattern[i] == pattern[j]) {
                i++;
                lps[j] = i;
                j++;
            }
            // Case 2: Mismatch
            else {
                if (i != 0) {
                    i = lps[i - 1]; // Move to the previous longest prefix
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps;
    }

    // Function to implement KMP Pattern Matching
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = buildLPS(pattern); // Build the LPS array

        int x = 0; // Index for the text
        int y = 0; // Index for the pattern

        // Iterate through the text
        while (x < n) {
            // Case 1: Match
            if (text.charAt(x) == pattern.charAt(y)) {
                x++;
                y++;

                // If we found a match
                if (y == m) {
                    System.out.println("Pattern found at index " + (x - y));
                    y = lps[y - 1]; // Update y to the previous longest prefix
                }
            }
            // Case 2: Mismatch
            else {
                if (y != 0) {
                    y = lps[y - 1]; // Use LPS to move to the previous longest prefix
                } else {
                    x++; // Move to the next character in the text
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Step-by-step execution:");

        // Run KMP pattern search
        KMPSearch(text, pattern);
    }
}
