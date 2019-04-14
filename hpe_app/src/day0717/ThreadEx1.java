package day0717;

public class ThreadEx1 extends Thread {

	public ThreadEx1() {
		super("첫번째 스레드");
	}

	@Override // 재정의 된 메서드이기에 throws InterruptedException으로  던지는 것은 불가능하다.
	public void run() {
		System.out.println("작업 시작");
		try {
			while (true) {
				System.out.println("작업 중 ...");
				Thread.sleep(1000); // InterruptedException 예외 발생 가능성 존재
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // InterruptException

	}

	public static void main(String[] args) {
		ThreadEx1 thread = new ThreadEx1();
		thread.start(); // Thread Class를 상속받아 run()를 사용, run()사용 시 자동으로 run() 호출
	}
}
