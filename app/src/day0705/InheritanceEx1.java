package day0705;

public class InheritanceEx1 extends SuperEx {
	
	int a;
	String b;

	public InheritanceEx1() {
		super(); //주석처리해도 실행 : 자식의 객체 생성시 부모 객체부터 자동 생성, super()를 명시하지 않으면 자동으로 부모의 기본 생성자 호출
				 //super()를 명시하지 않을 경우, 반드시 부모 클레스에 기본 생성자가 있어야 한다.
		System.out.println("InheritanceEx1 기본 생성자");
		System.out.println("this d : "+this.d+", super d : "+super.d); //this와 super로 부모에 접근 가능
	}

	public static void main(String[] args) { //main() 메서드는 static이 붙은 정적영역이기에 super(), this()와 같은 동적 사용 불가.
		InheritanceEx1 sub = new InheritanceEx1();
		sub.a = 10;
		System.out.println("자식 a : "+sub.a);
		sub.c= 30;
		System.out.println("부모 c : "+sub.c); //자식 객체 sub로 부모의 멤버변수 사용 가능(상속)
	}
}

class SuperEx {
	int c;
	String d;
	public SuperEx() {
		c = 20;
		d = "DDDD";
		System.out.println("SuperEx 기본 생성자 c : "+c+", d : "+d);
	}
	public SuperEx(int c, String d) {
		System.out.println("SuperEx 2번 생성자");
	}	
}

