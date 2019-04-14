package day0703;

public class MethodEx3 {
	public static void printGuGuDan(int[] dans) {
		for (int a = 0; a < dans.length; a++) {
			int tmp = dans[a];
			for (int i = 1; i <= 9; i++) {	
					System.out.print(tmp+" * "+i+" = "+(i*tmp)+"\t");
			}System.out.println();	
		}System.out.println("=======");
	}

	public static int[] sumGuGuDan() {
		int[] result = new int[8];
		int cnt = 0;
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				result[cnt] += (i * j);
			}
			cnt++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] dans = { 2, 6, 8 };
		printGuGuDan(dans);
		int[] result = sumGuGuDan();
		for (int i = 0; i < result.length; i++) {
			System.out.println((i + 2) + "´ÜÀÇ ÇÕ : " + result[i]);
		}

	}
}
