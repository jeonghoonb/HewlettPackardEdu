package day0703;

public class PrintStarEx {
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============");

		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=====================");

		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= i; j--) {
				System.out.print(" ");
				if (j == i) {
					for (int k = 0; k <= i; k++) {
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}
		System.out.println("===================");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
				if (i == j) {
					for (int k = 5; k > i; k--) {
						System.out.print("*");
					}
				}
			}System.out.println();
		}

	}
}
