package day0726;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@FunctionalInterface
interface KimChi {
	public void make(String baechu, String gochujang);
	public static void mix(){
		System.out.println("김치 완성");
	}
}

public class LamdaEx extends JFrame {

	JButton b;

	public LamdaEx(){                                                                                                              
		setTitle("Lamda Ex");
		setLayout(new FlowLayout());
		b = new JButton("만들기");
		
		add(b);
		
		final KimChi kc; //final로 선언해야 내부 익명으로 접근 가능
		kc = (String g, String b) -> {
			String result = g + b;
			if(result.equals("고추장배추")){
				KimChi.mix();
			}		
		};
		kc.make("고추장", "배추");
		b.addActionListener((e) -> kc.make("고추장", "배추"));

		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LamdaEx();
	}

}
