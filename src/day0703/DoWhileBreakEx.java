package day0703;

public class DoWhileBreakEx {

	public static void main(String args[]) {
		int i = 0;
		boolean result = true;
		do {
			i++;
			if (result) {
				System.out.println("실행 구문 " + i);
				if (i == 5) {
					result = false;
				}
				if (!result) {
					System.out.println("실행 구문 종료합니다.");
					break; //break문은 if문이 아니라 do-while 반복문을 빠져나온다.
				}
			} else {
				System.out.println(" i : " + i);
			}
		} while (i < 10);
	}

}
