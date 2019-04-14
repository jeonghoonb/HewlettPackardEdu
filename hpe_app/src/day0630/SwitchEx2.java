package day0630;

import java.util.Scanner;

public class SwitchEx2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Yes[y/Y] / No[n/N] ? ");
		String c = scan.next();

		switch (c) {
		case "y":
		case "Y":
			System.out.println("Yes");
			break;

		case "n":
		case "N":
			System.out.println("No");
			break;

		default:
			System.out.println("Wrong Answer");
			break;
		}

	}

}
