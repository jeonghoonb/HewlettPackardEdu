package day0713;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		//Set은 중복 저장 불가능 : 아래는 서로 다른 객체(데이터값이 같은 서로 다른 객체)
		set.add(new Member("홍길동", 30)); 
		set.add(new Member("홍길동", 30));
		
		System.out.println("총 객체수 : "+set.size());
	}
}
