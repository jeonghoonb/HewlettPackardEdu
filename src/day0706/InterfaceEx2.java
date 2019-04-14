package day0706;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InterfaceEx2 {

	public InterfaceEx2() {
		Frame frame = new Frame("Frame Ex");
		frame.setSize(300, 300);
		frame.setVisible(true);
//		frame.addWindowListener(this); //액션 
		
		/*
		 * 14행을 익명 내부 클래스로 표현 
		 * */
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
	}
	
	/*
	 * 이렇게 해도 된다.
	 * */
//		frame.addWindowListener(windowAdapter);
//	}
//	WindowAdapter windowAdapter = new WindowAdapter() {
//		@Override
//		public void windowClosing(WindowEvent e) {
//			System.exit(0);
//		}			
//	};
//	
	public static void main(String[] args) {
		new InterfaceEx2();
	}
	
	

	/**
	 * abstract WindowAdapter Class를 상속 받음
	 * abstract 클래스는 인터페이스의 중간자 역할
	 * 그래서 모든 추상 메서드를 재정의 할 필요가 없고 사용 할 추상 메서드만 재정의
	 * */
//	@Override
//	public void windowActivated(WindowEvent e) {
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//	}
//
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//	}
//
//	@Override
//	public void windowOpened(WindowEvent e) {
//	}

}

