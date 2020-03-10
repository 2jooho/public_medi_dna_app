package androidjsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	// 싱글톤 패턴으로 사용 하기위 한 코드들
	private static ConnectDB instance = new ConnectDB();
	public static void main(String[] asdf)throws Exception{
		String b="aaaa";
		String c="123";
		String a=connectionDB(b,c);
		System.out.println(a);
	}
	
	  public static ConnectDB getInstance() { return instance; }
	  
	  public ConnectDB() {
	  
	  }
	 

	static String jdbcUrl = "jdbc:mysql://localhost:3306/DB이름"; // MySQL 계정
	static String dbId = ""; // MySQL 계정
	static String dbPw = ""; // 비밀번호
	static Connection conn = null;
	static PreparedStatement pstmt ;
	static PreparedStatement pstmt2 ;
	static ResultSet rs ;
	static String sql ;
	static String sql2 ;
	static String returns ;

	// 데이터베이스와 통신하기 위한 코드가 들어있는 메서드
	public static String connectionDB(String id, String pwd) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 디비 연결
                                
			conn = DriverManager.getConnection(jdbcUrl, "best54", "medi1607!");		
			sql = "SELECT ID FROM  User where ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			if(conn != null) {
				System.out.println("데이터베이스와 연결 성공");
				}else{
				throw new Exception("데이터베이스를 연결할 수 없습니다.");
				} 
			rs = pstmt.executeQuery();
		
			if (rs.next()) {
				// 정보를 넣는데 이미 정보가 존재할 경우(회원가입이 불가능한 경우
				returns = "회원가입 불가";

			} else {
				// 넣고자 하는 정보가 없을 경우 (회원가입이 가능한 경우)
				sql2 = "insert into User values(?,?)"; // 삽입
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, pwd);
				pstmt2.executeUpdate();
				returns = "회원가입 가능";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try{rs.close(); }catch(SQLException e){}
				}
			if (pstmt2 != null)try {pstmt2.close();	} catch (SQLException ex) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();	} catch (SQLException ex) {	}
		}
		
		return returns;
	}

}


