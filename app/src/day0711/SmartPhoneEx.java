package day0711;

public class SmartPhoneEx {
	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("구글", "안드로이드");

		/*
		 * SmartPhone Class에서 재정의 한 toString() 호출 
		 * SmartPhone Class에서 toString()를 주석처리하면 Object Class의 toString() 호출 
		 */
		String strObj = myPhone.toString(); 
		System.out.println(strObj);
		System.out.println(myPhone); //myPhone.toStrin()인데 객체 일 때는 toString()이 자동 생략
	}
}
