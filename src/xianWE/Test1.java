package xianWE;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Test1 {
	public static void main(String[] args) {
		clobDemo();
		
	}
	static void clobDemo(){
		Connection conn= null;
		PreparedStatement stm=null;					
		try {
			conn=DBUtil.getConnection();
			System.out.println(conn);
			String sql="insert into t1 (title,content) values ( ?,?)";
			stm=conn.prepareStatement(sql);
			System.out.println(stm);
			stm.setString(1, "这是标题");
			Reader r=new FileReader("D:/name.txt");
			stm.setCharacterStream(2, r);    //传一个字符流
			stm.executeUpdate();
			r.close();									
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, null);
		}
	}			

}
