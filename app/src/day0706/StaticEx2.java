package day0706;

public class StaticEx2 {
	
	public static final int AGE = 10;
	public String name;
	
	public StaticEx2() {
		name = "ȫ�浿";
	}
	
	public StaticEx2(String name) {
		this.name = name;
		//this.AGE = 50; //final�� ���� ����̱⿡ �� ���� �Ұ���
	}
	
	public static void main(String[] args) {
		StaticEx2 se = new StaticEx2();
		System.out.print(se.name+"�� ���̴� "+AGE);
		StaticEx2 se2 = new StaticEx2("������");
		System.out.print("\n"+se2.name+"�� ���̴� "+AGE);
	}
}
