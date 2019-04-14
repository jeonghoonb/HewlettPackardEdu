package Exercise;

import java.util.Scanner;

public class Excercise5_9 {
	public static void main(String[] args) {

		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("\n-------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				System.out.print("학생의 수> ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i +" ] 점수 : ");
					scores[i] = scanner.nextInt();
				}
			} else if (selectNo == 3) {
				System.out.println(" <학생 점수리스트> ");
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "] 점수 : " + scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				int sum = 0;
				double avg = 0;
				for (int score : scores) {
					sum += score;
					if (max < score) max = score;
				}
				avg = (double) sum/selectNo;
				System.out.println(" <분석> ");
				System.out.println("최고 점수는 " + max + ", 평균 점수는 " + avg);
			} else {
				run = false;
				System.out.println("종료되었습니다.");
				System.exit(0);
			}

		}
	}
}