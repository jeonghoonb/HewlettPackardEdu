package day0724;

import java.sql.*;
import java.util.*;

public class DBEx3 {

	public DBEx3() {
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

		/*
		 * select문
		 */
		//System.out.print("검색하고자 하는 사용자 userid를 입력하세요. : ");
		//String userid = new Scanner(System.in).next();
		String sql = "insert into member values('방정훈', 'bjh', '1234', 'bjh@naver.com', '010-0000-0005', 0)";
		Statement stmt = null;
		//ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			//rs = stmt.executeQuery(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*try {
			System.out.println(" << 검색된 test Table >>");
			System.out.println("---------------------------------------------");
			System.out.println("name\tuserid\tpwd\temail\tphone\tadmin");
			System.out.println("---------------------------------------------");
			
			
			while (rs.next()) {
				// rs.getString(컬럼명) or (컬럼인덱스)를 사용하여 모두 출력하시오.
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString("pwd") + "\t");
				System.out.print(rs.getString("email") + "\t");
				System.out.print(rs.getString("phone") + "\t");
				System.out.print(rs.getInt("admin") + "\n");
			}
			
			
			 * ResultSetMetaData 사용하기
			 
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			while (rs.next()) {
				// rs.getString(컬럼명) or (컬럼인덱스)를 사용하여 모두 출력하시오.
				for(int i = 1; i <= cols; i++){
					System.out.print(rs.getString(i)+"\t");
				}System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		finally {
			try {
				//if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DBEx3();
	}
}
