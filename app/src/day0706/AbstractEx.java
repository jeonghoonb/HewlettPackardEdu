package day0706;

public class AbstractEx extends Abs {
	public static void main(String[] args) {
		AbstractEx abstractEx = new AbstractEx();
		Abs abs = abstractEx;
		abs.setA();
		System.out.println(abs.getA());
	}

	//�θ� Class�� abstract �޼��带 ��� ������ �ؾ� ������ ���� �ʴ´�.
	@Override
	public int getA() {	
		System.out.println("�߻� �޼��� ������.....");
		return 100;
	}
}

//abstract �޼��带 ������ ������ �߻�Ŭ����
//�Ϲ� Ŭ������ abstract �޼��� ���� �� ����.
abstract class Abs{
	int a = 10;
	public void setA() {
		System.out.println("�Ϲ� �޼��� ����");
	}
	
	public abstract int getA();
}