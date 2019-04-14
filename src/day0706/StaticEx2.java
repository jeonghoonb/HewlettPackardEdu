package day0706;

public class StaticEx2 {
	
	public static final int AGE = 10;
	public String name;
	
	public StaticEx2() {
		name = "홍길동";
	}
	
	public StaticEx2(String name) {
		this.name = name;
		//this.AGE = 50; //final이 붙은 상수이기에 값 변경 불가능
	}
	
	public static void main(String[] args) {
		StaticEx2 se = new StaticEx2();
		System.out.print(se.name+"의 나이는 "+AGE);
		StaticEx2 se2 = new StaticEx2("개똥이");
		System.out.print("\n"+se2.name+"의 나이는 "+AGE);
	}
}
