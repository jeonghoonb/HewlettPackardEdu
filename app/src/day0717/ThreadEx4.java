package day0717;

public class ThreadEx4 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("작업중(일) ...["+i+"]");
		}
		System.out.println("작업이 완료 되었습니다.");
	}
	
	public static void main(String[] args) {
		ThreadEx4 thread = new ThreadEx4();
		thread.start();
		
		for(int i = 0; i < 10; i ++) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Main 작업중(일)["+i+"]");
		}
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Main2 작업중(일)");
		}
	}
}
