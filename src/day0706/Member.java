package day0706;

/**
 * 자바빈 패턴(디자인 패턴) : MVC 패턴에서 M(Model)의 역할 로직부분을 분리한 것 멤버변수의 접근제어자는 private
 * getter/setter 메소드로 접근
 */
public class Member {
	private String name;
	private String id;
	private String pw;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
