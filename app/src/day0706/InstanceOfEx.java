package day0706;

class Interface { }

class Parent extends Interface { int a = 10; }

class Child extends Parent { }

/*
 *  A instanceof B : A가 B의 타입이 맞는가? (단, 기본형 변수는 Wrapper 클래스 사용 : ex) int는 Integer, double은 Double 등)
 **/
public class InstanceOfEx {
	public static void main(String[] args) {
		Child child = new Child();
		
		if (child instanceof Interface) {
			System.out.println("child is instance of Interface.");
		}
		if (child instanceof Object) {
			System.out.println("child is instance of Object.");
		}
		if (child instanceof Parent) {
			System.out.println("child is instance of Parent.");
		}
		if (child instanceof Child) {
			System.out.println("child is instance of Child.");
		}
		System.out.println();

		// 잘못사용한 예 : child는 Parent, Interface, Object 클래스의 타입에 속한다. 즉, 여러 타입에 속할 수 있기 때문에 if - else를 쓰면 안된다.
		if (child instanceof Object) {
			System.out.println("child is instance of Object.");
		} else if (child instanceof Interface) {
			System.out.println("child is instance of Interface.");
		} else if (child instanceof Parent) {
			System.out.println("child is instance of Parent.");
		} else if (child instanceof Child) {
			System.out.println("child is instance of Child");
		}
	}
}
