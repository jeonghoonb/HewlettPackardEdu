package day0707;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTExercise2 extends Frame implements ItemListener {

	Panel p1, p2, p3;
	CheckboxGroup cbg;
	Checkbox cb1, cb2, cb3, rb1, rb2, rb3;
	TextArea ta;
	Choice ch;
	Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;

	// 기본 생성자로 객체 생성 및 초기화 진행
	public AWTExercise2() {
		super("AWT Item Exercise");

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		cbg = new CheckboxGroup();
		cb1 = new Checkbox("사과", false);
		cb2 = new Checkbox("딸기", false);
		cb3 = new Checkbox("배", false);
		rb1 = new Checkbox("아침", true, cbg);
		rb2 = new Checkbox("점심", false, cbg);
		rb3 = new Checkbox("저녁", false, cbg);
		ta = new TextArea("", 10, 10, TextArea.SCROLLBARS_NONE);
		lb1 = new Label(" ");
		lb2 = new Label(" ");
		lb3 = new Label(" ");
		lb4 = new Label(" ");
		lb5 = new Label(" ");
		lb6 = new Label(" ");
		lb7 = new Label(" ");
		lb8 = new Label(" ");
		lb9 = new Label(" ");
		lb10 = new Label(" ");
		ch = new Choice();

		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");

		// 레이아웃 설정
		p1.setLayout(new GridLayout(2, 4));
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());

		// 컴포넌트 추가
		p1.add(lb9);
		p1.add(rb1);
		p1.add(rb2);
		p1.add(rb3);
		p1.add(lb10);
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);

		p2.add(lb1, BorderLayout.NORTH);
		p2.add(lb2, BorderLayout.SOUTH);
		p2.add(lb3, BorderLayout.EAST);
		p2.add(lb4, BorderLayout.WEST);
		p2.add(ta, BorderLayout.CENTER);

		p3.add(lb5, BorderLayout.NORTH);
		p3.add(lb6, BorderLayout.SOUTH);
		p3.add(lb7, BorderLayout.EAST);
		p3.add(lb8, BorderLayout.WEST);
		p3.add(ch, BorderLayout.CENTER);

		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);

		// 이벤트 메서드 호출
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		ch.addItemListener(this);

		ta.setBackground(Color.CYAN);
		setSize(500, 500);
		setVisible(true);
		setLocation(1000, 300);

		// AWT 닫기 메서드
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	// 아이템 항목 이벤트 메서드
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();

		if (obj == ch) {
			String str = ch.getSelectedItem();
			if (str.equals("아침"))
				rb1.setState(true);
			else if (str.equals("점심"))
				rb2.setState(true);
			else if (str.equals("저녁"))
				rb3.setState(true);
		}

		// 라디오 버튼을 누를 경우 선택한 객체를 temp에 반환
		Checkbox temp = cbg.getSelectedCheckbox();

		ta.setText("  << " + temp.getLabel() + "  >> \n\n");
		ta.append("1. 사과 : " + cb1.getState() + "\n");
		ta.append("2. 딸기 : " + cb2.getState() + "\n");
		ta.append("3. 배 : " + cb3.getState() + "\n");
		
		//선택된 라디오버튼의 Label, 즉 문자열 값을 choice로 설정
		ch.select(temp.getLabel());

		// if (obj == rb1) { // 라디오버튼 '아침' 메서드
		// ta.setText("");
		// ta.append("<<" + rb1.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// ch.select("아침");
		// } else if (obj == rb2) { // 라디오버튼 '점심' 메서드
		// System.out.println("rb2");
		// ta.setText("");
		// ta.append("<<" + rb2.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// ch.select("점심");
		// } else if (obj == rb3) {// 라디오버튼 '저녁' 메서드
		// ta.setText("");
		// ta.append("<<" + rb3.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// ch.select("저녁");
		// } else if (obj == cb1) { // 체크박스 '사과' 메서드
		// if (rb1.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb1.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (rb2.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb2.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (rb3.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb3.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// }
		// } else if (obj == cb2) {
		// if (rb1.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb1.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (rb2.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb2.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (rb3.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb3.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// }
		// } else if (obj == cb3) {
		// if (rb1.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb1.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (rb2.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb2.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (rb3.getState()) {
		// ta.setText("");
		// ta.append("<<" + rb3.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// }
		// } else if (obj == ch) {
		// Choice choice = (Choice) obj;
		// if (choice.getSelectedItem().equals("아침")) {
		// rb1.setState(true);
		// ta.setText("");
		// ta.append("<<" + rb1.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (choice.getSelectedItem().equals("점심")) {
		// rb2.setState(true);
		// ta.setText("");
		// ta.append("<<" + rb2.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// } else if (choice.getSelectedItem().equals("저녁")) {
		// rb3.setState(true);
		// ta.setText("");
		// ta.append("<<" + rb3.getLabel() + ">>\n\n");
		// ta.append("1. 사과 : " + cb1.getState() + "\n");
		// ta.append("2. 딸기 : " + cb2.getState() + "\n");
		// ta.append("3. 배 : " + cb3.getState() + "\n");
		// }
		// }

	}

	public static void main(String[] args) {
		new AWTExercise2();
	}
}