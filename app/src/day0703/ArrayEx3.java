package day0703;

public class ArrayEx3 {
	public static void main(String[] args) {
		
		//ex 1) 배열의 max 값을 구하라.
		System.out.println("ex 1) =======");
		int[] array = { 1, 5, 3, 8, 2 };
		int max = 0;
//		for(int i=0; i<array.length; i++) {
//			if(max<array[i]) { 
//				max = array[i]; 
//		 	} 
//		}		 
		for (int i : array) {
			if (max < i) {
				max = i;
			}	
		}
		System.out.println("최대값은 " + max);
		
		
		//ex 2) 배열의 총합, 평균을 구하라.
		System.out.println("ex 2) =======");
		int[][] array2 = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int total = 0;
		double avg = 0.0;
		int cnt = 0;
//		for(int i=0; i<array2.length; i++) {
//			for(int j=0; j<array2[i].length; j++) {
//				total+=array2[i][j];
//				cnt++;
//			}
//		}
		for(int[] i : array2) {
			for(int j : i) {
				total+=j;
				cnt++;
			}
		}
		avg = (double)total / cnt;
		System.out.println("total : "+total);
		System.out.println("avg : "+ avg);		
	}
}
