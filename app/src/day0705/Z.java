package day0705;

class X {
	protected int i = 10;
	protected String msg = "I am an X.";

	public void print() {
		System.out.println("X_Print : " + msg);
	}

	public void play() {
		System.out.println("X_Play : " + msg);
	}
}


class Y extends X {
	protected int i = 20;
	protected String msg = "I am an Y.";

	public void print() {
		System.out.println("Y_Print : " + msg);
	}
}


public class Z extends Y {
	protected int i = 30;
	protected String msg = "I am an Z.";

	public void print() {
		System.out.println("Z_Print : " + msg);
	}

	public void play() {
		System.out.println("Z_Play : " + msg);
	}
	
	public void doZ() {
		System.out.println("do something in Z.");
	}
	
	public void test(int i) {
		Z z = new Z();
		Y y = z; //z가 자식이니깐 부모y로 형변환 가능
		X x = z; //z가 자식이니깐 부모y의 부모x로 형변환 가능
		
		z.print(); //z에서 재정의
		y.print(); //z에서 재정의 해서 z에서 재정의한 기능으로 호출
		x.print(); //z에서 재정의 해서 z에서 재정의한 기능으로 호출
		super.print(); //z의 부모인 y에서 재정의한 메서드로 호출
		System.out.println();
		
		play(); //z에서 재정의한 메서드 호출
		super.play(); //부모인 Y에 play()메서드가 없다, 그 위 계층인 X의 play() 호출
		
		//y.doZ(); //부모 y는 자식 z의 메서드 사용 불가능
		
		System.out.println("\ni = "+i); //그냥 i는 test()메서드로 들어온 매개변수 i
		System.out.println("this.i = "+this.i); //this.i는 현재 클래스 Z의 i
		System.out.println("super.i = "+super.i); //super.i는 현재 클래스 Z의 부모인 Y의 i
		
		System.out.println("\ny.i = "+y.i); //y.i는 Y 클래스의 객체의 i
		System.out.println("x.i = "+x.i); //x.i는 X 클래스의 객체의 i
		
		System.out.println("\n((Y)this).i = "+((Y)(this)).i); //Y로 형변환 후 this.i니깐 Y의 i
		System.out.println("((X)this).i = "+((X)this).i); //X로 형변환 후 this.i니깐 X의 i
	}
	
	public static void main(String[] args) {
		Z z = new Z();
		z.test(15);
	}
}
