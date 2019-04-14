package day0717;

import java.awt.Toolkit;

public class ThreadEx3_1 {

	public ThreadEx3_1() {

		new Thread(new Runnable() { // Runnable Interface를 내부 익명Class로 사용
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("1 작업 중 ...");
						Thread.sleep(500); // InterruptedException 예외 발생 가능성 존재, sleep()은 매개변수만큼의 시간만큼 cpu를 재우는 것.
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // InterruptException
			}
		}).start();
		Thread thread = new Thread(beepSound);
		thread.start();
	}

	Runnable beepSound = new Runnable() {
		@Override
		public void run() {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			try {
				while (true) {
					toolkit.beep();
					Thread.sleep(500); // InterruptedException 예외 발생 가능성 존재, sleep()은 매개변수만큼의 시간만큼 cpu를 재우는 것.
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // InterruptException
		}
	};

	public static void main(String[] args) {
		new ThreadEx3_1();
	}
}
