package day0704;

public class ConstructorEx1 {

	int a;

	// �⺻������ : �⺻ �����ڴ� �ƹ� �����ڰ� ���� �� �����ص� �ڵ����� ���������. but, �ٸ� �����ڰ� �ִµ� �⺻�����ڸ� �����ϴ� ���� �⺻�����ڰ� ���ٴ� ��.
	ConstructorEx1() {
		a = 50;
		System.out.println("constructor 1, a = " + this.a);
		System.out.println("constructor 1, "+a);
	}

	// ������ �����ε�
	ConstructorEx1(int a) {
		System.out.println("constructor 2, "+this.a);
		System.out.println("constructor 2, a = " + this.a);
	}

	public static void main(String[] args) {
		//int a�� ����������� new�� ���� �ٸ� ��ü co1, co2�� �����߱⿡ ���� a�� ���� �ٸ� ���� ����� �������̴�.
		ConstructorEx1 co1 = new ConstructorEx1(); 
		ConstructorEx1 co2 = new ConstructorEx1(30);
		System.out.println("constructor 1, "+co1.a);
		System.out.println("constructor 2, "+co2.a);
	
	}
	
}