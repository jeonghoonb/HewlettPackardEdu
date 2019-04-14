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
//		frame.addWindowListener(this); //�׼� 
		
		/*
		 * 14���� �͸� ���� Ŭ������ ǥ�� 
		 * */
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
	}
	
	/*
	 * �̷��� �ص� �ȴ�.
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
	 * abstract WindowAdapter Class�� ��� ����
	 * abstract Ŭ������ �������̽��� �߰��� ����
	 * �׷��� ��� �߻� �޼��带 ������ �� �ʿ䰡 ���� ��� �� �߻� �޼��常 ������
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

