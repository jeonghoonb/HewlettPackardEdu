package day0704;

import java.util.Scanner;

public class AccessModifierEX1 {
	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Encap encap = new Encap();
		int su1 = encap.a; //a ������ public, �����Ӱ� ����
		int su2 = encap.b; //b ������ protected, ���� ��Ű�������� �����Ӱ� ����, �ٸ� ��Ű���� ��Ӱ��迡�� ���� ���� 
		int su3 = encap.c; //c ������ default, ���� ��Ű�������� �����Ӱ� ����
		//int su4 = encap.d; //d ������ private, ������ �ش� Ŭ���� ���ο����� ���� ����
		//int su4 = encap.getD(); //private ������ ����Ϸ��� getter/setter �޼ҵ�� ���

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
