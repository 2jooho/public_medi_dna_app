package androidjsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB_result3 {
	// 싱글톤 패턴으로 사용 하기위 한 코드들
	private static ConnectDB_result3 connectdb_result = new ConnectDB_result3();

	public static ConnectDB_result3 getInstance() {
		return connectdb_result;
	}
	public ConnectDB_result3() {

	}
	static String jdbcUrl = "jdbc:mysql://localhost:3306/DB이름?serverTimezone=UTC";// MySQL 계정 "jdbc:mysql://localhost:3306/DB이름"
	private String dbId = ""; // MySQL 계정 "로컬일 경우 root"
	private String dbPw = ""; // 비밀번호 "mysql 설치 시 설정한 비밀번호"
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql ;
	private String returns=null;


	// 데이터베이스와 통신하기 위한 코드가 들어있는 메서드
	
	public String sym(String disease) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
			sql = "select * from complication_table where disease=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, disease);
			rs = pstmt.executeQuery();
			while (rs.next()) {
			returns=rs.getString("symptom");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
		if (rs != null)try {rs.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();} catch (SQLException ex) {}
		
		}
		return returns;
	}
	

}



