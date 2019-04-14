package day0711;

public class Member {
	
	public String id;
	
	Member(String id){
		this.id = id;
	}
		
	@Override
	public boolean equals(Object obj) { //Object로 매개변수 받는 이유는 다형성
		if(obj instanceof Member){
			Member member = (Member)obj;
			if(this.id.equals(member.id)) { //this.id 는 멤버 클래스의 id, member.id는 obj로 들어온 id
				return true;
			}
		}
		return false;

	}
}
