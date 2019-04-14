package day0706;

/**
 * 여기서 Member Class(자바빈) 사용
 */
public class MemberService {
	public Member member;

	public MemberService(String name, String id, String pw) {
		member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		// 문제 1. Member bean Class 에 사용자 정보를 입력해서 출력하시오.(System.in 사용)
	}

	public boolean login(String id, String pw) {
		boolean result = false;

		if (isCheckId(id) && isCheckPw(pw)) {
			System.out.println(member.getName() + "님 환영합니다.");
			result = true;
		} else {
			System.out.println("로그인 실패");
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
		System.out.println(name + "님 로그아웃 되었습니다.");
		System.out.println("프로그램 종료");
		System.exit(0);
	}

	@Override
	public String toString() {
		return "회원 이름 : " + member.getName() + " | 회원 ID : " + member.getId() + " | 회원 PW : " + member.getPw();
	}
}
