package day0630;

import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("수를 입력하시오.(1 ~ 10)");
		int su = scan.nextInt();

		switch (su) {
		case 1:
			System.out.println("실행 구문1");
			break;
		case 2:
			System.out.println("실행 구문2");
			break;
		case 3:
			System.out.println("실행 구문3");
			break;
		default:
			System.out.println("실행 구문4");
			break;
		}

	}

}
