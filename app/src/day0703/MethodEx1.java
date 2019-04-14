package day0703;

public class MethodEx1 {

	public static int intA() {
		int num = 10;
		System.out.println("intA 메소드 실행");
		return num;
	}

	public static void intB() {
		System.out.println("intB 메소드 실행");
	}

	public static void main(String[] args) {
		int result = intA();
		//long result = intA(); 일 때, int -> long로 자동으로(묵시적) 형변환
		System.out.println("intA() 실행 결과 result : "+result);
		
		intB();
	}
}
