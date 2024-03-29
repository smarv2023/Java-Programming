package InitArray;

public class MultArray {

	public static void main(String[] args) {
		int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] array2 = {{1, 2}, {3}, {4, 5, 6}};
		
		System.out.println("Values in array1 by row are");
		outputArray(array1);
		
		System.out.println("Values in array2 by row are");
		outputArray(array2);
	}
	
	public static void outputArray(int[][] array) {
		// loop through array's rows
		for(int row = 0; row <array.length; row++) {
			//loop through column
			for (int column = 0; column  < array[row].length; column++)
				System.out.printf("%d  ", array[row][column]);
			
			System.out.println();
		}
	}

}
