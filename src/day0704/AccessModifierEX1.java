package day0704;

import java.util.Scanner;

public class AccessModifierEX1 {
	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Encap encap = new Encap();
		int su1 = encap.a; //a 변수는 public, 자유롭게 접근
		int su2 = encap.b; //b 변수는 protected, 같은 패키지내에서 자유롭게 접근, 다른 패키지의 상속관계에서 접근 가능 
		int su3 = encap.c; //c 변수는 default, 같은 패키지내에서 자유롭게 접근
		//int su4 = encap.d; //d 변수는 private, 오로지 해당 클래스 내부에서만 접근 가능
		//int su4 = encap.getD(); //private 변수를 사용하려면 getter/setter 메소드로 사용

	}

}

class Encap{
	public int a = 10;
	protected int b = 20;
	int c = 30;
	private int d = 40;
	
	
	
//	public int getD() {
//		return d;
//	}
//
//
//
//	public void setD(int d) {
//		this.d = d;
//	}



	public Encap() {
		
	}
}
