package day0711;

public class StringBufferEx {
	 public static void main(String[] args) {
	  
	  StringBuffer sb = new StringBuffer();
	  
	  sb.append("Java ");
	  sb.append("Program Study "); //append("") : 매개값을 문자열 뒤에 붙인다.
	  System.out.println(sb.toString());
	  
	  sb.insert(4, "2");  //intsert(4, "2") : 4번째 뒤에 "2"를 삽입
	  System.out.println(sb); //sb뒤에 toString 생략
	  
	  sb.setCharAt(4, '6'); //4번째 뒤의 문자를 '6'으로 변환
	  System.out.println(sb.toString());
	  
	  sb.replace(6, 13, "Book"); //6뒤붜 13번째까지 book으로 변환
	  System.out.println(sb);
	  
	  sb.delete(4, 5); //4 뒤에부터 5까지 삭제
	  System.out.println(sb);
	  
	  int length = sb.length();
	  System.out.println("총 문자수 : "+length);
	  
	  String result = sb.toString();
	  System.out.println(result);
	  
	 }
	}
