package day0711;

/*
 * String Class의 Method 예제 
 */
public class StringEx {

	public static void main(String[] args) {

		Object o = "Obj"; // Object <- String 자동 형 변환 : 객체 생성
		String s = "Obj"; //o라는 객체와 데이터 값이 같아서 객체 공유
		String s2 = "Obj"; //o라는 객체와 데이터 값이 같아서 객체 공유
		String z = "null";
		String d = " ";

		if (o instanceof Object) {
			System.out.println("ok!\n"); // ok!
		}
		System.out.println(o); // Obj
		System.out.println(z = o.toString()); // Obj
		System.out.println(s.equals(d)); // false
		System.out.println(o == s); // true

		o = s;

		String s3 = new String("Obj"); //새로운 객체 생성
		System.out.println("결과 1 : " + (s == s3)); // 결과 1 : false => 객체 비교, 서로 다른 객체다
		System.out.println("결과 1 : " + s.equals(s3)); // 결과 2 : true => 객체에 저장된 문자열 자체를 비교, Obj로 같다.
		System.out.println("\n///////////////\n");
		
		String str1 = "ABCDEFG";
		String str2 = "가나다라마바사";

		char c = str1.charAt(3); //String.charAt(i) : String 문자열에서 i번째의 char를 반환 (0부터 시작)
		System.out.println(c); //D

		String con = str1.concat(str2); //str1.concat(str2) : str1의 문자열 뒤에 str2의 문자열을 이어서 합친다.
		System.out.println(con); //ABCDEFG가나다라마바사

		boolean state = str1.equals(str2); //객체에 저장된 문자열 자체 비교, ABCED와 가나다라 서로 다르다.
		System.out.println(state); //false

		int leng = str1.length(); //length() 문자열 길이 반환
		System.out.println(leng); //7

		String rep = str1.replace('F', 'Z'); //replace('F', 'Z') : 문자열의 char 값 중 F를 Z로 변환하여 반환 
		System.out.println(rep); //ABCDEZG 

		String repall = str1.replaceAll("ABC", "XYZ"); //replaceAll("ABC", "XYZ") : 문자열의 "ABC"를 "XYZ"로 변환하여 반환
		System.out.println(repall); //XYZDEFG

		String sub1 = str1.substring(2); //substring(i) : 문자열의 앞에 i개의 char를 제거하고 반환
		System.out.println(sub1); //CDEFG

		String sub2 = str1.substring(2, 5); //substring(i, j) : 문자열의 앞으 i개를 제거하고, 그 자리부터 (j-i)개의 문자를 출력
		System.out.println(sub2); //CDE

		String empty = "      ab c     ";
		System.out.println(empty); //    ab c   

		String tr = empty.trim(); //trim() : 앞 뒤 공백 제거
		System.out.println(tr); //ab c
		
		//str1 : ABCDEFG
		for (int i = 0; i < str1.length(); i++) { 
			if (str1.charAt(i) == (char) 65 || str1.charAt(i) == (char) 69) //ASCII Code 65 = A, 69 = E
				System.out.println(">>> " + str1.charAt(i));
				//>>> A
				//>>> E
		}
	}

}
