package day0706;

abstract class Animal3 {
	int age;
	String name;
	int leg;

	abstract void bark();
	abstract void isLeg();
}

class Chicken extends Animal3 {

	public Chicken() {
		age = 10;
		name = "´ß";
		leg = 2;
	}

	@Override
	void bark() {
		System.out.println("~²¿~³¢~¿À~");
	}

	@Override
	void isLeg() {
		System.out.println(name+"ÀÇ ´Ù¸®´Â "+leg+"°³");
	}
}

public class AbstractEx2 {

	public static void main(String[] args) {
		Chicken chicken = new Chicken();
		System.out.println("Chicken : "+chicken.name);
		System.out.println("Chicken : "+chicken.age);
		chicken.bark();
		chicken.isLeg();
	}
}