package day0712;

import java.util.Random;

public class MathRandomEx {
	public static void main(String[] args) {
		
		//Math.random() 사용
		int num = (int)(Math.random()*6)+1;
		System.out.println("주사위 눈 : "+num);
		
		//Random 사용
		Random r = new Random();
		for(int i = 0; i<2; i++) {
			float a = r.nextFloat();
			System.out.println("Float : "+a);
			int b = r.nextInt(); //매개변수로 숫자 넣으면 해당 범위 : 3입력시 0,1,2 나올 수 있다.
			System.out.println("Float : "+b);
			boolean c = r.nextBoolean();
			System.out.println("Float : "+c);
			
		}
	}
}
