package day0703;

public class DoWhileBreakEx {

	public static void main(String args[]) {
		int i = 0;
		boolean result = true;
		do {
			i++;
			if (result) {
				System.out.println("���� ���� " + i);
				if (i == 5) {
					result = false;
				}
				if (!result) {
					System.out.println("���� ���� �����մϴ�.");
					break; //break���� if���� �ƴ϶� do-while �ݺ����� �������´�.
				}
			} else {
				System.out.println(" i : " + i);
			}
		} while (i < 10);
	}

}
