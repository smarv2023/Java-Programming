package SortO;

import java.security.SecureRandom;
import java.util.Arrays;

public class MergeSort {
    // Calls recursive split method to begin merge sorting
    public static void mergeSort(int[] data) {
        sortArray(data, 0, data.length - 1); // Sort entire array
    }

    // Splits array, sorts subarrays, and merges subarrays into sorted array
    private static void sortArray(int[] data, int low, int high) {
        // Test base case: size of array equals 1
        if ((high - low) >= 1) { // If not base case
            int middle1 = (low + high) / 2; // Calculate middle of array
            int middle2 = middle1 + 1; // Calculate next element over

            // Output split step
            System.out.printf("split: %s%n",
                    subarrayString(data, low, high));
            System.out.printf("       %s%n",
                    subarrayString(data, low, middle1));
            System.out.printf("       %s%n%n",
                    subarrayString(data, middle2, high));

            // Split array in half; sort each half (recursive calls)
            sortArray(data, low, middle1); // First half of array
            sortArray(data, middle2, high); // Second half of array

            // Merge two sorted arrays after split calls return
            merge(data, low, middle1, middle2, high);
        }
    }

    // Merge two sorted subarrays into one sorted subarray
    private static void merge(int[] data, int left, int middle1,
                               int middle2, int right) {
        int leftIndex = left; // Index into left subarray
        int rightIndex = middle2; // Index into right subarray
        int combinedIndex = left; // Index into temporary working array
        int[] combined = new int[data.length]; // Working array

        // Output two subarrays before merging
        System.out.printf("merge:   %s%n",
                subarrayString(data, left, middle1));
        System.out.printf("         %s%n",
                subarrayString(data, middle2, right));

        // Merge arrays until reaching end of either
        while (leftIndex <= middle1 && rightIndex <= right) {
            // Place smaller of two current elements into result
            // and move to next space in arrays
            if (data[leftIndex] <= data[rightIndex])
                combined[combinedIndex++] = data[leftIndex++];
            else
                combined[combinedIndex++] = data[rightIndex++];
        }

        // If left array is empty
        if (leftIndex == middle2)
            // Copy in rest of right array
            while (rightIndex <= right)
                combined[combinedIndex++] = data[rightIndex++];
        else // Right array is empty
            // Copy in rest of left array
            while (leftIndex <= middle1)
                combined[combinedIndex++] = data[leftIndex++];

        // Copy values back into original array
        for (int i = left; i <= right; i++)
            data[i] = combined[i];

        // Output merged array
        System.out.printf("       %s%n%n",
                subarrayString(data, left, right));
    }

    // Method to output certain values in array
    private static String subarrayString(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();

        // Output spaces for alignment
        for (int i = 0; i < low; i++)
            temporary.append("   ");

        // Output elements left in array
        for (int i = low; i <= high; i++)
            temporary.append(" " + data[i]);

        return temporary.toString();
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        int[] data = new int[10]; // Create array

        // Populate array
        for (int i = 0; i < data.length; i++)
            data[i] = 10 + generator.nextInt(90);

        System.out.printf("Unsorted array:%n%s%n%n",
                Arrays.toString(data)); // Display array

        mergeSort(data); // Sort array

        System.out.printf("Sorted array:%n%s%n%n",
                Arrays.toString(data)); // Display array
    }
}

