package day0717;

public class ThreadEx3 {

	public ThreadEx3() {

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
		Thread thread = new Thread(worker);
		thread.start();		
	}

	Runnable worker = new Runnable() {
		@Override
		public void run() {
			try {
				while (true) {
					System.out.println("2 작업 중 ...");
					Thread.sleep(500); // InterruptedException 예외 발생 가능성 존재, sleep()은 매개변수만큼의 시간만큼 cpu를 재우는 것.
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // InterruptException
			
		}
	};
	
	public static void main(String[] args) {
		new ThreadEx3();
	}
}
