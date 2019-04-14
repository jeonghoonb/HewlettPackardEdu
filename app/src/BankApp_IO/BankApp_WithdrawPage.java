package BankApp_IO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankApp_WithdrawPage extends JDialog implements ActionListener{

	JPanel p1, p2;
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lbAno, lbBalance, lbInBalance;
	JButton btnOk, btnReset;
	JTextField tfAno, tfBalance, tfIn;
	
	BankApp_WithdrawPage(){}
	
	BankApp_WithdrawPage(int i){
		setTitle("WithDraw");
		repaint();
		
		setLayout(new BorderLayout());
		p1 = new JPanel(new GridLayout(1, 2, 10, 10));
		p2 = new JPanel(new GridLayout(1, 2, 10, 10));
		lb1 = new JLabel(" ");
		lb2 = new JLabel(" ");
		lb3 = new JLabel(" ");
		lb4 = new JLabel(" ");
		lb5 = new JLabel(" ");
		lb6 = new JLabel(" ");
		lb7 = new JLabel("   ");
		lb8 = new JLabel(" ");
		
		lbInBalance = new JLabel(" 출금액  ");
		tfIn = new JTextField();
		
		btnOk = new JButton("출금");
		btnReset = new JButton("종료");
		
	
		p1.add(lbInBalance);
		p1.add(tfIn);

		p2.add(btnOk);
		p2.add(btnReset);
	

		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		add(lb3, BorderLayout.EAST);
		add(lb8, BorderLayout.WEST);

		btnOk.addActionListener(this);
		btnReset.addActionListener(this);
		tfIn.addActionListener(this);
		
		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnOk) {
					int money = Integer.parseInt(tfIn.getText());
//					int susu = (int)(money * 0.1);
//					JOptionPane.showMessageDialog(null, "수수료 10% : "+susu);
					if(!BankApp_Service.withdraw(money)) {
						JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
					}else {
						JOptionPane.showMessageDialog(null, money+"원 출금 성공");
					}
					tfIn.setText("");
				}else if(e.getSource() == btnReset) {
					setVisible(false);
				}
			}
		};
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		btnOk.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnReset.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnOk.getActionMap().put("ENTER", ok);
		btnReset.getActionMap().put("ENTER", ok);
		
		setSize(300, 100);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk) {
			int money = Integer.parseInt(tfIn.getText());
//			int susu = (int)(money * 0.1);
//			JOptionPane.showMessageDialog(null, "수수료 10% : "+susu);
			if(!BankApp_Service.withdraw(money)) {
				JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
			}else {
				JOptionPane.showMessageDialog(null, money+"원 출금 성공");
			}
			tfIn.setText("");
		}else if(e.getSource() == btnReset) {
			setVisible(false);
		}
		
	}
}
