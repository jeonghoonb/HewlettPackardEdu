package day0630;

import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("���� �Է��Ͻÿ�.(1 ~ 10)");
		int su = scan.nextInt();

		switch (su) {
		case 1:
			System.out.println("���� ����1");
			break;
		case 2:
			System.out.println("���� ����2");
			break;
		case 3:
			System.out.println("���� ����3");
			break;
		default:
			System.out.println("���� ����4");
			break;
		}

	}

}
