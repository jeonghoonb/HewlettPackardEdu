package day0706;

/**
 * ���⼭ Member Class(�ڹٺ�) ���
 */
public class MemberService {
	public Member member;

	public MemberService(String name, String id, String pw) {
		member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		// ���� 1. Member bean Class �� ����� ������ �Է��ؼ� ����Ͻÿ�.(System.in ���)
	}

	public boolean login(String id, String pw) {
		boolean result = false;

		if (isCheckId(id) && isCheckPw(pw)) {
			System.out.println(member.getName() + "�� ȯ���մϴ�.");
			result = true;
		} else {
			System.out.println("�α��� ����");
		}
		return result;
	}

	public boolean isCheckId(String id) {
		if (member.getId().equals(id))
			return true;
		return false;
	}

	public boolean isCheckPw(String pw) {
		if (member.getPw().equals(pw))
			return true;
		return false;
	}

	public void logout(String name) {
		System.out.println(name + "�� �α׾ƿ� �Ǿ����ϴ�.");
		System.out.println("���α׷� ����");
		System.exit(0);
	}

	@Override
	public String toString() {
		return "ȸ�� �̸� : " + member.getName() + " | ȸ�� ID : " + member.getId() + " | ȸ�� PW : " + member.getPw();
	}
}
