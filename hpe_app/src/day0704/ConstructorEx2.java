package day0704;

public class ConstructorEx2 {
	
	//�⺻ ������
	ConstructorEx2(){
		this(50, "ȫ�浿"); //int�� String�� �Ű������� ���� ������ ȣ��,  this()�� ������ ù �ٿ� ��ġ�ؾ� �Ѵ�.
		System.out.println("Constructor 1"); //���� ������ ȣ���� ���� �� ����
	}
	
	//����X
	ConstructorEx2(int a){
		System.out.println("Constructor 2 => a : "+a);
	}
	
	ConstructorEx2(int a, String s){
		System.out.println("Constructor 3 => a: "+a+" , s : "+s);
	}
	
	public static void main(String[] args) {
		System.out.println("Test");
		new ConstructorEx2();

	}

}
