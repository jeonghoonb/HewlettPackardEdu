
package day0706;

interface InterfaceA{
	int B = 100; //final static ���� �� ��. => ���
	String method(); //apublic abstract ���� �� ��. => �߻�޼���
}

interface InterfaceB{
	int A = 10; //final static ���� �� ��. => ���
	void setA(); //apublic abstract ���� �� ��. => �߻�޼���
}

abstract class abstractC{
	void setB() {
		System.out.println("B");
	}
}

public class InterfaceEx extends abstractC implements InterfaceA, InterfaceB {
	
	@Override
	public String method() {
		return "Override method";
	}
	
	@Override
	public void setA() {
		System.out.println("Override setA method.....");
	}
	
	
	public static void main(String[] args) {
		InterfaceEx inter = new InterfaceEx();
		inter.setB();
		System.out.println("number : "+(B+A));
		System.out.println(inter.method());
		inter.setA();
	}


}
