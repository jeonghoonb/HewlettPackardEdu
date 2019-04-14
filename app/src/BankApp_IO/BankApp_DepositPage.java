package BankApp_IO;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class BankApp_DepositPage extends JDialog implements ActionListener {

	JPanel p1, p2;
	JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lbAno, lbBalance, lbInBalance;
	JButton btnOk, btnReset;
	JTextField tfAno, tfBalance, tfIn;

	public BankApp_DepositPage() {}
	
	public BankApp_DepositPage(int i) {
		setTitle("Deposit");

		setLayout(new GridLayout(2, 1, 10, 10));
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
		lbInBalance = new JLabel(" 입금액  ");
		tfIn = new JTextField();
		
		btnOk = new JButton("입금");
		btnReset = new JButton("종료");

	
		p1.add(lbInBalance);
		p1.add(tfIn);

		p2.add(btnOk);
		p2.add(btnReset);

		add(p1);
	
		add(p2);


		btnOk.addActionListener(this);
		btnReset.addActionListener(this);
		
		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOk) {
					int money = Integer.parseInt(tfIn.getText());
					if(BankApp_Service.deposit(money)) {
						JOptionPane.showMessageDialog(null, money+"원 입금 성공.");
					}
					tfIn.setText("");
				} else {
					setVisible(false);
				}
			}
		};
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		btnOk.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnReset.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnOk.getActionMap().put("ENTER", ok);
		btnReset.getActionMap().put("ENTER", ok);
		
		
		setSize(450, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
	
		
		setSize(300, 100);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	
	}
	public void dispose2(){
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			int money = Integer.parseInt(tfIn.getText());
			if(BankApp_Service.deposit(money)) {
				JOptionPane.showMessageDialog(null, money+"원 입금 성공.");
			}
			tfIn.setText("");
		} else {
			setVisible(false);
		}

	}
}
