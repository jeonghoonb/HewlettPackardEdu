package day0711;

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		/*String str = "자바 SE,자바 EE,자바 ME";
		String delim = args[0];
		StringTokenizer st;
		//st = new StringTokenizer(str, delim, false);
		st = new StringTokenizer(str, delim, true); //true로 하면 구분자도 토큰으로 포함하여 처리
		System.out.println("총 토큰 : "+st.countTokens());
		int count = 0;
		while (st.hasMoreTokens()) {
			System.out.print("남은 토큰 : "+st.countTokens());
			System.out.println(" / 자바과정" + ++count + " : " + st.nextToken());
		}
		System.out.println(st.countTokens());*/
		
		StringTokenizer st1, st2;
		
		String data = "1|3.29|java";
		String delim = "|";
		
		st1 = new StringTokenizer(data, delim, false);
		
		while(st1.hasMoreTokens()) {
			if(st1.countTokens()==3) System.out.println("Id : "+st1.nextToken());
			else if(st1.countTokens()==2) System.out.println("Price : "+st1.nextToken());
			else System.out.println("Username : "+st1.nextToken());
		}
		
		System.out.println("**********");
		
		data = "2|4.345|eclipse";
		st2 = new StringTokenizer(data, delim, false);
		while(st2.hasMoreTokens()) {
			if(st2.countTokens()==3) System.out.println("Id : "+st2.nextToken());
			else if(st2.countTokens()==2) System.out.println("Price : "+st2.nextToken());
			else System.out.println("Username : "+st2.nextToken());
		}
	}
}
