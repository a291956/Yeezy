package rwxia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {
	public static void main(String[] args) {
		Connection conn =null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn =DBUtil.getConnection();
			stm= conn.createStatement();
			String sql="select * from xs";
			rs = stm.executeQuery(sql);
			System.out.println("学号是:   "+"\t"+"姓名是:"+"\t"+"性别是:  "+"\t");
			while(rs.next()){
				int Sno = rs.getInt("Sno");
				String SName = rs.getString("SName");
				String SSex = rs.getString("SSex");
			System.out.println(Sno+"\t"+SName+"\t"+SSex+"\t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, rs);
			
		}
	}

}
	