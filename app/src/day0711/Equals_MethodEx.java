package day0711;

public class Equals_MethodEx {

	public static void main(String[] args) {

		String str1 = new String("신민철"); // 새로운 객체를 생성
		String str2 = "신민철"; // '신민철' 이라는 문자열을 갖는 객체가 있으면 그 객체를 공유, 없으면 생성
		String str3 = "신민철"; // '신민철' 이라는 문자열을 갖는 객체가 있으면 그 객체를 공유, 없으면 생성

		System.out.println(str1.equals(str2)); // 객체에 저장 된 문자열 자체를 비교
		System.out.println((str1 == str2)); // 객체 비교

		System.out.println(str1.equals(str3)); // 객체에 저장 된 문자열 자체를 비교
		System.out.println((str1 == str3)); // 객체 비교

		System.out.println(str3.equals(str2)); // 객체에 저장 된 문자열 자체를 비교
		System.out.println((str3 == str2)); // 객체 비교, new 없는 String은 문자열이 같으면 동일 객체를 공유
	}
	
}
