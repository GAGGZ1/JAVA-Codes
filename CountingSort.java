import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] array) {
        if (array.length == 0) return;

        // Find the maximum and minimum values in the array
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }

        // Initialize the counting array
        int range = max - min + 1;
        int[] count = new int[range];
        Arrays.fill(count, 0);

        // Count the occurrences of each element
        for (int num : array) {
            count[num - min]++;
        }

        // Modify the input array with sorted values
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                array[index++] = i + min;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original array: " + Arrays.toString(array));

        countingSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
