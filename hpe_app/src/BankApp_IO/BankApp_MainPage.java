package BankApp_IO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankApp_MainPage extends JFrame implements ActionListener {

	JPanel p1, p2, p3, p4;
	ImageIcon bankLogo;
	JButton btnLogout, btnLookup, btnDeposit, btnWithDraw, btnExit, btnMypage, btnDrop;
	JDialog dialogJoin, dialogLogin, dialogDeposit, dialogWithdraw;
	JLabel lbImg, lb1, lb2, lb3, lb4;
	Menu menu;
	MenuBar menubar;
	MenuItem[] menuItems;
	int endTimer;
	Thread thread;

	BankApp_MainPage() {
		repaint();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		lbImg = new JLabel();
		// bankLogo = new ImageIcon("D:/Program
		// Files/javaworkspace/App/src/BankApp/bankLogo.jpg");
		bankLogo = new ImageIcon("C:/Users/odae/workspace/BankApplication/src/BankApp/bankLogo3.jpg");
		btnLogout = new JButton(" 로그아웃 ");
		btnLookup = new JButton(" 계좌 조회 ");
		btnDeposit = new JButton(" 입금 ");
		btnWithDraw = new JButton(" 출금 ");
		btnExit = new JButton(" 종료 ");
		btnMypage = new JButton(" 마이페이지 ");
		btnDrop = new JButton(" 회원 탈퇴 ");
		dialogJoin = new JDialog();
		dialogLogin = new JDialog();
		dialogDeposit = new JDialog();
		dialogWithdraw = new JDialog();
		lb1 = new JLabel(" ");
		lb2 = new JLabel(" ");
		lb3 = new JLabel(" ");
		lb4 = new JLabel(" ");
		menubar = new MenuBar();
		menu = new Menu("Menu");
		menuItems = new MenuItem[7];
		menuItems[0] = new MenuItem("로그아웃");
		menuItems[1] = new MenuItem("잔액조회");
		menuItems[2] = new MenuItem("입금");
		menuItems[3] = new MenuItem("출금");
		menuItems[4] = new MenuItem("마이페이지");
		menuItems[5] = new MenuItem("회원 탈퇴");
		menuItems[6] = new MenuItem("종료");

		for (int i = 0; i < menuItems.length; i++) {
			menu.add(menuItems[i]);
			menuItems[i].addActionListener(this);
			if (i != 2 && i !=4 && i != (menuItems.length - 1))
				menu.addSeparator();
		}

		lbImg.setIcon(bankLogo);

		p1.setLayout(new BorderLayout());
		p2.setLayout(new GridLayout(7, 1, 10, 10));
		p1.add(lbImg);
		p2.add(btnLogout);
		p2.add(btnLookup);
		p2.add(btnDeposit);
		p2.add(btnWithDraw);
		p2.add(btnMypage);
		p2.add(btnDrop);
		p2.add(btnExit);

		p3.add(p1);
		p3.add(p2);

		add(lb2, BorderLayout.SOUTH);
		add(lb3, BorderLayout.EAST);
		add(lb4, BorderLayout.WEST);
		add(p3, "Center");
		menubar.add(menu);
		setMenuBar(menubar);

		setSize(450, 340);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				endTimer = 10;
				while (endTimer > 0) {
					setTitle(" Bank Application \t\t\t\t\t 자동 로그아웃 타이머 : " + Integer.toString(endTimer));
					try {
						Thread.sleep(1000);
						endTimer--;
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
				if (endTimer == 0) {
					JOptionPane.showMessageDialog(null, "움직임이 없어 자동 로그아웃됩니다.");
					setVisible(false);
					BankApp_Service.logout(0);
				}

			}
		});
		thread.start();

		btnLogout.addActionListener(this);
		btnLookup.addActionListener(this);
		btnDeposit.addActionListener(this);
		btnWithDraw.addActionListener(this);
		btnMypage.addActionListener(this);
		btnDrop.addActionListener(this);
		btnExit.addActionListener(this);
		menu.addActionListener(this);
		
		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object object = e.getSource();

				if (object == btnLogout) {
					endTimer = 100;
					BankApp_Service.logout(0);
					setVisible(false);
				} else if (object == btnLookup) {
					endTimer = 100;
					BankApp_Service.lookup();
				} else if (object == btnDeposit) {
					endTimer = 100;
					new BankApp_DepositPage(1);
				} else if (object == btnWithDraw) {
					endTimer = 100;
					new BankApp_WithdrawPage(1);
				}else if(object == btnMypage){
					endTimer = 100;
					BankApp_Service.myPage();
				}else if(object == btnDrop){
					endTimer = 100;
					new BankApp_DropPage();
					setVisible(false);
				} else if (object == btnExit) {
					endTimer = 100;
					System.exit(0);
				} else if (object == menuItems[0]) {
					endTimer = 100;
					BankApp_Service.logout(0);
					setVisible(false);
				} else if (object == menuItems[1]) {
					endTimer = 100;
					BankApp_Service.lookup();
				} else if (object == menuItems[2]) {
					endTimer = 100;
					new BankApp_DepositPage(1);
				} else if (object == menuItems[3]) {
					endTimer = 100;
					new BankApp_WithdrawPage(1);
				} else if (object == menuItems[4]) {
					endTimer = 100;
					BankApp_Service.myPage();
				} else if (object == menuItems[5]) {
					endTimer = 100;
					new BankApp_DropPage();
					setVisible(false);
				} else if (object == menuItems[6]) {
					endTimer = 100;
					System.exit(0);
				}
			}
		};
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		btnLogout.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnLookup.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnDeposit.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnWithDraw.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnMypage.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnDrop.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnExit.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");

		btnLogout.getActionMap().put("ENTER", ok);
		btnLookup.getActionMap().put("ENTER", ok);
		btnDeposit.getActionMap().put("ENTER", ok);
		btnWithDraw.getActionMap().put("ENTER", ok);
		btnWithDraw.getActionMap().put("ENTER", ok);
		btnMypage.getActionMap().put("ENTER", ok);
		btnDrop.getActionMap().put("ENTER", ok);
		btnExit.getActionMap().put("ENTER", ok);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == btnLogout) {
			endTimer = 100;
			BankApp_Service.logout(0);
			setVisible(false);
		} else if (object == btnLookup) {
			endTimer = 100;
			BankApp_Service.lookup();
		} else if (object == btnDeposit) {
			endTimer = 100;
			new BankApp_DepositPage(1);
		} else if (object == btnWithDraw) {
			endTimer = 100;
			new BankApp_WithdrawPage(1);
		}else if(object == btnMypage){
			endTimer = 100;
			BankApp_Service.myPage();
		}else if(object == btnDrop){
			endTimer = 100;
			new BankApp_DropPage();
			setVisible(false);
		} else if (object == btnExit) {
			endTimer = 100;
			System.exit(0);
		} else if (object == menuItems[0]) {
			endTimer = 100;
			BankApp_Service.logout(0);
			setVisible(false);
		} else if (object == menuItems[1]) {
			endTimer = 100;
			BankApp_Service.lookup();
		} else if (object == menuItems[2]) {
			endTimer = 100;
			new BankApp_DepositPage(1);
		} else if (object == menuItems[3]) {
			endTimer = 100;
			new BankApp_WithdrawPage(1);
		} else if (object == menuItems[4]) {
			endTimer = 100;
			BankApp_Service.myPage();
		} else if (object == menuItems[5]) {
			endTimer = 100;
			new BankApp_DropPage();
			setVisible(false);
		} else if (object == menuItems[6]) {
			endTimer = 100;
			System.exit(0);
		}

	}
}