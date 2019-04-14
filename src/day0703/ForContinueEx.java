package day0703;

public class ForContinueEx {
	public static void main(String args[]) {

		int k = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("반복 실행문 " + i);
			k++;
			if (k > 4) {
				System.out.println("continue 실행");
				continue; // k가 4보다 크면 for문의 i++ 증감식으로 이동, 반복 실행 제한이 출력되지 않는다.
			}
			System.out.println("반복 실행 제한" + k);
		}

		/*
		 * 5.0 향상된 for문 : for(변수 선언 : 반복이 가능한 변수만 가능) => ex) 배열, 컬렉션 등
		 */
		int[] arr = new int[] { 1, 2, 3 };
		for (int a : arr) {
			System.out.println(a);
		}
		
		//args[] 이용하기, args[] 자체가 String 배열이기에 숫자를 입력하면 정수가 아닌 문자 1, 2, 3 이런식으로 출력된다.
		for (String str : args) {
			System.out.println(str);
		}

	}
}
