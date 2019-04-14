package day0724;

import java.sql.*;

/**
 * JDBC(Java Database Connectivity)는 자바에서 DB에 접속할 수 있도록하는 자바 API
 * JDBC는 DB에소 자료를 쿼리하거나 업데이트하는 방법을 제공한다.
 * 
 * .jar 파일 연결 : Build Path -> Libraries -> add External ~
 */

public class DBEx {

	public DBEx() {
		String user = "root";
		String pw = "oracle";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Successful");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", user, pw);
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	/* Oracle DB 사용 시 설정 사항
	  	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Successful");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin//localhost:1521:orcl", user, pw);
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	*/
		
	}

	public static void main(String[] args) {
		new DBEx();
	}
}
