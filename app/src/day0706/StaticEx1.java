package day0706;

public class StaticEx1 {

		public final int A = 10;
		static int b = 20;
		public final void a() {
			
		}
		
		public static void main(String[] args) {
			System.out.print(b = 50); //변수 b가 static(정적) 변수이기에 static main()에서 객체 생성 없이 사용 가능, 값 변경도 가능
			
		}
}

/* StaticEx1이 final Class일 때 상속 불가능
class Add extends StaticEx1 {
	
	//StaticEx1 Class의 a()메소드가 final이라면 오버라이드 불가능
	public void a(){

	}
*/