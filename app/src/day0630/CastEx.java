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
		 * �ڵ� ����ȯ(������ ����ȯ) : ���� ũ�� -> ū ũ�� �⺻Ÿ�Կ����� ���� ����ȯ�� �� ������� �ʴ´�. => ������ �ս� �߻�
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
		 * ���� ����ȯ(ĳ����) : ū ũ�� -> ���� ũ��
		 */
		int b = (int) a; // 10�̶�� �����Ͱ� int�� ������ ���ϱ� ������ ���� ����ȯ�� �ص� ������ �ս��� �Ͼ�� �ʴ´�.
		System.out.println("result :" + b);

		short1 = (short) b;
		// short1 = (byte)b; //�̷��� �ϸ� (int -> byte) 1�� ���� ����ȯ �� (byte -> short) 2�� �ڵ�
		// ����ȯ => �� 2���� ����ȯ�� �ȴ�.
		System.out.println("result :" + b);

	}

}