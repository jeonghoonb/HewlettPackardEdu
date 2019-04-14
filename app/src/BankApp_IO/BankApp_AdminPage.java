package BankApp_IO;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class BankApp_AdminPage extends JFrame implements ActionListener{

	JTable tb;
	JScrollPane sp;
	JPanel p1;
	JComboBox combo;
	JTextField tf;
	JButton btnSearch;
	JMenu m1, m2;
	JMenuItem insert, update, delete, quit, help, version;
	JMenuBar mb;
	DefaultTableModel model;
	String[] columnName = {"Name", "ID", "PW", "A_Number", "Balance"};
	String[] comboName = {"All", "name", "userid", "balance"};
	BankApp_AdminPage(){
		setTitle("Admin Mode");
		

		
		model = new DefaultTableModel(columnName, 0);
		tb = new JTable(model);
		p1 = new JPanel();
		sp = new JScrollPane(tb);
		combo = new JComboBox(comboName);
		tf = new JTextField(20);
		btnSearch = new JButton("검색");
		m1 = new JMenu("Menu");
		m2 = new JMenu("Info");
		insert = new JMenuItem("가입");
		update = new JMenuItem("수정");
		delete = new JMenuItem("삭제");
		quit = new JMenuItem("종료");
		help = new JMenuItem("도움말");
		version = new JMenuItem("버전정보");
		mb = new JMenuBar();
		
		m1.add(insert);
		m1.add(update);
		m1.add(delete);
		m1.add(quit);
		m2.add(help);
		m2.add(version);
		mb.add(m1);
		mb.add(m2);
		setJMenuBar(mb);

		p1.add(combo);
		p1.add(tf);
		p1.add(btnSearch);
		p1.setBackground(Color.GREEN);
		p1.add(sp);
		add(sp, "Center");
		add(p1, "South");
		
		javax.swing.Action ok = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == insert) {// 가입 메뉴아이템 클릭
					
				} else if (e.getSource() == update) {// 수정 메뉴아이템 클릭
					
				} else if (e.getSource() == delete) {// 삭제 메뉴아이템 클릭
					
				} else if (e.getSource() == quit) {// 종료 메뉴아이템 클릭
					BankApp_Service.logout(0);
					setVisible(false);
				} else if (e.getSource() == help) {// 도움말 메뉴아이템 클릭
					showHelp();

				} else if (e.getSource() == version) {// 버전정보 메뉴아이템 클릭
					showVersion();

				} else if (e.getSource() == btnSearch) {// 검색 버튼 클릭
					String fieldName = combo.getSelectedItem().toString();
					if (fieldName.trim().equals("ALL")) {// 전체검색
						BankApp_Service.userSelectAll(model);
						if (model.getRowCount() > 0)
							tb.setRowSelectionInterval(0, 0);
					} else {
						if (tf.getText().trim().equals("")) {
							showDialog();
							tf.requestFocus();
						} else {// 검색어를 입력했을경우
							BankApp_Service.userSelect(model, fieldName, tf.getText(), 0);
							if (model.getRowCount() > 0)
								tb.setRowSelectionInterval(0, 0);
						}
					}
				}
			}
		};
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		btnSearch.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		btnSearch.getActionMap().put("ENTER", ok);
		
		tb.setEnabled(false);
		setBounds(230, 180, 800, 800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		quit.addActionListener(this);
		help.addActionListener(this);
		version.addActionListener(this);
		btnSearch.addActionListener(this);
		
		BankApp_Service.userSelectAll(model);
		if (model.getRowCount() > 0){
			tb.setRowSelectionInterval(0, 0); 
		}
		
	}
	
	public void showDialog(){
		JOptionPane.showMessageDialog(this, "검색 할 단어를 입력하세요.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insert) {// 가입 메뉴아이템 클릭
			showMenu();
		} else if (e.getSource() == update) {// 수정 메뉴아이템 클릭
			showMenu();
		} else if (e.getSource() == delete) {// 삭제 메뉴아이템 클릭
			showMenu();
		} else if (e.getSource() == quit) {// 종료 메뉴아이템 클릭
			BankApp_Service.logout(0);
			setVisible(false);
		} else if (e.getSource() == help) {// 도움말 메뉴아이템 클릭
			showHelp();

		} else if (e.getSource() == version) {// 버전정보 메뉴아이템 클릭
			showVersion();

		} else if (e.getSource() == btnSearch) {// 검색 버튼 클릭
			String fieldName = combo.getSelectedItem().toString();
			if (fieldName.trim().equals("ALL")) {// 전체검색
				BankApp_Service.userSelectAll(model);
				if (model.getRowCount() > 0)
					tb.setRowSelectionInterval(0, 0);
			} else {
				if (tf.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "검색 할 단어를 입력하세요.");
					tf.requestFocus();
				} else {// 검색어를 입력했을경우
					BankApp_Service.userSelect(model, fieldName, tf.getText(), 0);
					if (model.getRowCount() > 0)
						tb.setRowSelectionInterval(0, 0);
				}
			}
		}
		
	}
	
	public void showMenu(){
		JDialog jDialog = new JDialog();
		jDialog.setTitle("Menu");
		jDialog.setLayout(new FlowLayout());
		JLabel lb1 = new JLabel("       <개발 중...>       "); 
		JLabel lb2 = new JLabel("       ㅎㅎ;;;       "); 
		jDialog.add(lb1);
		jDialog.add(lb2);

		jDialog.setSize(190, 100); 
		jDialog.setVisible(true); 
		jDialog.setLocation(600, 300);
		jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	/*
	 * Admin : 도움말 
	 */
	public void showHelp() {
		JDialog jDialog = new JDialog();
		jDialog.setTitle("도움말");
		jDialog.setLayout(new GridLayout(4, 1));
		JLabel lb1 = new JLabel("               <ADMIN MODE>       "); 															
		JLabel lb2 = new JLabel("        가입 : 회원 정보 추가"); 
		JLabel lb3 = new JLabel("        수정 : 회원 정보 변경");
		JLabel lb4 = new JLabel("        삭제 : 회원 정보 삭제"); 

		jDialog.add(lb1);
		jDialog.add(lb2);
		jDialog.add(lb3);
		jDialog.add(lb4);

		jDialog.setSize(190, 180); 
		jDialog.setVisible(true); 
		jDialog.setLocation(600, 300);
		jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/*
	 * Admin : 버전 정보 버튼
	 */
	public void showVersion() {
		JDialog jDialog = new JDialog();
		jDialog.setTitle("버전 정보");
		jDialog.setLayout(new GridLayout(3, 1, 10, 10));
		
		JLabel lb = new JLabel("   version : v1.0");
		JLabel lb1 = new JLabel("  개발자 : 방 정 훈"); 
		JLabel lb2 = new JLabel("  최종수정일 : 2017.07.26"); 

		
		jDialog.add(lb);
		jDialog.add(lb1);
		jDialog.add(lb2);
		jDialog.setSize(250, 150); // 윈도우의 크기 가로x세로
		jDialog.setVisible(true); // 창을 보여줄떄 true, 숨길때 false
		jDialog.setLocation(600, 300);
		jDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // x 버튼을 누르면
																	// 해당 창 내려감
	}
	
}
