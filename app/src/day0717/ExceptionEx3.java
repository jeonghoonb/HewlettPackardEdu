package day0717;

public class ExceptionEx3 {

	String str = "";

	public void foo(int i) {
		try {
			if (i == 1) {
				throw new Exception(); // 예외 발생 시 나머지 try{} 부분은 생략하고 catch{}로 이동
			}
			str += "1";
		} catch (Exception e) { // try{}에서 예외 발생 시 catch{}로 이동해 와서 실행
			str += "2";
			return; // 강제 종료지만, 예외 처리 상 finally{}는 반드시 실행
		} finally {
			str += "3";
		}
		str += "4"; // catch{} 블록에 return이 없으면 실행 되는데 있어서 실행 X
	}

	public static void main(String[] args) {
		ExceptionEx3 ee = new ExceptionEx3();
		ee.foo(0);
		ee.foo(1);
		System.out.println(ee.str);
	}
}

