package Exercise;

public class Excercise4_5 {
	public static void main(String[] args) {
		
		System.out.print("4x + 5y = 60�� �� : ");
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if ((4 * i) + (5 * j) == 60) {
					System.out.print(i+", "+j + "/\t");
				}
			}
		}
	}
}
