package SortO;

public class MergeSort2 {

	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 4, 7, 6, 8};
		
		mergeSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void mergeSort(int[] arr) {
		int length = arr.length;
		if (length <= 1) return;
		
		int middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];
		
		int j = 0; // left array
		int i = 0; // right array
		for (; i < length; i++) {
			if (i < middle) {
				leftArray[i] = arr[i];
			} else {
				rightArray[j] = arr[i];
				j++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, arr);
	}
	
	private static void merge(int[] left, int[] right, int[] arr) {
		int leftSize = arr.length / 2;
		int rightSize = arr.length - leftSize;
		int i = 0, l = 0, r = 0;
		
		// merging
		while (l < leftSize && r < rightSize) {
			if (left[l] < right[r]) {
				arr[i] = left[l];
				i++;
				l++;
			} else {
				arr[i] = right[r];
				i++;
				r++;
			}
		}
		
		while (l < leftSize) {
			arr[i] = left[l];
			i++;
			l++;
		}
		
		while (r < rightSize) {
			arr[i] = right[r];
			i++;
			r++;
		}
	}
}
