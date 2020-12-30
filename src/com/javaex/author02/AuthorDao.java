package com.javaex.author02;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
			
	//필드
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";
	
	
	//생성자
	
	//g/s
	
	//메서드
	
	// DB접속 메서드
	private void getConnection()  {
		
		try {
		 // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

	    // 2. Connection 얻어오기
		conn = DriverManager.getConnection(url, id , pw);
		
		System.out.println("접속 성공");
		       }
		catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		
	}
	
	
	//자원 정리 메서드
	
	public void close() {
	   
		try {
	        if (rs != null) {
	            rs.close();
	        }                
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    } catch (SQLException e) {
	        System.out.println("error:" + e);
	    }
		
	}
	
	
	
	public int authorUpdate(int authorId, AuthorVo av) {
		
		int count=0;
		 
		getConnection();
		
		try {
		
		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = " update author ";
		    query += " set  author_name = ? , ";
		    query += "        author_desc = ? ";
		    query += " where  author_id = ? ";
		    
		  pstmt = conn.prepareStatement(query);
		  pstmt.setString(1, av.authorName);
		  pstmt.setString(2, av.authorDesc);
		  pstmt.setInt(3, authorId);
		  
		  count = pstmt.executeUpdate();
		  
		    // 4.결과처리
		  System.out.println("[Dao]]" + count + "건 수정했습니다");
		  
		  
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		   
		    // 5. 자원정리
			close();

		return count;
		
	}
	
	
	
	
	
	public int authorDelete(int authorId) {
		
		int count = 0;
		
		getConnection();

			try {


		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "delete from author where author_id = ? ";
		    
		    pstmt = conn.prepareStatement(query);
		    pstmt.setInt(1, authorId);
		    
		    count = pstmt.executeUpdate();
		    
		    // 4.결과처리
		    System.out.println("[Dao]]" + count + "건 삭제했습니다");
		    
		    
		    
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
			
		close();

		return count;
		
	}
	
	
	
	
	
	
	public ArrayList<AuthorVo> getAuthorList() {
		
		ArrayList<AuthorVo> authorList = new ArrayList<>();
		
		getConnection();

		try {
		
			
		    // 3. SQL문 준비 / 바인딩 / 실행
			/*select 	 author_id,
		       				 author_name,
		       				 author_desc
				from author
			*/	
		
		   String query = "select 	 author_id,";
		   
		   query += " 		 				  author_name,";
		   query += "  						  author_desc";
		   query += " 		 from 		  author";
		   query += " 		 order by   author_id asc";
		   
		   pstmt = conn.prepareStatement(query);
		   
		   rs = pstmt.executeQuery();
		  
			
			
			while(rs.next()) {
		    	 
				int authorId = rs.getInt(1);
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString(3);
				
				authorList.add(new AuthorVo(authorId, authorName, authorDesc));
		    
		    }
			

		    // 4.결과처리
			
	
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		
		close();
		
		return authorList;
	}
	
	
	
	
	
	public int authorInsert(AuthorVo av) {
	
		int count = 0;
		
		getConnection();
		
		try {

		    // 3. SQL문 준비 / 바인딩 / 실행
		    //insert into author values(seq_author_id.nextval, '이문열' , '경북 영양')
			String query = " insert into author values(seq_author_id.nextval, ? , ? ) ";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, av.getAuthorName());
			pstmt.setString(2, av.getAuthorDesc());
			
			count = pstmt.executeUpdate();
		    // 4.결과처리
			
			System.out.println("[Dao]]" + count + "건 삽입했습니다");
				
				
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		
		close();
		
		return count;
	
	}
}
