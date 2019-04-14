package day0705;

public class InheritanceEx3 {
	public static void main(String[] args) {
		A a = new A();
		B b = a; //�ڽ� a -> �θ�b �ڵ� �� ��ȯ
		C c = b; //�ڽ� �� -> �θ�c �ڵ� �� ��ȯ
		a.method(); //C�� method()�� �ڽ� B, C���� ������ �Ǿ ������ �ڽ��� a���� �����ǵ� method�� ȣ��ȴ�. 
		b.method();
		c.method();
		a.method_A();
		a.method_B(); // a�� b�� ��ӹ޾Ƽ� b�� ���� ����
		a.method_C(); // a�� b�� ��ӹް�, b�� c�� ��ӹ޾Ƽ� a�� c���� ���� ����
		//System.out.println("A : "+a.num);
		//System.out.println("B : "+b.num);
		//System.out.println("C : "+c.num);
	}
}


class C {

	int num = 10;
	String msg = "msg....C";

	public C() {
		//System.out.println("Constructor C");
	}

	public void method() {
		System.out.println("method C : "+this.num);
	}

	public void method_C() {
		System.out.println("method_C " + msg);
	}
}


class B extends C {
	public B() {
		//super(); //���� ����
		//System.out.println("Constructor B");
	}

	int num = 50;

	public void method() {
		super.method_C();
		this.method_C();
		System.out.println("method B "+super.num+", "+this.num);
	}

	public void method_B() {
		System.out.println("method_B " + msg); //�θ� Class�� C Class�� ���� msg ��� ����
	}
}


class A extends B {
	
	int num = 30;

	public A() {
		// super().super(); //super()�� �����Ǽ� �θ� B�� �⺻�����ڷ� �̵�, B�� �⺻�����ڿ����� �θ��� C�� �⺻�����ڷ�  �̵�
		//System.out.println("Constructor A");
	}

	public void method() {
		System.out.println("method A "+super.num+", "+this.num);
	}

	public void method_A() {
		System.out.println("method_A " + msg); //�θ� Class�� B, B�� ������ C Class�� ���� msg ��� ����
	}
}