package day0703;

public class ArrayEx2 {
	public static void main(String[] args) {

		int[][] arr = new int[3][2];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[1][0] = 3;
		arr[1][1] = 4;
		arr[2][0] = 5;
		arr[2][1] = 6;
		
		// 2��° for���� ���ǽ� �߿�!!, ��ü �迭�� ���� length�� �ƴ� Ư�� �࿡ ���� ���� ������ ���ǽ��� �ؾ��� ������ ���� �ʴ´�.
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "][" + j + "] :" + arr[i][j]);
			}
		}
		System.out.println("================");
		for(int[] i: arr) {
			for(int j : i) {
				System.out.println("arr[" + j + "] :" +j);
			}
		}
		
		


	}
}
