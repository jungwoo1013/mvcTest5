package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springproject";
	private String user = "atom";
	private String password = "1398";
	
	//싱글톤으로 conn객체를 만들어서 사용하기
	private static Connection conn;
	@SuppressWarnings("unused")
	private static DbConnection instance = new DbConnection();	
	
	private DbConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 오류입니다." + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패입니다." + e.getMessage());
		}	
	}

//	public static DbConnection getInstance() {
//		return instance;
//	}
	
	public static Connection getConn() {
		return conn;
	}
}
