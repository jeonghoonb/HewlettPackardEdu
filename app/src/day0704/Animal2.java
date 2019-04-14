package day0704;

public class Animal2 {
	String name;
	int age;
	
	public Animal2() {
		this.name = "동물";
		this.age = 0;
	}
	
	public Animal2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void bark() {
		System.out.println("울부짖다.");
	}
	
}



