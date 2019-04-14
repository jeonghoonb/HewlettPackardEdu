package BankApp_IO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BankApp_Service {

	public static BankApp_LookupPage lookup;
	public static BankApp_DepositPage deposit;
	public static BankApp_WithdrawPage withdraw;
	public static BankApp_Mypage mypage;
	public static String currentID;
	public static Connection con;
	public static PreparedStatement ps;
	public static ResultSet rs;

	public BankApp_Service() {
		new BankApp_LoginPage();
	}

	/*
	 * 회원가입
	 */
	public static boolean createAccount(String name, String id, String pw, String ano, int balance) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		try {
			ps = con.prepareStatement("insert into member(name,userid,pwd,ano,balance) values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, pw);
			ps.setString(4, ano);
			ps.setInt(5, balance);
			if (ps.executeUpdate() >= 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, null);
		}
		return false;
	}

	/*
	 * 계좌 번호 생성
	 */
	public static String[] createAno() {
		String[] aNo = new String[13];
		for (int i = 0; i < aNo.length; i++) {
			if (i == 3 || i == 7)
				aNo[i] = "-";
			else
				aNo[i] = Integer.toString((int) (Math.random() * 9) + 1);
		}
		return aNo;
	}

	/*
	 * ID중복검사
	 */
	public static boolean checkId(String id) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		try {
			ps = con.prepareStatement("select * from member where userid = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, rs);
		}
		return true;
	}

	/*
	 * ID, PW 유효성 검사
	 */
	public static boolean checkIdPw(String id, String pw) {
		String regExp = "\\w{2,7}";
		boolean b1 = Pattern.matches(regExp, id);
		boolean b2 = Pattern.matches(regExp, pw);
		return b1 && b2;
	}

	/*
	 * 로그인
	 */
	public static int login(String id, String pw) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		try {
			ps = con.prepareStatement("select userid, pwd from member where userid = ? and pwd = ?");
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if (rs.next()) {
				if(id.equals("admin")&&pw.equals("admin")){
					currentID = id;
					return 1;
				}
				currentID = id;
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, rs);
		}
		return 3;
	}
	
	
	/*
	 * 로그아웃
	 */
	public static void logout(int i) {
		if (i == 0) {
			JOptionPane.showMessageDialog(null, currentID + " 님이 로그아웃 하셨습니다.");
			currentID = null;
			new BankApp_LoginPage();
		} else if (i == 1) {
			new BankApp_LoginPage();
		}
	}

	/*
	 * 입금
	 */
	public static boolean deposit(int money) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		try {
			ps = con.prepareStatement("select balance from member where userid = ?");
			ps.setString(1, currentID);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = con.prepareStatement("update member set balance = ? where userid = ?");
				ps.setInt(1, (money + rs.getInt(1)));
				ps.setString(2, currentID);
				if (ps.executeUpdate() >= 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, rs);
		}
		return false;
	}

	/*
	 * 출금
	 */
	public static boolean withdraw(int money) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		int susu = (int) (money * 0.1);
		money += susu;
		try {
			ps = con.prepareStatement("select balance from member where userid = ?");
			ps.setString(1, currentID);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = con.prepareStatement("update member set balance = ? where userid = ?");
				ps.setInt(1, (rs.getInt(1) - money));
				ps.setString(2, currentID);
				if (ps.executeUpdate() >= 0) {
					JOptionPane.showMessageDialog(null, "수수료 : 10% (" + susu + "원)");
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, rs);
		}
		return false;
	}

	/*
	 * 조회
	 */
	public static void lookup() {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		try {
			ps = con.prepareStatement("select name, userid, ano, balance from member where userid = ?");
			ps.setString(1, currentID);
			rs = ps.executeQuery();
			if (rs.next()) {
				lookup = new BankApp_LookupPage();
				lookup.lbName2.setText(rs.getString(1));
				lookup.lbId2.setText(rs.getString(2));
				lookup.lbAno2.setText(rs.getString(3));
				lookup.lbBalance2.setText(Integer.toString(rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, rs);
		}
	}

	/*
	 * 마이페이지 세팅
	 */
	public static boolean myPage() {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		try {
			ps = con.prepareStatement("select userid, ano, balance from member where userid = ?");
			ps.setString(1, currentID);
			rs = ps.executeQuery();
			if (rs.next()) {
				mypage = new BankApp_Mypage();
				mypage.tfId.setText(" ID : " + rs.getString(1));
				mypage.tfAno.setText(" 계좌번호 : " + rs.getString(2));
				mypage.tfBalance.setText(" 현재 잔액 : " + rs.getString(3) + "원");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, rs);
		}
		return false;
	}

	/*
	 * 회원정보 업데이트
	 */
	public static boolean update(String name, String pw) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		if (name.equals("이름을 입력하세요.") || pw.equals("비밀번호를 입력하세요.(영문,숫자 2 ~ 7자리)")) {
			return false;
		} else {
			try {
				ps = con.prepareStatement("update member set name = ?, pwd = ? where userid = ?");
				ps.setString(1, name);
				ps.setString(2, pw);
				ps.setString(3, currentID);
				if (ps.executeUpdate() >= 0) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtill.dbClose(con, ps, null);
			}
			return false;
		}
	}

	/*
	 * 회원 탈퇴
	 */
	public static int drop(String id, String pw) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		int select = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?", "회원탈퇴", 2);
		try {
			ps = con.prepareStatement("select userid, pwd from member where userid = ? and pwd = ?");
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();

			if (rs.next()) {
				if (select == 0) {
					ps = con.prepareStatement("delete from member where userid = ?");
					ps.setString(1, id);
					if (ps.executeUpdate() >= 0) {
						return 1;
					} else {
						return 3;
					}
				} else {
					return 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.dbClose(con, ps, rs);
		}
		return 3;
	}
	
	/*
	 * Admin : 모든 회원정보 출력
	 */
	public static void userSelectAll(DefaultTableModel tModel){
		con = DBUtill.getConnection();
		ps = null;
		rs = null;
		try{
			ps = con.prepareStatement("select * from member order by name");
			rs = ps.executeQuery();
			for (int i = tModel.getRowCount() - 1; i >= 0; i--) {
				tModel.removeRow(i);
			}
			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)};
				// DefaultTableModel에 레코드 추가
				tModel.addRow(data);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtill.dbClose(con, ps, rs);
		}
	}
	
	/*
	 *  Admin : 특정 회원정보 출력
	 */
	public static void userSelect(DefaultTableModel tModel, String fieldName, String word, int j) {
		con = DBUtill.getConnection();
		ps = null;
		rs = null;

		try {
			if(j == 0){
				ps = con.prepareStatement("select * from member where " + fieldName.trim() + " LIKE '%" + word.trim() + "%'");
				rs = ps.executeQuery();		
			}else{
				ps = con.prepareStatement("select * from member where " + fieldName.trim() + " = '" + word.trim() + "'");
				rs = ps.executeQuery();	
			}
			for (int i = tModel.getRowCount() - 1; i >= 0; i--) {
				tModel.removeRow(i);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)};
				// DefaultTableModel에 레코드 추가
				tModel.addRow(data);
			}

		} catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtill.dbClose(con, ps, rs);
		}

	}
	
}