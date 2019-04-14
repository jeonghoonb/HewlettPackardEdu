package day0706;

import java.util.Scanner;

public class MemberServiceEx {

	public static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("=== ����� ���� �߰� ===");
		System.out.print("�̸��� �Է��ϼ���. : ");
		String name = input.next();
		System.out.print("ID�� �Է��ϼ���. : ");
		String id = input.next();
		System.out.print("PW�� �Է��ϼ���. : ");
		String pw = input.next();
		MemberService service = new MemberService(name, id, pw);
		System.out.println("=== �α��� ===");
		System.out.print("ID�� �Է��ϼ���. : ");
		id = input.next();
		System.out.print("PW�� �Է��ϼ���. : ");
		pw = input.next();
		boolean result = service.login(id, pw);

		if (result) {
			System.out.println("�α��� �Ǿ����ϴ�.");
			service.toString();
			System.out.print("�α׾ƿ� �Ͻðڽ��ϱ�?(Y / N )");
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
