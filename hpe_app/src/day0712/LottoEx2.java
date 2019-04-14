package day0712;

import java.util.Arrays;
import java.util.Random;

public class LottoEx2 {
	public static void main(String[] args) {
		Random r = new Random();
		int a[] = new int[6]; //로또 번호 6개 담을 배열 객체 생성
		
		for(int i=0; i<a.length; i++) {
			a[i] = (int)(Math.random()*45)+1;
			for(int j=0; j<i; j++) {
				if(a[i] ==a[j]) {
					a[i] = r.nextInt(45)+1;
					j=-1;
				}
			}
		}
		
		Arrays.sort(a);
		for(int n : a) {
			System.out.print(n+" ");
		}
	}
}
