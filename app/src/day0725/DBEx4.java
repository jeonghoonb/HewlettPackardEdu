package day0725;

import java.sql.*;
import java.util.*;

public class DBEx4 {

	public DBEx4() {
		String user = "root";
		String pw = "oracle";
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Successful");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, pw);
			System.out.println("Connection Successful\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		//update and where
		String name = new Scanner(System.in).next();
		String sql = "update member set name = '"+name+"'";
		Statement stmt = null;
		int result = -1;
		try{
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException se) {
			se.printStackTrace();
		}
		System.out.println("결과 : "+(result < 0 ? "실패" : "성공"));
	}

	public static void main(String[] args) {
		new DBEx4();
	}
}
