package day0630;

import java.util.Scanner;

public class ForEx2_Gugudan {
	public static void main(String[] args) {
		
		System.out.print("몇 단까지 출력하시겠습니까 ? ");
		int dan = new Scanner(System.in).nextInt();
		
		System.out.println("\n구구단 가로 ");
		for (int i = 2; i <= dan; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " x " + j + " = " + (i * j) + "\t");
			}
			System.out.println();
		}

		System.out.println("\n구구단 세로");
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= dan; j++) {
				System.out.print(j + " x " + i + " = " + (i * j) + "\t");
			}
			System.out.println("");
		}

	}
}