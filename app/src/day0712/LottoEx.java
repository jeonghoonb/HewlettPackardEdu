package day0712;

import java.util.Arrays;

public class LottoEx {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		int cnt = 0;
		int no = 0;
		int c = 0;
		do {
			no = (int) (Math.random() * 6) + 1;
			if (cnt == 0) {
				lotto[cnt] = no;
				cnt++;
			} else {
				for (int i = 0; i <lotto.length; i++) {
					if (lotto[i] != no) {
						c++;
						System.out.println("가");
						if(c==6) {
							lotto[cnt] = no;
							cnt++;
							break;
						}
					}
				}
			}

		} while (cnt != 6);
		
		Arrays.sort(lotto);
		for (int a : lotto) {
			System.out.print(a + " ");
		}

	}
}

