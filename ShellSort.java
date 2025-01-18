public class ShellSort {
    // Method to perform Shell Sort
    public static void shellSort(int[] array) {
        int n = array.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                // Shift elements that are gap apart
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Place temp in its correct position
                array[j] = temp;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {45, 23, 53, 12, 19, 8, 32, 4, 18};

        System.out.println("Original Array:");
        printArray(array);

        shellSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }
}
