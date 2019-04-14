package day0717;

public class ExceptionEx2 {
	public static void main(String[] args) {

		Dog dog = new Dog();
		changeDog(dog);

		Cat cat = new Cat();
		changeDog(cat); // 여기 실행 시 예외 발생

	}

	public static void changeDog(Animal animal) {
		// if(anmail instanceof Dog) {
		Dog dog = (Dog) animal; // ClassCastException 발생 가능
		// }
	}
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}
