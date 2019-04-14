package day0711;

import java.util.Arrays;

public class SortEx {
	public static void main(String[] args) {

		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		for (int i = 0; i < scores.length; i++)
			System.out.println("scores[" + i + "] = " + scores[i]);
		System.out.println();

		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++)
			System.out.println("name[" + i + "] = " + names[i]);
		System.out.println();
		
	}
}
