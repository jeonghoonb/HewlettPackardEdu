package day0711;

public class MemberEx {

	public static void main(String[] args) {
			Member obj1 = new Member("blue");
			Member obj2 = new Member("blue");
			Member obj3 = new Member("red");
			
			/*
			 * Member Class에서 재정의 한 equals()에 의해 true 반환
			 *  <-> Member Class에서 재정의 한 equals()를 주석 처리하면 false 나온다.
			 * String도 Object 클래스의 equals()를 재정의 해서 사용 : 객체 생성 시 문자열 값이 같으면 true 반환
			 */
			if(obj1.equals(obj2)) System.out.println("obj1 과 obj2는 동등하다");   
			else System.out.println("obj1 과 obj2는 동등하지 않다.");
			
			if(obj1.equals(obj3)) System.out.println("obj1 과 obj3는 동등하다");
			else System.out.println("obj1 과 obj3는 동등하지 않다.");
		}
}
