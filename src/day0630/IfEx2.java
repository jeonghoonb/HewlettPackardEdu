package day0630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IfEx2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("���� �Է� (1 ~ 100) :");
		int score = scan.nextInt();

		/*
		// ex)1
		if (score > 50 && score < 81) {
			System.out.println("���� ���� 1");
		} else if (score < 91) {
			System.out.println("���� ���� 2");
		}
		
		
		// ex)2
		if (score > 50 && score < 81) {
			System.out.println("���� ���� 1");
		} else {
			System.out.println("���� ���� 2");
		}

		if (score > 80 && score < 91) {
			System.out.println("���� ���� 3");
		} else {
			System.out.println("���� ���� 4");
		}
		*/
		

		// ex)3
		if(score > 100) {
			System.out.println("����");
		}else if(score >= 81) {
			System.out.println("A");
		}else if(score >= 61) {
			System.out.println("B");
		}else {
			System.out.println("C");
		}

		
	}
	
}
