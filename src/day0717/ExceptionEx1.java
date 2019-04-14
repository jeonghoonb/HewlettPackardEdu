package day0717;

public class ExceptionEx1 {
	public static void main(String[] args) {
		try {
			int[] array = new int[3];
			array[0] = 0;
			array[1] = 10;
			array[2] = 20;

			for (int i = 0; i < array.length + 1; i++) { //범위를 벗어나게 설정
				System.out.println("Array[" + i + "] = " + array[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//System.out.println(e.toString()); //어떤 예외가 발생했는지 출력
			System.out.println(e.getMessage()); //
			//e.printStackTrace(); //어떤 예외가 발생했는지, 어디서 발생했는지 추적
			return;
		} finally {
			System.out.println("finally 실행");
		}
	}
}
