package day0706;

class Interface { }

class Parent extends Interface { int a = 10; }

class Child extends Parent { }

/*
 *  A instanceof B : A�� B�� Ÿ���� �´°�? (��, �⺻�� ������ Wrapper Ŭ���� ��� : ex) int�� Integer, double�� Double ��)
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

		// �߸������ �� : child�� Parent, Interface, Object Ŭ������ Ÿ�Կ� ���Ѵ�. ��, ���� Ÿ�Կ� ���� �� �ֱ� ������ if - else�� ���� �ȵȴ�.
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
