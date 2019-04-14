package day0630;

public class CastEx {

	public static void main(String[] args) {

		byte byte1 = 127;
		short short1;
		char char1 = 10;
		int int1;
		long long1;
		float float1;
		double double1;

		/*
		 * 자동 형변환(묵시적 형변환) : 작은 크기 -> 큰 크기 기본타입에서는 강제 형변환은 잘 사용하지 않는다. => 데이터 손실 발생
		 */
		short1 = byte1;
		int1 = short1;
		int1 = char1;
		long1 = int1;
		float1 = int1;
		double1 = long1;

		System.out.println("byte :" + byte1);
		System.out.println("short :" + short1);
		System.out.println("char :" + char1);
		System.out.println("int :" + int1);
		System.out.println("long :" + long1);
		System.out.println("float :" + float1);
		System.out.println("double :" + double1);

		long a = 10;
		/*
		 * 강제 형변환(캐스팅) : 큰 크기 -> 작은 크기
		 */
		int b = (int) a; // 10이라는 데이터가 int의 범위에 속하기 때문에 강제 형변환을 해도 데이터 손실이 일어나지 않는다.
		System.out.println("result :" + b);

		short1 = (short) b;
		// short1 = (byte)b; //이렇게 하면 (int -> byte) 1차 강제 형변환 후 (byte -> short) 2차 자동
		// 형변환 => 총 2번의 형변환이 된다.
		System.out.println("result :" + b);

	}

}