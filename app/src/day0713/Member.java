package day0713;

public class Member {
	String name;
	int age;
	
	Member(String name, int age){
		this.name = name;
		this.age = age;
	}
/*	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			return member.name.equals(name) && (member.age==age);
		}else {
			return false;
		}
	
	}
	*/
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
