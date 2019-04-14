
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

		System.out.println("1부터 100까지의 합 : " + sum1);
		System.out.println("1부터 100까지의 짝수의 합 : " + sum2);

		
	}

}
