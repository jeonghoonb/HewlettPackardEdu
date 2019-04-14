package day0725;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DBEx6 {

	public Scanner scan;

	public String inputStr() {
		return scan.next();
	}

	public DBEx6() {
		scan = new Scanner(System.in);
		DBAction db = DBAction.getInstance();
		Connection conn = db.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		//String sql = "select * from member order by name asc"; // order by (정렬:기본 내림차순)
		String sql = "select * from member limit 2"; // order by (정렬:기본 내림차순)
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= cols; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally{
			try{
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DBEx6();
	}
}
