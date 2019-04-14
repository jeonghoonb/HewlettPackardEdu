package Exercise;

import java.util.Scanner;

public class Excercise5_9_1 {

	public Scanner scan;
	public Student[] list;

	public Excercise5_9_1() {
		scan = new Scanner(System.in);
	}
	
	/*
	 *  boolean 또는 int를 반환형으로 사용하여 작성해도 가능하다.
	 * */
	public void  addStudent() {
		for(int i=0; i<list.length; i++) {
			System.out.print("학생 이름 입력 : ");
			String name = inpiutStr();
			System.out.print("학생 점수 입력 : ");
			int score = inputNum();
			list[i] = new Student(name, score);
		}

	}
	
	public int inputNum() {
		return scan.nextInt(); // Scanner.nextInt() : 정수형 입력
	}

	public String inpiutStr() {
		return scan.next(); // Scanner.next() : 문자열 입력 //Scanner.nextLine() : 문자열 입력, 개행 가능
	}

	public void execute() {
		do {
			System.out.println("-------------------------------");
			System.out.println("1.학생수 | 2.점수변경 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------");
			System.out.print("선택> ");

			switch (inputNum()) {
				case 1:
					System.out.print("학생수를 입력하세요 : ");
					int su = inputNum();
					list = new Student[su];
					System.out.println(list.length + "명의 학생들을 추가해주세요.");
					addStudent();
					break;
				case 2:
					Student st = null;
					System.out.print("학생 이름을 입력하세요. : ");
					String name = inpiutStr();
					boolean checked = false;
					for (int i = 0; i < list.length; i++) {
						st = list[i];
						if (st.name.equals(name)) { // equals() : 객체 안에 저장된 문자열 비교 => Student 객체에 해당 이름이 있는지 확인, 이름이 있어야 그  학생의 점수를 입력 가능
							checked = true;
							break; // 해당 이름이 Student 객체에 있으면 for문 벗어난다.
						}
					}
					if (checked) { // 해당 이름이 Student에 있는 경우
						System.out.print(name + "에 점수를 입력하세요. : ");
						st.score = inputNum();
						System.out.print(name+"님의 점수가 "+st.score+"으로 변경되었습니다.\n");
					} else { // 해당 이름이 Student에 없는 경우
						System.out.print(name+"에 대한 정보가 없습니다.");
						break;
					}
					break;
				case 3:
					for(Student student : list) {
						System.out.println(student.name+"의 점수는 "+student.score+"점 입니다.");
					}
					break;
				case 4:
					int max = 0;
					int sum = 0;
					String maxName = "";
					double avg = 0;
					for (Student student : list) {
						sum +=student.score;
						if(max < student.score) {
							max=student.score;
							maxName = student.name;
						}
					}
					avg = (double) sum/list.length;
					System.out.println("\n<분석> ");
					System.out.println("최고 점수는 "+ maxName + "님의 "+ max + "점, 평균 점수는 " + avg+"점 입니다.");
					break;
				default:
					System.out.println("프로그램 종료");
					System.exit(0);
					break;
			}
		} while (true);

	}

	public static void main(String[] args) {
		new Excercise5_9_1().execute();
	}

}

class Student {
	int score;
	String name;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}