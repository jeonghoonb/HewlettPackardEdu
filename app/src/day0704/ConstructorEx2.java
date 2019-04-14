package day0704;

public class ConstructorEx2 {
	
	//기본 생성자
	ConstructorEx2(){
		this(50, "홍길동"); //int와 String을 매개변수로 갖는 생성자 호출,  this()는 생성자 첫 줄에 위치해야 한다.
		System.out.println("Constructor 1"); //위의 생성자 호출이 끝난 후 실행
	}
	
	//실행X
	ConstructorEx2(int a){
		System.out.println("Constructor 2 => a : "+a);
	}
	
	ConstructorEx2(int a, String s){
		System.out.println("Constructor 3 => a: "+a+" , s : "+s);
	}
	
	public static void main(String[] args) {
		System.out.println("Test");
		new ConstructorEx2();

	}

}
