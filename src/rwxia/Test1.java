package rwxia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sm21", "root", "root");
		
		Statement stm=conn.createStatement();
		
		ResultSet rs=stm.executeQuery("select * from xs");
		   
		while(rs.next()){
			int Scredits=rs.getInt("Scredits");
			
				
			System.out.println(Scredits+"\t");	
		}
		
		//清理资源
		rs.close();
		stm.close();
		conn.close();  
	}
}
