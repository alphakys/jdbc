package com.javaex.book02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
	
	//필드
		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String id = "webdb ", pw = "webdb" ;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookVo> bookList;
		
		//생성자
		
		//g/s
		public String getDriver() {
			return driver;
		}
		public void setDriver(String driver) {
			this.driver = driver;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		
		//메서드
		
		//DB접속 메서드
		
		private void getConnection() {
			
			try {
			    // 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName(driver);

			    // 2. Connection 얻어오기
				conn = DriverManager.getConnection(url, id, pw);
				
			} catch (ClassNotFoundException e) {
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
		
		
		
		public int bookInsert(BookVo bv) {
	
				// insert가 제대로 되었는지 확인용 count
				int count = 0;
			
				getConnection();

			    // 3. SQL문 준비 / 바인딩 / 실행
			   //SQL문
				try {
				String query = " insert into book values(seq_book_id.nextval, ? , ? , ? , ? )";
				
				//바인딩
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, bv.title);
				pstmt.setString(2, bv.pubs);
				pstmt.setString(3, bv.pubDate);
				pstmt.setInt(4, bv.authorId);
				
				//실행
				count = pstmt.executeUpdate();
				
			    // 4.결과처리
				System.out.println(count + "건이 저장되었습니다.");
				
				
			} catch (SQLException e) {
			    System.out.println("error:" + e);
			} 
				close();
				
			return count;
		}
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		public int bookUpdate(int bookId, BookVo bv) {


			int count = 0;
			
			getConnection();
			try {

			    // 3. SQL문 준비 / 바인딩 / 실행
				//SQL문
				String query =   " update book ";
						   query += " set		  title = ?, ";
						   query += " 		  	  pubs = ? ,";
						   query += " 			  pub_date = ? ,	 ";
						   query += "     		  author_id = ?	";
						   query += " where  book_id = ?  ";
						  
				//바인딩
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, bv.title);
				pstmt.setString(2, bv.pubs);
				pstmt.setString(3, bv.pubDate);
				pstmt.setInt(4, bv.authorId);
				pstmt.setInt(5, bookId);
				
				//실행
				count = pstmt.executeUpdate();
				
			    // 4.결과처리
				System.out.println(count + "건이 업데이트 되었습니다.");
				
			    // 4.결과처리

			} catch (SQLException e) {
			    System.out.println("error:" + e);
			}
			
			close();
			
			return count;
		}
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		
		public int bookDelete(int bookId) {
	
			int count = 0;
			
			getConnection();
			
			try {

			    // 3. SQL문 준비 / 바인딩 / 실행
			    String query = " delete from book where book_id = ? ";
			    pstmt = conn.prepareStatement(query);
			    
			    pstmt.setInt(1, bookId);
			    
			    count = pstmt.executeUpdate();
			    
			    // 4.결과처리
			    
			    System.out.println(count + "건이 삭제되었습니다");
			    
			    
			}catch (SQLException e) {
			    System.out.println("error:" + e);
			} 
			
			close();
			
			return count;
		}
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		public ArrayList<BookVo> getBookList() {
			
			getConnection();

			 bookList = new ArrayList<>();
			
			try {

			    // 3. SQL문 준비 / 바인딩 / 실행
				//SQL문
			    String query = "select 	book_id, ";
						   query += "			title, ";		
						   query += "			pubs, ";
						   query += "			pub_date, ";
						   query += "			author_id ";
						   query += "from	book ";
						   query += "order by book_id asc ";
				//바인딩
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					int bookId = rs.getInt("book_id");
					String title = rs.getString("title");
					String pubs = rs.getString("pubs");
					String pubDate = rs.getString("pub_date");
					int authorId = rs.getInt("author_id");
					
					bookList.add(new BookVo( bookId, title,  pubs, pubDate, authorId));
					System.out.println(bookId + ", " + title+ ", "+pubs+ ", "+pubDate+ ", "+authorId);
				}
						   
			    // 4.결과처리
			
				
			}  catch (SQLException e) {
			    System.out.println("error:" + e);
			}
			
			close();
			
			return bookList;
		}
		

		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		
		public void bookSearch(String keyword) {
			
			getBookList();
			
			for(int i=0; i<bookList.size(); i++) {
				
				String findTitle = bookList.get(i).title;
				String findPubs = bookList.get(i).pubs;
				
				if(bookList.get(i).title.contains(keyword)) {
					
					System.out.println("헤당 키워드를 "+"\n"+"book_id = "+
												bookList.get(i).bookId + "의 title에서 찾았습니다." + "\n"+ bookList.get(i).title);
				}
				else if(bookList.get(i).pubs.contains(keyword)) {
					
					System.out.println("헤당 키워드를 "+"\n"+"book_id = "+
												bookList.get(i).bookId + "의 pubs에서 찾았습니다." + "\n"+ bookList.get(i).pubs);
				}
				
				
				
			}
			
			
		}
		
		
		

		

}
