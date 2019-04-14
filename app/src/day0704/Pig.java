package day0704;

//자식 Class
public class Pig extends Animal {

	String name;
	int age;

	public Pig() {
		name = "나비";
		
	}

	public static void main(String[] args) {
		 Pig pig = new Pig();
		 pig.bark();
		 System.out.println(pig.name); //부모에도 name이라는 변수가 있지만 은닉된다.
		
	}

}

//부모 Class
class Animal {
	String name;
	int age;

	public Animal() {
		this.name = "동물";
		this.age = 0;
	}

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void bark() {
		System.out.println("꿀꿀꿀꿀꿀");
	}

}
