package day0703;

public class MethodEx1 {

	public static int intA() {
		int num = 10;
		System.out.println("intA �޼ҵ� ����");
		return num;
	}

	public static void intB() {
		System.out.println("intB �޼ҵ� ����");
	}

	public static void main(String[] args) {
		int result = intA();
		//long result = intA(); �� ��, int -> long�� �ڵ�����(������) ����ȯ
		System.out.println("intA() ���� ��� result : "+result);
		
		intB();
	}
}
