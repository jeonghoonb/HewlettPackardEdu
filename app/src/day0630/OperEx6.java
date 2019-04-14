package day0630;

public class OperEx6 {

	public static void main(String[] args) {
		
		int a = 0;
		System.out.println(a++ + a++); //0 + 1
		System.out.println(a + --a + ++a); // 2 + 1 + 2
		System.out.println(--a + a++); //1 + 1
		System.out.println(a); //2
		
	}

}
