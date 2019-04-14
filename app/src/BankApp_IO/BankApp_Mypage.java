package BankApp_IO;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class BankApp_Mypage extends JFrame implements ActionListener, FocusListener {
	JPanel p1;
	JButton btnOk, btnCancel;
	JLabel lb;
	JTextField tfName, tfId, tfPw, tfAno, tfBalance;

	BankApp_Mypage() {
		setTitle("My Page");
		setLayout(new FlowLayout());

		p1 = new JPanel(new GridLayout(1, 2, 50, 5));
		btnOk = new JButton("변경");
		btnCancel = new JButton("취소");
		tfName = new JTextField(30);
		tfId = new JTextField(30);
		tfPw = new JTextField(30);
		tfAno = new JTextField(30);
		tfBalance = new JTextField(30);
		lb = new JLabel("변경 사항 없을 시 기존 정보를 입력하세요.");
		lb.setFont(new Font("맑은고딕", Font.BOLD, 12));
		lb.setForeground(Color.RED);

		tfName.setForeground(Color.GRAY);
		tfId.setForeground(Color.GRAY);
		tfPw.setForeground(Color.GRAY);
		tfAno.setForeground(Color.BLACK);
		tfBalance.setForeground(Color.GRAY);

		p1.add(btnOk);
		p1.add(btnCancel);
		add(lb);
		add(tfName);
		add(tfId);
		add(tfPw);
		add(tfAno);
		add(tfBalance);
		add(p1);
		
		tfId.enable(false);
		tfAno.enable(false);
		tfBalance.enable(false);
	
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		tfName.addFocusListener(this);
		tfId.addFocusListener(this);
		tfPw.addFocusListener(this);
		tfAno.addFocusListener(this);
		tfBalance.addFocusListener(this);

		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOk) {
					if(BankApp_Service.update(tfName.getText(), tfPw.getText())){
						JOptionPane.showMessageDialog(null, "회원정보 수정 완료");
					}else{
						JOptionPane.showMessageDialog(null, "양식이 잘못되었습니다.");
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
		
		
		setSize(450, 250);
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
			if(BankApp_Service.update(tfName.getText(), tfPw.getText())){
				JOptionPane.showMessageDialog(null, "회원정보 수정 완료");
			}else{
				JOptionPane.showMessageDialog(null, "양식이 잘못되었습니다.");
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
		} else if (e.getSource() == tfPw) {
			tfPw.setForeground(Color.BLACK);
			tfPw.setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (tfName.getText().isEmpty()) {
			tfName.setForeground(Color.GRAY);
			tfName.setText("이름을 입력하세요.");
		} else if (tfPw.getText().isEmpty()) {
			tfPw.setForeground(Color.GRAY);
			tfPw.setText("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)");
		}
	}

}
