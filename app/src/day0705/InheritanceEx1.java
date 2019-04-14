package day0705;

public class InheritanceEx1 extends SuperEx {
	
	int a;
	String b;

	public InheritanceEx1() {
		super(); //�ּ�ó���ص� ���� : �ڽ��� ��ü ������ �θ� ��ü���� �ڵ� ����, super()�� ������� ������ �ڵ����� �θ��� �⺻ ������ ȣ��
				 //super()�� ������� ���� ���, �ݵ�� �θ� Ŭ������ �⺻ �����ڰ� �־�� �Ѵ�.
		System.out.println("InheritanceEx1 �⺻ ������");
		System.out.println("this d : "+this.d+", super d : "+super.d); //this�� super�� �θ� ���� ����
	}

	public static void main(String[] args) { //main() �޼���� static�� ���� ���������̱⿡ super(), this()�� ���� ���� ��� �Ұ�.
		InheritanceEx1 sub = new InheritanceEx1();
		sub.a = 10;
		System.out.println("�ڽ� a : "+sub.a);
		sub.c= 30;
		System.out.println("�θ� c : "+sub.c); //�ڽ� ��ü sub�� �θ��� ������� ��� ����(���)
	}
}

class SuperEx {
	int c;
	String d;
	public SuperEx() {
		c = 20;
		d = "DDDD";
		System.out.println("SuperEx �⺻ ������ c : "+c+", d : "+d);
	}
	public SuperEx(int c, String d) {
		System.out.println("SuperEx 2�� ������");
	}	
}

