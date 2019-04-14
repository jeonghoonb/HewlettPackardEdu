package day0705;

public class InheritanceEx2 extends SuperEx2 {
	int age = 10;
	String name1;

	// �������̵� : �θ� Class�� method()�� public�̱⿡ �ڽĿ��� ������ �� public�� ����
	public void method() {
		// super();
		// this();
		// super.��ü���
		// this.��ü���
		System.out.println("SubClass Method");
		super.method();
	}

	public static void main(String[] args) {
		InheritanceEx2 child = new InheritanceEx2();

		// 1) �ڵ� �� ��ȯ
		SuperEx2 parent = child; // ����� �޾ұ� ������ ����ȯ ����, �ڽ� -> �θ� : is-a ����(��� ����)
		Object obj = parent; // ��� class�� �ֻ��� ������ Object Class�̱⿡ ����ȯ ����
		// Object obj2 = child; //��� class�� �ֻ��� ������ Object Class�̱⿡ ����ȯ ����

		// 2) ���� �� ��ȯ (ĳ����)
		child = (InheritanceEx2) parent; // �θ� -> �ڽ� ����ȯ�� ���� �� ��ȯ(ĳ����)
		parent = (InheritanceEx2) obj; // �θ� -> �ڽ� ����ȯ�� ���� �� ��ȯ(ĳ����)

		// 3) �������̵� Override
		child.method();
		parent.method(); //�ڽĿ��� �θ��� �޼��带 ������ �ϸ� �θ��� ���� �޼��� ��� ��� �Ұ���, but super.�޼���() �δ� �����ϴ�. 14��° ����.
		parent.method2(); //�ڽĿ��� ������ ���� ���� �޼���� ��� ����
	
		// 4) ���к��� ���
		System.out.println("Child age : "+child.age); //age��� ������ �ڽİ� �θ� ��� ����, �׷��⿡ �ڽ� ��ü�� �����ϸ� �ڽĿ� ����� ������ ȣ��
		System.out.println("Parent age : "+parent.age); //age��� ������ �ڽİ� �θ� ��� ����, ������ �θ�� �����ϸ� �θ� ����� ���� ȣ��, �θ�� �ڽ��� �𸥴�(�θ𿡼� �ڽ� ��.
	}
}

class SuperEx2 {
	int age = 20; //���� ���� : �ڽĿ��� ������ �̸��� ������ �����ؼ� �θ��� ������ ���еȴ�.
	String name2;

	public void method() {
		System.out.println("SuperClass Method");
	}

	public void method2() {
		System.out.println("SuperClass Method22");
	}
}
