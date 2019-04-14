package day0705;

class X {
	protected int i = 10;
	protected String msg = "I am an X.";

	public void print() {
		System.out.println("X_Print : " + msg);
	}

	public void play() {
		System.out.println("X_Play : " + msg);
	}
}


class Y extends X {
	protected int i = 20;
	protected String msg = "I am an Y.";

	public void print() {
		System.out.println("Y_Print : " + msg);
	}
}


public class Z extends Y {
	protected int i = 30;
	protected String msg = "I am an Z.";

	public void print() {
		System.out.println("Z_Print : " + msg);
	}

	public void play() {
		System.out.println("Z_Play : " + msg);
	}
	
	public void doZ() {
		System.out.println("do something in Z.");
	}
	
	public void test(int i) {
		Z z = new Z();
		Y y = z; //z�� �ڽ��̴ϱ� �θ�y�� ����ȯ ����
		X x = z; //z�� �ڽ��̴ϱ� �θ�y�� �θ�x�� ����ȯ ����
		
		z.print(); //z���� ������
		y.print(); //z���� ������ �ؼ� z���� �������� ������� ȣ��
		x.print(); //z���� ������ �ؼ� z���� �������� ������� ȣ��
		super.print(); //z�� �θ��� y���� �������� �޼���� ȣ��
		System.out.println();
		
		play(); //z���� �������� �޼��� ȣ��
		super.play(); //�θ��� Y�� play()�޼��尡 ����, �� �� ������ X�� play() ȣ��
		
		//y.doZ(); //�θ� y�� �ڽ� z�� �޼��� ��� �Ұ���
		
		System.out.println("\ni = "+i); //�׳� i�� test()�޼���� ���� �Ű����� i
		System.out.println("this.i = "+this.i); //this.i�� ���� Ŭ���� Z�� i
		System.out.println("super.i = "+super.i); //super.i�� ���� Ŭ���� Z�� �θ��� Y�� i
		
		System.out.println("\ny.i = "+y.i); //y.i�� Y Ŭ������ ��ü�� i
		System.out.println("x.i = "+x.i); //x.i�� X Ŭ������ ��ü�� i
		
		System.out.println("\n((Y)this).i = "+((Y)(this)).i); //Y�� ����ȯ �� this.i�ϱ� Y�� i
		System.out.println("((X)this).i = "+((X)this).i); //X�� ����ȯ �� this.i�ϱ� X�� i
	}
	
	public static void main(String[] args) {
		Z z = new Z();
		z.test(15);
	}
}
