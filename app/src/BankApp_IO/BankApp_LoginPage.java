package BankApp_IO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class BankApp_LoginPage extends JFrame implements ActionListener, FocusListener {

	JPanel p1, p2, p3, p4, p5;
	JTextField tfId, tfPw;
	JButton btnJoin, btnLogin, btnExit;
	ImageIcon bankLogo;
	JLabel lbImg, lb1, lb2, lb3, lb4;
	
	BankApp_LoginPage() {
		setTitle("LoginPage");
		p1 = new JPanel(new GridLayout(2, 1, 20, 20));
		p2 = new JPanel(new GridLayout(2, 1, 20, 20));
		p3 = new JPanel(new GridLayout(1, 2, 20, 20));
		p4 = new JPanel(new GridLayout(1, 3, 20, 20));
		p5 = new JPanel(new GridLayout(2, 1, 20, 20));
		tfId = new JTextField("ID");
		tfPw = new JTextField("PW");
		btnJoin = new JButton("회원가입");
		btnLogin = new JButton("로그인");
		btnExit = new JButton("종료");
		bankLogo = new ImageIcon("C:/Users/odae/workspace/BankApplication/src/BankApp/bankLogo1.jpg");
		//bankLogo = new ImageIcon("D:/Program Files/javaworkspace/App/src/BankApp/bankLogo1.jpg");

		lbImg = new JLabel();
		lb1 = new JLabel(" ");
		lb2 = new JLabel(" ");
		lb3 = new JLabel(" ");
		lb4 = new JLabel(" ");
		lbImg.setIcon(bankLogo);

		p4.add(btnJoin);
		p4.add(btnLogin);
		p4.add(btnExit);
		p3.add(tfId);
		p3.add(tfPw);
		p2.add(p3);
		p2.add(p4);
		p1.add(lbImg);
		p1.add(p2);
		add(lb1, BorderLayout.NORTH);
		add(lb2, BorderLayout.EAST);
		add(lb3, BorderLayout.WEST);
		add(lb4, BorderLayout.SOUTH);
		add(p1, BorderLayout.CENTER);

		tfId.setForeground(Color.GRAY);
		tfPw.setForeground(Color.GRAY);

		btnJoin.addActionListener(this);
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		tfId.addFocusListener(this);
		tfPw.addFocusListener(this);
		
		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnJoin) {
					new BankApp_JoinPage();
					
				} else if (e.getSource() == btnLogin) {
					int a = BankApp_Service.login(tfId.getText(), tfPw.getText());
					if(a == 1){
						new BankApp_AdminPage();
						setVisible(false);
					}else if(a == 2){
						new BankApp_MainPage();
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다.");
						tfId.setText("ID");
						tfPw.setText("PW");
					}
				} else
					System.exit(0);
			}
		};
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		btnJoin.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnLogin.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnExit.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnJoin.getActionMap().put("ENTER", ok);
		btnLogin.getActionMap().put("ENTER", ok);
		btnExit.getActionMap().put("ENTER", ok);
		
		setSize(320, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) {
			new BankApp_JoinPage();
			
		} else if (e.getSource() == btnLogin) {
			int a = BankApp_Service.login(tfId.getText(), tfPw.getText());
			if(a == 1){
				new BankApp_AdminPage();
				setVisible(false);
			}else if(a == 2){
				new BankApp_MainPage();
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다.");
				tfId.setText("ID");
				tfPw.setText("PW");
			}
		} else
			System.exit(0);
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
