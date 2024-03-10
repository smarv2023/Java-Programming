package SortO;

import java.security.SecureRandom;
import java.util.Arrays;

public class InsertionSort {
    // Sort array using insertion sort
    public static void insertionSort(int[] data) {
        // Loop over data.length - 1 elements
        for (int next = 1; next < data.length; next++) {
            int insert = data[next]; // Value to insert
            int moveItem = next; // Location to place element

            // Search for place to put current element
            while (moveItem > 0 && data[moveItem - 1] > insert) {
                // Shift element right one slot
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }

            data[moveItem] = insert; // Place inserted element
            printPass(data, next, moveItem); // Output pass of algorithm
        }
    }

    // Print a pass of the algorithm
    public static void printPass(int[] data, int pass, int index) {
        System.out.printf("after pass %2d: ", pass);

        // Output elements till swapped item
        for (int i = 0; i < index; i++)
            System.out.printf("%d   ", data[i]);

        System.out.printf("%d*  ", data[index]); // Indicate swap

        // Finish outputting array
        for (int i = index + 1; i < data.length; i++)
            System.out.printf("%d   ", data[i]);

        System.out.printf("%n            "); // For alignment

        // Indicate amount of array that's sorted
        for (int i = 0; i <= pass; i++)
            System.out.print("   --");
        System.out.println();
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();
        int[] data = new int[10]; // Create array

        // Populate array
        for (int i = 0; i < data.length; i++)
            data[i] = 10 + generator.nextInt(90);

        System.out.printf("Unsorted array:%n%s%n%n",
                Arrays.toString(data)); // Display array

        insertionSort(data); // Sort array

        System.out.printf("Sorted array:%n%s%n%n",
                Arrays.toString(data)); // Display array
    }
}

