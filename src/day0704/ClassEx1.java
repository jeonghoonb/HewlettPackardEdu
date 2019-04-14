package day0704;

public class ClassEx1 {

	public String name;
	public int age;

	public void method1() {
		System.out.println("Method1");
	}

	public String method2() {
		return "Method2";
	}

	public static void main(String[] args) {
		ClassEx1 object = new ClassEx1();
		System.out.println("Name : " + object.name);
		System.out.println("Age : " + object.age);
		object.method1();
		String result = object.method2();
		System.out.println(result);

	}
}
