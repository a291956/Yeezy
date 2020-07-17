package xianWE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test2 {

	public static void main(String[] args) {
		clobReadDemo();
		System.out.println("YES");  
	}
	
	static void clobReadDemo(){
		Connection conn= null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from t1 where title='–°±ÍÃ‚'";  
			stm=conn.prepareStatement(sql);
	    rs=stm.executeQuery();
	    if( rs.next()){  
		    System.out.println(rs.getString("title"));   
		    Reader r=rs.getCharacterStream("content");   
		    BufferedReader br=new BufferedReader(r);
		    BufferedWriter bw=new BufferedWriter(new FileWriter("D:/IO.txt"));
		    String str=null;
		    while((str=br.readLine())!=null){
		    	bw.write(str);
		    	bw.newLine();
		    	bw.flush();
		    }						    
		    br.close();
		    bw.close();
	    }   
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stm, rs);
		}
	}	
	
	
	
	

}
