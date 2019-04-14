package day0717;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import org.w3c.dom.events.MouseEvent;

public class ThreadRectDraw extends Frame implements Runnable {

	int x = 0;
	int y = 20;
	boolean xOrient, yOrient;

	public ThreadRectDraw(String str) {
		super(str); //AWT 창 이름 설정
		setSize(300, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent e) {
				System.out.println("마우스 움직임");
			}
			
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				System.out.println("마우스 드래그");
			}
		});
	}

	public void paint(Graphics gr) {
		Random random = new Random(); 
		Dimension d = this.getSize(); //현재 AWT의 크기를 동적으로 받아온다.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		if (xOrient) {
			x--;
			if (x < 0) {
				x = 0;
				xOrient = false;
				toolkit.beep();
			}
		} else {
			x++;
			if (x >= d.width - 20) { //AWT의 width에서 그리는 정사각형의 가로길이(20)을 뺀 만큼
				x = d.width - 20;
				xOrient = true;
				toolkit.beep();
			}
		}

		if (yOrient) {
			y--;
			if (y < 0) {
				y = 0;
				yOrient = false;
				toolkit.beep();
			}
		} else {
			y++;
			if (y >= d.height - 20) {
				y = d.height - 20;
				yOrient = true;
				toolkit.beep();
			}
		}
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		gr.setColor(new Color(r, g, b));
		gr.drawRect(x, y, 20, 20);
	}
	
	public void update(Graphics g){
		paint(g);
	}

	@Override
	public void run() {
		while(true){
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
			ThreadRectDraw thread = new ThreadRectDraw("ThreadRectDraw");
			Thread t1 = new Thread(thread);
			t1.start();
	}

}
