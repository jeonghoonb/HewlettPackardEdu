package day0703;

//ex 1) 입력한 값까지의 홀, 짝수 합 구하기
public class MethodEx2 {

	public static int hol(int su) {
		int sumOdd = 0;
		for(int i=0; i<=su; i++) {
			if(i%2 != 0) {
				System.out.print(i+" ");
				sumOdd+=i;			
			}
		}
		return sumOdd;
	}
	
	public static int jjak(int su) {
		int sumEven = 0;
		for(int i=0; i<=su; i++) {
			if(i%2 == 0) {
				System.out.print(i+" ");
				sumEven+=i;					
			}
		}
		return sumEven;	
	}
	
	public static void main(String[] args) {
		
		int su = Integer.parseInt(args[0]);
		int result = hol(su);
		System.out.println("홀수의 합 결과 : "+result);
		result = jjak(su);
		System.out.println("짝수의 합 결과 : "+result);
	}

}
