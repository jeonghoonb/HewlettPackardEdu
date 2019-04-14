package day0724;

import java.sql.*;
import java.util.Scanner;

/**
 * JDBC(Java Database Connectivity)는 자바에서 DB에 접속할 수 있도록하는 자바 API
 * JDBC는 DB에소 자료를 쿼리하거나 업데이트하는 방법을 제공한다.
 * 
 * .jar 파일 연결 : Build Path -> Libraries -> add External ~
 */

public class DBEx2 {

	public DBEx2() {
		String user = "root";
		String pw = "oracle";
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Successful");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, pw);
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		/*
		 * insert : (name, userid, pw)를 명시하지 않으면 모든 속성값에 해당하는 값을 넣어야 한다. 자신이 넣을 값을 명시하면 그 값만 들어가고 나머지는 null로 들어간다. 
		 */
		System.out.print("이름을 입력하세요 : ");
		String name = new Scanner(System.in).next();
		System.out.print("아이디를 입력하세요 : ");
		String userid = new Scanner(System.in).next();
		System.out.print("비밀번호를 입력하세요 : ");
		String pwd = new Scanner(System.in).next();
		
		String sql = "insert into member(name, userid, pwd) values ('" + name +"', '" + userid +"', '" + pwd + "')";
		Statement stmt = null;
		int result = -1;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql); //executeUpdate() 메소드는 -1,0,1 중 하나 반환
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result < 0 ? "실패!" : "성공!");	
	}

	public static void main(String[] args) {
		new DBEx2();
	}
}
