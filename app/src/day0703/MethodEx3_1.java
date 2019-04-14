package day0703;

public class MethodEx3_1 {
	
	public static void method1(int[] array) {
		for (int dan : array) {
			for (int i = 1; i < 10; i++) {
				int result = dan * i;
				System.out.println(result);
			}
		}
	}

	public static int[] method2() {
		int[] result = new int[8];
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				result[i - 2] += (i * j);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = method2();
		for (int i : result) {
			System.out.println(i);
		}
	}
	
}
