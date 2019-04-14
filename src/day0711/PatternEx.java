package day0711;

import java.util.regex.Pattern;

public class PatternEx {
 
 public static void main(String[] args) {
  String regExp = "(02|010)-\\d{3,4}-\\d{4}"; //02또는03 // 3~4자리의 숫자    // 4자리 수
  String data = "010-123-4328";
  boolean result = Pattern.matches(regExp, data);
  
  if(result) System.out.println("일치");
  else System.out.println("불일치");
 
  regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
  data = "angel@naver.com";
  result = Pattern.matches(regExp, data);
  
  if(result) System.out.println("일치");
  else System.out.println("불일치");
 }
} 
