
package day0630;

public class ForEx1 {

	public static void main(String[] args) {

		int sum1 = 0;
		int sum2 = 0;

		for (int i = 1; i <= 100; i++) {
			sum1 += i;

			if (i % 2 == 0)
				sum2 += i;
		}

		System.out.println("1���� 100������ �� : " + sum1);
		System.out.println("1���� 100������ ¦���� �� : " + sum2);

		
	}

}
