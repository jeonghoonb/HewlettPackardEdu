package day0711;

import java.util.Arrays;

public class ArrayCopyEx {
	public static void main(String[] args) {
		char[] arr1 = { 'J', 'A', 'V', 'A' };
		
		//방법1
		char[] arr2 = Arrays.copyOf(arr1, arr1.length); //Arrays.copyOf(배열, 길이) : 매개변수의 배열을 특정 길이만큼만 복사
		System.out.println(Arrays.toString(arr2));
		
		//방법2
		char[] arr3 = Arrays.copyOfRange(arr1, 1, 3); //Arrays.copyOfRange(배열, 시작인덱스, 끝인덱스) : 매개변수의 배열을 시작부터 끝 인덱스까지 복사
		System.out.println(Arrays.toString(arr3));

		//방법3
		char[] arr4 = new char[arr1.length]; //복사할 배열만큼의 배열 객체를 생성
		System.arraycopy(arr1, 0, arr4, 0, arr1.length);
		for (int i = 0; i < arr4.length; i++)
			System.out.println("arr[" + i + "] = " + arr4[i]);

	}
}
