package day0704;

//�ڽ� Class
public class Pig extends Animal {

	String name;
	int age;

	public Pig() {
		name = "����";
		
	}

	public static void main(String[] args) {
		 Pig pig = new Pig();
		 pig.bark();
		 System.out.println(pig.name); //�θ𿡵� name�̶�� ������ ������ ���еȴ�.
		
	}

}

//�θ� Class
class Animal {
	String name;
	int age;

	public Animal() {
		this.name = "����";
		this.age = 0;
	}

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void bark() {
		System.out.println("�ܲܲܲܲ�");
	}

}
