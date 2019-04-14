package day0706;

/**
 * 내부 클래스 예제
 */
public class ABC {
	public String msg = "A";

	public void print() {
		BC bc = new BC();
		bc.print();
	}

	// ABC 내부의 BC Class
	public class BC {
		public String msg = "B";

		public void print() {
			C c = new C();
			c.print();
		}

		// ABC 내부의 BC, BC 내부의 C Class
		public class C {
			public String msg = "C";

			public void print() {
				System.out.println(msg);
				System.out.println(this.msg);
				System.out.println(C.this.msg);
				System.out.println(BC.this.msg);
				System.out.println(ABC.this.msg);
			}
		}
	}

	public static void main(String[] args) {
		ABC abc = new ABC();
		abc.print();
	}

}
