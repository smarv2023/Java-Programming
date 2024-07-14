package TriangleStar;

public class TraingleStar {

	public static void main(String[] args) {
		int maxStar = 20;
		System.out.println("(a)");
		for (int i = 0; i < maxStar; i++) {
			for(int x = 0; x <= i; x++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println("(b)");
		for (int i = maxStar; i > 0; i--) {
			for(int x = 0; x < i; x++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println("(c)");
		for (int i = 0; i < maxStar; i++) {
			for (int x = 0; x < i; x++) {
				System.out.print(' ');
			}
			for (int y = maxStar; y > i; y--) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println("(d)");
		for (int i = 0; i < maxStar; i++) {
			for (int x = maxStar-1; x > i; x--) {
				System.out.print(' ');
			}
			for (int y = 0; y <= i; y++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println("(e)");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 4; k++) {
					System.out.print('*');
				}
				System.out.println();
			}
			System.out.println();
		}
		
		// Diamond
		System.out.println("(f)");
		for (int a = 1; a < maxStar; a += 2) {
			for (int b = maxStar-2; b > a ; b-=2) {
				System.out.print(" ");
			}
			for (int c = 0; c < a; c++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int d = 1; d < maxStar-2; d += 2) {
			for (int e = 0; e < d; e += 2) {
				System.out.print(" ");
			}
			for (int f = d; f < maxStar-2; f++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
