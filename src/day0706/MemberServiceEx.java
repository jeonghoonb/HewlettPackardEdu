package day0706;

import java.util.Scanner;

public class MemberServiceEx {

	public static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("=== 사용자 정보 추가 ===");
		System.out.print("이름을 입력하세요. : ");
		String name = input.next();
		System.out.print("ID를 입력하세요. : ");
		String id = input.next();
		System.out.print("PW를 입력하세요. : ");
		String pw = input.next();
		MemberService service = new MemberService(name, id, pw);
		System.out.println("=== 로그인 ===");
		System.out.print("ID를 입력하세요. : ");
		id = input.next();
		System.out.print("PW를 입력하세요. : ");
		pw = input.next();
		boolean result = service.login(id, pw);

		if (result) {
			System.out.println("로그인 되었습니다.");
			service.toString();
			System.out.print("로그아웃 하시겠습니까?(Y / N )");
			switch (input.next()) {
			case "y":
			case "Y":
				System.out.println("Yes");
				service.logout(name);
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
}
