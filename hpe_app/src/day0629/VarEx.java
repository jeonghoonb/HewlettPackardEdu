package day0629;

public class VarEx {
	public static void main(String[] args) {

		/*
		 * ���� ���� �� �ʱ�ȭ
		 * */
		int su; //���� ����
		su = 10; //�ʱⰪ ����
		System.out.println(su + 10); //su�� ���ڷ� �ν��ϰ� +10 ����
		//System.out.println((su+10));
		
		System.out.println("" + su + 10); //su�� ���ڿ��� �ν��ϰ� +10�� ����
		//System.out.println(String.valueOf(su)); // syso()�� int�� ���� su�� String������ �ڵ� ��ȯ��Ų��. String.valueOf() ������ ��.
		//System.out.println(""+su);
		
		su = 20;
		System.out.println(su);
		
		su = 1;
		System.out.println(su);
		
		String str = "���ڿ� ��";
		System.out.println(str);

		str = "����� ���ڿ� ��";
		System.out.println(str);
		
		//��� ǥ�� : final Ű������, �̸�(�ĺ���)�� �빮�ڷθ� ���� => ������ �ʴ� ��
		//final Ű����� Class, Method���� ����� �����ϴ�.
		final int SU2 = 10;
		System.out.println(SU2);
		
		char ch = 'a';
		int ab = ch;
		System.out.println(ch);
		System.out.println(ab);
		
	}
}
