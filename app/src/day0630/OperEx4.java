package day0630;

public class OperEx4 {

	public static void main(String[] args) {

		int su1 = 10;
		int su2 = 20;
		

		boolean result1 = su1 < su2;
		System.out.println(result1);

		boolean result2 = su1 > su2;
		System.out.println(result2);

		boolean result3 = result1 | result2;
		System.out.println(result3);
		
		/*
		//su1<su2가 참이라서 결과가 무조건 참이지만 뒤쪽 까지 실행. 그래서 su1이 5로 변한다.
		boolean result4 = su1 < su2 | (su1 = 5) > su2;
		System.out.println(result4);
		System.out.println("su1 변함:" + su1);
		 */
		
		
		//su1<su2가 참이면 결과는 무조건 참. 그래서 뒤쪽은 실행하지 않는다. 그래서 su1가 5로 변하지 않는다.
		boolean result4 = su1 < su2 || (su1 = 5) > su2;
		System.out.println(result4);
		System.out.println("su1 변하지 않음:" + su1); 
		
		
		//su1>su2가 거짓이면 결과는 무조건 거짓. 그래서 뒤쪽은 실행하지 않는다. 그래서 su2가 10으로 변하지 않는다.
		boolean result5 = su1 > su2 && su1 < (su2 = 5 + 5);
		System.out.println(result5);
		System.out.println("su2 :" + su2);

	}

}
