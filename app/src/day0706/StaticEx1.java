package day0706;

public class StaticEx1 {

		public final int A = 10;
		static int b = 20;
		public final void a() {
			
		}
		
		public static void main(String[] args) {
			System.out.print(b = 50); //���� b�� static(����) �����̱⿡ static main()���� ��ü ���� ���� ��� ����, �� ���浵 ����
			
		}
}

/* StaticEx1�� final Class�� �� ��� �Ұ���
class Add extends StaticEx1 {
	
	//StaticEx1 Class�� a()�޼ҵ尡 final�̶�� �������̵� �Ұ���
	public void a(){

	}
*/