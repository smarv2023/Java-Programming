package SortO;

import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] data) {
        // Loop over data.length - 1 elements
        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i; // First index of remaining array
            
            // Loop to find index of smallest element
            for (int index = i + 1; index < data.length; index++)
                if (data[index] < data[smallest])
                    smallest = index;
            
            // Swap smallest element into position
            swap(data, i, smallest);
            // Output pass of algorithm
            printPass(data, i + 1, smallest);
        }
    }

    // Helper method to swap values in two elements
    private static void swap(int[] data, int first, int second) {
        int temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
    }

    // Print a pass of the algorithm
    private static void printPass(int[] data, int pass, int index) {
        System.out.printf("after pass %2d: ", pass);
        
        // Output elements till selected item
        for (int i = 0; i < index; i++)
            System.out.printf("%d   ", data[i]);
        
        // Indicate swap
        System.out.printf("%d*  ", data[index]);
        
        // Finish outputting array
        for (int i = index + 1; i < data.length; i++)
            System.out.printf("%d   ", data[i]);
        
        System.out.printf("%n            "); // For alignment
        
        // Indicate amount of array that's sorted
        for (int j = 0; j < pass; j++)
            System.out.print("   --");
        System.out.println();
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();
        int[] data = new int[10]; // Create array
        
        // Populate array
        for (int i = 0; i < data.length; i++)
            data[i] = 10 + generator.nextInt(90);
        
        // Display unsorted array
        System.out.printf("Unsorted array:%n%s%n%n",
                Arrays.toString(data));
        
        // Sort array
        selectionSort(data);
        
        // Display sorted array
        System.out.printf("Sorted array:%n%s%n%n",
                Arrays.toString(data));
    }
}


