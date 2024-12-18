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

// Algo:
// LPS Table Construction
    // Initialize Variables:

        // i <- 0 (pointer for prefix).
        // j <- 1 (pointer for suffix).
        // LLP[0] <- 0 (LPS value of the first character is always 0).

    // Iterate Through the Pattern:

        // While j < length of the pattern:
        // Case 1: Match:
            // If pattern[i] == pattern[j], set LLP[j] = i + 1.
            // Increment both i and j.
        // Case 2: Mismatch:
            // If pattern[i] != pattern[j]:
                // If i != 0, update i = LLP[i - 1] (go to the previous longest prefix).
                // Else, set LLP[j] = 0 and increment j.

// KMP Algorithm (Pattern Matching)
    // Initialize Variables:

        // x <- 0 (index for the string).
        // y <- 0 (index for the pattern).
        // len <- length of the string.

    // Iterate Through the String:

        // While x < len:
            // Case 1: Match:
                // If string[x] == pattern[y], increment both x and y.
                // If y == length of the pattern, a match is found. Print or store the match index x - y and update y = LLP[y - 1].
            // Case 2: Mismatch:
                // If string[x] != pattern[y]:
                    // If y != 0, update y = LLP[y - 1].
                    // Else, increment x.
