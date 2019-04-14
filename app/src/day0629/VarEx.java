package day0629;

public class VarEx {
	public static void main(String[] args) {

		/*
		 * 변수 선언 및 초기화
		 * */
		int su; //변수 선언
		su = 10; //초기값 설정
		System.out.println(su + 10); //su를 숫자로 인식하고 +10 수행
		//System.out.println((su+10));
		
		System.out.println("" + su + 10); //su를 문자열로 인식하고 +10을 수행
		//System.out.println(String.valueOf(su)); // syso()는 int형 변수 su를 String형으로 자동 변환시킨다. String.valueOf() 생략된 것.
		//System.out.println(""+su);
		
		su = 20;
		System.out.println(su);
		
		su = 1;
		System.out.println(su);
		
		String str = "문자열 값";
		System.out.println(str);

		str = "변경된 문자열 값";
		System.out.println(str);
		
		//상수 표현 : final 키워드사용, 이름(식별자)은 대문자로만 구성 => 변하지 않는 수
		//final 키워드는 Class, Method에도 사용이 가능하다.
		final int SU2 = 10;
		System.out.println(SU2);
		
		char ch = 'a';
		int ab = ch;
		System.out.println(ch);
		System.out.println(ab);
		
	}
}
