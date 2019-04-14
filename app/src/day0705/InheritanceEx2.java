package day0705;

public class InheritanceEx2 extends SuperEx2 {
	int age = 10;
	String name1;

	// 오버라이드 : 부모 Class의 method()가 public이기에 자식에서 재정의 시 public만 가능
	public void method() {
		// super();
		// this();
		// super.객체요소
		// this.객체요소
		System.out.println("SubClass Method");
		super.method();
	}

	public static void main(String[] args) {
		InheritanceEx2 child = new InheritanceEx2();

		// 1) 자동 형 변환
		SuperEx2 parent = child; // 상속을 받았기 때문에 형변환 가능, 자식 -> 부모 : is-a 관계(상속 관계)
		Object obj = parent; // 모든 class의 최상위 계층은 Object Class이기에 형변환 가능
		// Object obj2 = child; //모든 class의 최상위 계층은 Object Class이기에 형변환 가능

		// 2) 강제 형 변환 (캐스팅)
		child = (InheritanceEx2) parent; // 부모 -> 자식 형변환은 강제 형 변환(캐스팅)
		parent = (InheritanceEx2) obj; // 부모 -> 자식 형변환은 강제 형 변환(캐스팅)

		// 3) 오버라이드 Override
		child.method();
		parent.method(); //자식에서 부모의 메서드를 재정의 하면 부모의 기존 메서드 기능 사용 불가능, but super.메서드() 로는 가능하다. 14번째 라인.
		parent.method2(); //자식에서 재정의 되지 않은 메서드는 사용 가능
	
		// 4) 은닉변수 사용
		System.out.println("Child age : "+child.age); //age라는 변수가 자식과 부모에 모두 존재, 그렇기에 자식 객체로 접근하면 자식에 선언된 변수로 호출
		System.out.println("Parent age : "+parent.age); //age라는 변수가 자식과 부모에 모두 존재, 하지만 부모로 접근하면 부모에 선언된 변수 호출, 부모는 자식을 모른다(부모에선 자식 접.
	}
}

class SuperEx2 {
	int age = 20; //은닉 변수 : 자식에도 동일한 이름의 변수가 존재해서 부모의 변수는 은닉된다.
	String name2;

	public void method() {
		System.out.println("SuperClass Method");
	}

	public void method2() {
		System.out.println("SuperClass Method22");
	}
}
