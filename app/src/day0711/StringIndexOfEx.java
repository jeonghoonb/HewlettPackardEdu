package day0711;

public class StringIndexOfEx {
	 public static void main(String[] args) {

	  String subject = "자바 프로그래밍";
	  int location = subject.indexOf("프로그래밍"); //indexOf(" ") : 해당 문자열을 포함하고 있는 첫 Index 숫자 반환
	  System.out.println(location);
	  
	  if (subject.indexOf("자바") != -1)
	   System.out.println("관련된 책");
	  else
	   System.out.println("관련없는 책");

	 }
	}
