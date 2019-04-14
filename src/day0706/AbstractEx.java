package day0706;

public class AbstractEx extends Abs {
	public static void main(String[] args) {
		AbstractEx abstractEx = new AbstractEx();
		Abs abs = abstractEx;
		abs.setA();
		System.out.println(abs.getA());
	}

	//부모 Class의 abstract 메서드를 모두 재정의 해야 에러가 나지 않는다.
	@Override
	public int getA() {	
		System.out.println("추상 메서드 재정의.....");
		return 100;
	}
}

//abstract 메서드를 가지면 무조건 추상클래스
//일반 클래스는 abstract 메서드 가질 수 없다.
abstract class Abs{
	int a = 10;
	public void setA() {
		System.out.println("일반 메서드 실행");
	}
	
	public abstract int getA();
}