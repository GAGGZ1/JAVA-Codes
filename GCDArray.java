import java.util.Arrays;

public class GCDArray {
    
    // Method to find GCD of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Method to find GCD of an array
    public static int findGCD(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {24, 36, 48}; // Example array
        System.out.println("GCD of array: " + findGCD(arr));
    }
}
