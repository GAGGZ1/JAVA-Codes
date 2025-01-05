import java.util.Arrays;

public class LCM {
    
    // Function to calculate GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Function to calculate LCM of two numbers
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    // Function to calculate LCM of an array
    public static int findLCM(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6}; // Example array
        System.out.println("LCM of the array: " + findLCM(arr));
    }
}
