package day0717;

public class ThreadEx2 implements Runnable { //Runnable Interface 상속

	public ThreadEx2() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override // 재정의 된 메서드이기에 throws InterruptedException으로 던지는 것은 불가능하다.
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
		new ThreadEx2();
	}
}
