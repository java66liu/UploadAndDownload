package net.hncu.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcHelper {
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/upload_image?useUnicode=true&characterEncoding=UTF-8";
	private static final String DB_USER = "feat";
	private static final String DB_PWD = "feat"; 
	protected Connection con;
	protected PreparedStatement pstmt;
	protected Statement stmt;
	protected ResultSet rst;

	public boolean openConnection(){
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL,DB_USER, DB_PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}

	public boolean closeResource(){		
		try {
			if(rst != null)		
				rst.close();
			if(pstmt != null)
				pstmt.close();
			if(stmt != null)
				stmt.close();
			if(con != null)
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
				return false;
			}		
		return true;
	}
}
