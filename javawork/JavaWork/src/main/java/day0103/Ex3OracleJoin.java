package day0103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleJoin {
	static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String username = "angel";
	String password = "pw1234";
	
	public Ex3OracleJoin() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("오라클 접속 성공");
		} catch (SQLException e) {
			System.out.println("오라클 접속 실패: " + e.getMessage());
		}
		
		return conn;
	}
	
	public void joinDataWrite() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql="""
				select 
				    s.sangcode, sangname, sangprice, cntnum, to_char(cartday,'yyyy-mm-dd') cartday
				from shop s, cart c
				where s.sangcode = c.sangcode
				""";
		
		conn=this.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("상품코드\t상품명\t상품가격\t수량\t등록일");
			System.out.println("=".repeat(60));
			
			while (rs.next()) {
				String code = rs.getString("sangcode");
				String sname = rs.getString("sangname");
				int sprice = rs.getInt("sangprice");
				int cnt = rs.getInt("cntnum");
				String cartday = rs.getString("cartday");
				
				System.out.println(code + "\t" + sname + "\t" + sprice + "\t" + cnt + "\t" + cartday);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex3OracleJoin ex3 = new Ex3OracleJoin();
		ex3.joinDataWrite();

	}

}
