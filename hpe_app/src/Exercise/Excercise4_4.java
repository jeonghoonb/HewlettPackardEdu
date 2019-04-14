package Exercise;

public class Excercise4_4 {
	public static void main(String[] args) {
		boolean b = false;
		int num1 = 0;
		int num2 = 0;
		int cnt = 0;
		do {
			num1 = (int)(Math.random()*6)+1;
			num2 = (int)(Math.random()*6)+1;
			if(num1 + num2 == 5) {
				b = true;
			}
			cnt++;
		} while (!b);
		
		System.out.println("�� "+cnt+"�� ����"+"�ش� ���ڴ� : "+num1 + ", "+num2);
	}
}
