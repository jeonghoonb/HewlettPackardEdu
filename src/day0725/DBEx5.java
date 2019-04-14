package day0725;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx5 {
	
	public Scanner scan;
	
	public String inputStr(){
		return scan.next();
	}
	
	public DBEx5() {
		scan = new Scanner(System.in);
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
	}
}
