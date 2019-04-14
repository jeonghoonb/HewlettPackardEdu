package day0725;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * SingleTon Pattern
 */
public class DBAction {

	public static DBAction instance = new DBAction();
	public Connection conn = null;
	
	public DBAction() {
		String user = "root";
		String pw = "oracle";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Successful");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, pw);
			System.out.println("Connection Successful\n\n");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	// 최초 1회 시작 시 객체 생성 후, 이후에는 getIntance()로 사용
	public static DBAction getInstance() {
		if (instance == null) { 
			instance = new DBAction();
		}
		return instance;
	}
	
	public Connection getConnection(){
		return conn;
	}
}
