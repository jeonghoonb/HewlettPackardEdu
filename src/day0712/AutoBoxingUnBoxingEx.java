package day0712;

public class AutoBoxingUnBoxingEx {
	public static void main(String[] args) {
		
		//과거버전
		int a = Integer.parseInt(args[0]);
		Integer b = new Integer(10);
		int c = b.intValue();
		int sum = a+ c;
		System.out.println("결과 1 : "+sum);
		
		//최신버전 : 자동 
		int d = new Integer(100); //자동 언박싱
		Integer e = 200; //자동 박싱
		int sum2 = d+e; //자동 언박싱
		Integer sum3 = d+e; //자동 박싱
		
		System.out.println("결과 2 : "+sum2);
		System.out.println("결과 3 : "+sum3);
		
//		Integer obj = 100; //자동 박싱
//		System.out.println("value : "+obj.intValue());
//		System.out.println("value : "+obj);
//		
//		int value = obj; //자동 언박싱
//		System.out.println("value : "+value);
//		
//		int result = obj + 100; //연산 시 자동 언박싱
//		System.out.println("result : "+result);
		
	}
}
