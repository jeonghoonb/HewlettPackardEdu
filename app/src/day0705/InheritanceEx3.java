package day0705;

public class InheritanceEx3 {
	public static void main(String[] args) {
		A a = new A();
		B b = a; //자식 a -> 부모b 자동 형 변환
		C c = b; //자식 ㅠ -> 부모c 자동 형 변환
		a.method(); //C의 method()가 자식 B, C에서 재정의 되어서 최하위 자식인 a에서 재정의된 method로 호출된다. 
		b.method();
		c.method();
		a.method_A();
		a.method_B(); // a가 b를 상속받아서 b에 접근 가능
		a.method_C(); // a가 b를 상속받고, b는 c를 상속받아서 a로 c까지 접근 가능
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
		//super(); //생략 가능
		//System.out.println("Constructor B");
	}

	int num = 50;

	public void method() {
		super.method_C();
		this.method_C();
		System.out.println("method B "+super.num+", "+this.num);
	}

	public void method_B() {
		System.out.println("method_B " + msg); //부모 Class인 C Class의 변수 msg 사용 가능
	}
}


class A extends B {
	
	int num = 30;

	public A() {
		// super().super(); //super()가 생략되서 부모 B의 기본생성자로 이동, B의 기본생성자에서도 부모인 C의 기본생성자로  이동
		//System.out.println("Constructor A");
	}

	public void method() {
		System.out.println("method A "+super.num+", "+this.num);
	}

	public void method_A() {
		System.out.println("method_A " + msg); //부모 Class인 B, B의 조상인 C Class의 변수 msg 사용 가능
	}
}