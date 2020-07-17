package xianWE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
private DBUtil(){}  // 防止别人创建本类实例
	
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/sm21?useUnicode=true&amp;characterEncoding=utf-8";
	private static String user="root";
	private static String password="root";
	
	static{
		try { //加载驱动类
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//拿连接
	public static Connection getConnection(){
		Connection conn =null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关连接
	public static void close(Connection conn,Statement stm,ResultSet rs){
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stm !=null){
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs !=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
