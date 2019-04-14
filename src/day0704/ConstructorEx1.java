package day0704;

public class ConstructorEx1 {

	int a;

	// 기본생성자 : 기본 생성자는 아무 생성자가 없을 시 생략해도 자동으로 만들어진다. but, 다른 생성자가 있는데 기본생성자를 생략하는 것은 기본생성자가 없다는 뜻.
	ConstructorEx1() {
		a = 50;
		System.out.println("constructor 1, a = " + this.a);
		System.out.println("constructor 1, "+a);
	}

	// 생성자 오버로딩
	ConstructorEx1(int a) {
		System.out.println("constructor 2, "+this.a);
		System.out.println("constructor 2, a = " + this.a);
	}

	public static void main(String[] args) {
		//int a가 멤버변수지만 new로 서로 다른 객체 co1, co2를 생성했기에 변수 a는 서로 다른 곳에 저장된 데이터이다.
		ConstructorEx1 co1 = new ConstructorEx1(); 
		ConstructorEx1 co2 = new ConstructorEx1(30);
		System.out.println("constructor 1, "+co1.a);
		System.out.println("constructor 2, "+co2.a);
	
	}
	
}