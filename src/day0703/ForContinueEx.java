package day0703;

public class ForContinueEx {
	public static void main(String args[]) {

		int k = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("�ݺ� ���๮ " + i);
			k++;
			if (k > 4) {
				System.out.println("continue ����");
				continue; // k�� 4���� ũ�� for���� i++ ���������� �̵�, �ݺ� ���� ������ ��µ��� �ʴ´�.
			}
			System.out.println("�ݺ� ���� ����" + k);
		}

		/*
		 * 5.0 ���� for�� : for(���� ���� : �ݺ��� ������ ������ ����) => ex) �迭, �÷��� ��
		 */
		int[] arr = new int[] { 1, 2, 3 };
		for (int a : arr) {
			System.out.println(a);
		}
		
		//args[] �̿��ϱ�, args[] ��ü�� String �迭�̱⿡ ���ڸ� �Է��ϸ� ������ �ƴ� ���� 1, 2, 3 �̷������� ��µȴ�.
		for (String str : args) {
			System.out.println(str);
		}

	}
}
