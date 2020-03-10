package androidjsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB_result {
	// 싱글톤 패턴으로 사용 하기위 한 코드들
	private static ConnectDB_result connectdb_result = new ConnectDB_result();

	public static ConnectDB_result getInstance() {
		return connectdb_result;
	}
	public ConnectDB_result() {

	}
	static String jdbcUrl = "jdbc:mysql://localhost:3306/DB이름?serverTimezone=UTC";// MySQL 계정 "jdbc:mysql://localhost:3306/DB이름"
	private String dbId = ""; // MySQL 계정 "로컬일 경우 root"
	private String dbPw = ""; // 비밀번호 "mysql 설치 시 설정한 비밀번호"
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	private ResultSet rs = null;
	private ResultSet rs2 = null;
	private ResultSet rs3 = null;
	private String sql ;
	private String sql2 ;
	private String sql3 ;
	private String returns=null;
	private String returns2=null;
	private String returns3=null;

	// 데이터베이스와 통신하기 위한 코드가 들어있는 메서드
	public String level(String gene_name, String user_num) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select * from gene_table where order_id=? AND name_gene=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_num);
			pstmt.setString(2, gene_name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			returns=rs.getString("marker_result");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
		if (rs != null)try {rs.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
		
		}
		return returns;
	}

	public String complication(String disease) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql2 = "select * from complication_table where name_disease=? IS NOT NULL";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, disease);
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
			returns2=rs2.getString("complication");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (pstmt2 != null)try {pstmt2.close();} catch (SQLException ex) {}
		if (rs2 != null)try {rs2.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
		
		}
		return returns2;
	}
	public String sym(String disease) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql3 = "select * from complication_table where name_disease=? IS NOT NULL";
			pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setString(1, disease);
			rs3 = pstmt3.executeQuery();
			while (rs3.next()) {
			returns3=rs3.getString("symptom");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (pstmt3 != null)try {pstmt3.close();} catch (SQLException ex) {}
		if (rs3 != null)try {rs3.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
		
		}
		return returns3;
	}
	

}



