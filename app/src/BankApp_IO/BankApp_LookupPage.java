package BankApp_IO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BankApp_LookupPage extends JDialog {
	
	JPanel p1, p2;
	JLabel lbName, lbId, lbAno, lbBalance, lbimg, lblogo, lbName2, lbId2, lbAno2, lbBalance2, lb1, lb2, lb3, lb4, lb5;
	ImageIcon bankLogo;
	
	BankApp_LookupPage(){
		setTitle("Lookup Page");
		setLayout(new BorderLayout());
		repaint();
		p1 = new JPanel(new GridLayout(5, 4, 5, 5));
		p2 = new JPanel(new GridLayout(2, 1, 3, 5));
		lbName = new JLabel("                     예금주 ");
		lbId = new JLabel("                     아이디 ");
		lbAno = new JLabel("                     계좌번호 ");
		lbBalance = new JLabel("                     잔액 ");
		lbimg = new JLabel("  ");
		lblogo = new JLabel("    기본정보");
		lbName2 = new JLabel(" ");
		lbId2 = new JLabel("  ");
		lbAno2 = new JLabel("  ");
		lbBalance2 = new JLabel("  ");
		lb1 = new JLabel("  ");
		lb2 = new JLabel("  ");
		lb3 = new JLabel("  ");
		lb4 = new JLabel("        ");
		lb5 = new JLabel("        "); 
	
		//bankLogo = new ImageIcon("D:/Program Files/javaworkspace/App/src/BankApp/bankLogo2.jpg");
		bankLogo = new ImageIcon("C:/Users/odae/workspace/BankApplication/src/BankApp/bankLogo2.jpg");
		lbimg.setIcon(bankLogo);
		
		lblogo.setFont(new Font("맑은고딕", Font.BOLD, 20));
		lblogo.setForeground(Color.blue);
		
		p1.add(lblogo);
		p1.add(lb1);
		p1.add(lbAno);
		p1.add(lbAno2);
		p1.add(lbName);
		p1.add(lbName2);
		p1.add(lbId);
		p1.add(lbId2);
		p1.add(lbBalance);
		p1.add(lbBalance2);
		p2.add(lbimg);
		p2.add(p1);
		add(p2, BorderLayout.CENTER);
		add(lb2, BorderLayout.NORTH);
		add(lb3, BorderLayout.SOUTH);
		add(lb4, BorderLayout.EAST);
		add(lb5, BorderLayout.WEST);		
		
		setSize(350, 350);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
