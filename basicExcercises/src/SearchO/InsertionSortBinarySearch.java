package SearchO;

import java.util.Scanner;

class InsertionSortBinarySearch {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Scanner input = new Scanner(System.in);
        
        int[] arr= {30, 21, 31, 19, 10, 18, 25, 16};
        
        insertionSort(arr);
        
        for (int x = 0; x < arr.length; x++) {
            System.out.println(arr[x]);
        }
        
        System.out.print("Please enter number to search: ");
        int key = input.nextInt();
        
        int search = binarySearch(arr, key);
        
        if (search == -1)
            System.out.printf("%d not found", key);
        else
            System.out.printf("%d found in index %d", arr[search], search);
        
        input.close();
    }
    
    // Insertion
    public static void insertionSort(int[] arr) {
        
        for (int i = 1; i < arr.length; i++) {
            
            int smaller = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > smaller) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = smaller;
        }
    }
    
    // Search
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            
            if (key > arr[middle])
                left = middle + 1;
            else if (key < arr[middle])
                right = middle - 1;  
            else
            	return middle;
        }
        return -1;
    }
}
