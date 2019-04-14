package BankApp_IO;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class BankApp_DropPage extends JFrame implements ActionListener, FocusListener {

	JPanel p1;
	JTextField tfId, tfPw;
	JButton btnOk, btnCancel;
	JLabel lb1, lb2, lb3, lb4;
	
	BankApp_DropPage(){
		setTitle("Drop Page");
		
		p1 = new JPanel(new GridLayout(2, 2, 20, 10));
		lb1 = new JLabel(" ");
		lb2 = new JLabel(" ");
		lb3 = new JLabel(" ");
		lb4 = new JLabel(" ");
		tfId = new JTextField("ID");
		tfPw = new JTextField("PW");
		btnOk = new JButton("회원탈퇴");
		btnCancel = new JButton("취소");
		
		p1.add(tfId);
		p1.add(tfPw);
		p1.add(btnOk);
		p1.add(btnCancel);
		add(lb1, "North");
		add(lb2, "South");
		add(lb3, "West");
		add(lb4, "East");
		add(p1, "Center");
		
		tfId.setForeground(Color.GRAY);
		tfPw.setForeground(Color.GRAY);
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		tfId.addFocusListener(this);
		tfPw.addFocusListener(this);
		
		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnOk){
					int select = BankApp_Service.drop(tfId.getText(), tfPw.getText());
					if(select == 1){
						setVisible(false);
						BankApp_Service.logout(1);
					}else if(select == 2){
						tfId.setText("ID");
						tfPw.setText("PW");
						new BankApp_MainPage();
					}else{
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다.");
						tfId.setText("ID");
						tfPw.setText("PW");
						new BankApp_MainPage();
					}
				}else if(e.getSource() == btnCancel){
					setVisible(false);
					new BankApp_MainPage();
				}
			}
		};
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		btnOk.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnCancel.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnOk.getActionMap().put("ENTER", ok);
		btnCancel.getActionMap().put("ENTER", ok);
		
		setSize(320, 130);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk){
			int select = BankApp_Service.drop(tfId.getText(), tfPw.getText());
			if(select == 1){
				setVisible(false);
				BankApp_Service.logout(1);
			}else if(select == 2){
				tfId.setText("ID");
				tfPw.setText("PW");
				new BankApp_MainPage();
			}else{
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다.");
				tfId.setText("ID");
				tfPw.setText("PW");
				new BankApp_MainPage();
			}
		}else if(e.getSource() == btnCancel){
			setVisible(false);
			new BankApp_MainPage();
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfId) {
			tfId.setText("");
			tfId.setForeground(Color.BLACK);

		} else {
			tfPw.setText("");
			tfPw.setForeground(Color.BLACK);
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (tfId.getText().isEmpty()) {
			tfId.setText("ID");
			tfId.setForeground(Color.GRAY);
		} else if (tfPw.getText().isEmpty()) {
			tfPw.setText("PW");
			tfPw.setForeground(Color.GRAY);
		}
		
	}
}
