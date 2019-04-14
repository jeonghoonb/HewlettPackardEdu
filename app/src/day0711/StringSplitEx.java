package day0711;

public class StringSplitEx {
	 
	 public static void main(String[] args) {
	  
	  String text = "홍길동&이수홍,박연수,김자바-최명호";
	  String[] names = text.split("&|,|-"); //split("") : 매개변수로 주어진 값을 구분자로 문자열을 구분하여 배열로 반환, 복수 매개변수 가능('|'로 표현)
	  
	  for(String name : names) System.out.println(name);
	  
	 }
	} 

	 
