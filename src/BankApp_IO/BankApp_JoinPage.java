package BankApp_IO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankApp_JoinPage extends JDialog implements ActionListener, FocusListener {

	JPanel p1;
	JButton btnOk, btnCancel;
	JLabel lb;
	JTextField tfName, tfId, tfPw, tfAno, tfBalance;

	BankApp_JoinPage() {
		setTitle("Join Dialog");
		setLayout(new FlowLayout());

		p1 = new JPanel(new GridLayout(1, 2, 50, 5));
		btnOk = new JButton("회원가입");
		btnCancel = new JButton("취소");
		tfName = new JTextField("이름을 입력하세요.", 30);
		tfId = new JTextField("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)", 30);
		tfPw = new JTextField("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)", 30);
		tfAno = new JTextField("계좌번호 : ", 30);
		tfBalance = new JTextField("초기 입금액을 입력하세요.", 30);
		lb = new JLabel("IBK 기업은행");
		lb.setFont(new Font("맑은고딕", Font.BOLD, 14));
		lb.setForeground(Color.BLUE);

		tfName.setForeground(Color.GRAY);
		tfId.setForeground(Color.GRAY);
		tfPw.setForeground(Color.GRAY);
		tfAno.setForeground(Color.BLACK);
		tfBalance.setForeground(Color.GRAY);

		p1.add(btnOk);
		p1.add(btnCancel);
		add(tfName);
		add(tfId);
		add(tfPw);
		add(tfAno);
		add(tfBalance);
		add(p1);
		
		String[] aNo = BankApp_Service.createAno();
		String a = "";
		for(String ano : aNo) {
			a+=ano;
		}
		tfAno.setText(a);
		tfAno.enable(false);
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		tfName.addFocusListener(this);
		tfId.addFocusListener(this);
		tfPw.addFocusListener(this);
		tfAno.addFocusListener(this);
		tfBalance.addFocusListener(this);

		setSize(450, 210);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOk) {
					if(tfName.getText().equals("이름을 입력하세요.")||tfId.getText().equals("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)")||tfPw.getText().equals("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)")||tfBalance.getText().equals("초기 입금액을 입력하세요.")){
						JOptionPane.showMessageDialog(null, "입력하지 않은 사항이 있습니다.");
					}else{
						if(BankApp_Service.checkId(tfId.getText())) {
							if(BankApp_Service.checkIdPw(tfId.getText(), tfPw.getText())) {
								if(BankApp_Service.createAccount(tfName.getText(), tfId.getText(), tfPw.getText(), tfAno.getText(), Integer.parseInt(tfBalance.getText()))){
									dispose2();
									new BankApp_LoginPage();
								}
							}else {
								JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호의 양식이 틀립니다.");
								tfName.setText("이름을 입력하세요.");
								tfId.setText("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)");
								tfPw.setText("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)");
								tfBalance.setText("초기 입금액을 입력하세요.");
							}
						}else {
							JOptionPane.showMessageDialog(null, "아이디가 중복됩니다.");
							tfName.setText("이름을 입력하세요.");
							tfId.setText("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)");
							tfPw.setText("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)");
							tfBalance.setText("초기 입금액을 입력하세요.");
						}
					}
					}else {
						dispose2();
				}
			}
		};
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		btnOk.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnCancel.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnOk.getActionMap().put("ENTER", ok);
		btnCancel.getActionMap().put("ENTER", ok);
	}
	public void dispose2(){
		dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			if(tfName.getText().equals("이름을 입력하세요.")||tfId.getText().equals("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)")||tfPw.getText().equals("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)")||tfBalance.getText().equals("초기 입금액을 입력하세요.")){
				JOptionPane.showMessageDialog(null, "입력하지 않은 사항이 있습니다.");
			}else{
				if(BankApp_Service.checkId(tfId.getText())) {
					if(BankApp_Service.checkIdPw(tfId.getText(), tfPw.getText())) {
						if(BankApp_Service.createAccount(tfName.getText(), tfId.getText(), tfPw.getText(), tfAno.getText(), Integer.parseInt(tfBalance.getText()))){
							this.dispose();
							new BankApp_LoginPage();
						}
					}else {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호의 양식이 틀립니다.");
						tfName.setText("이름을 입력하세요.");
						tfId.setText("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)");
						tfPw.setText("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)");
						tfBalance.setText("초기 입금액을 입력하세요.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "아이디가 중복됩니다.");
					tfName.setText("이름을 입력하세요.");
					tfId.setText("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)");
					tfPw.setText("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)");
					tfBalance.setText("초기 입금액을 입력하세요.");
				}
			}
			}else {
			this.dispose();
			
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == tfName) {
			tfName.setForeground(Color.BLACK);
			tfName.setText("");
		} else if (e.getSource() == tfId) {
			tfId.setForeground(Color.BLACK);
			tfId.setText("");
		} else if (e.getSource() == tfPw) {
			tfPw.setForeground(Color.BLACK);
			tfPw.setText("");
		}else if (e.getSource() == tfBalance) {
			tfBalance.setForeground(Color.BLACK);
			tfBalance.setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (tfName.getText().isEmpty()) {
			tfName.setForeground(Color.GRAY);
			tfName.setText("이름을 입력하세요.");
		} else if (tfId.getText().isEmpty()) {
			tfId.setForeground(Color.GRAY);
			tfId.setText("아이디를 입력하세요.(영문,숫자 2 ~ 7자리)");
		} else if (tfPw.getText().isEmpty()) {
			tfPw.setForeground(Color.GRAY);
			tfPw.setText("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)");
		}else if (tfBalance.getText().isEmpty()) {
			tfBalance.setForeground(Color.GRAY);
			tfBalance.setText("초기 입금앱을 입력하세요.");
		}
	}

}
