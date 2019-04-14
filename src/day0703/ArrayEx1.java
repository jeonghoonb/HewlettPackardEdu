package day0703;

public class ArrayEx1 {
	public static void main(String[] args) {

		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		// int [] arr = new int {1, 2, 3};

		/*
		 * System.out.println("arr[0] : " + arr[0]); System.out.println("arr[1] : " +
		 * arr[1]); System.out.println("arr[2] : " + arr[2]);
		 */

		/*
		 * for (int a : arr) { System.out.println("arr[" + a + "] : " + a); }
		 */

		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + i);
		}

	}
}
