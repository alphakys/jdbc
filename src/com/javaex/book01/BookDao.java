package com.javaex.book01;

import java.util.List;
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
		
		List<BookVo> bookList;
		
		//생성자
		
		//g/s

		//메서드
		
		public int bookInsert(BookVo bv) {
			// 0. import java.sql.*;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// insert가 제대로 되었는지 확인용 count
			int count = 0;
			
			try {
			    // 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName(driver);

			    // 2. Connection 얻어오기
				conn = DriverManager.getConnection(url, id, pw);

			    // 3. SQL문 준비 / 바인딩 / 실행
			   //SQL문
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
				
				
			} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
			    System.out.println("error:" + e);
			} finally {
			   
			    // 5. 자원정리
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
			return count;
		}
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		public int bookUpdate(int bookId, BookVo bv) {
			// 0. import java.sql.*;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int count = 0;
			
			try {
			    // 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName(driver);

			    // 2. Connection 얻어오기
				conn = DriverManager.getConnection(url, id, pw);

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

			} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
			    System.out.println("error:" + e);
			} finally {
			   
			    // 5. 자원정리
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
			return count;
		}
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		
		public int bookDelete(int bookId) {
			// 0. import java.sql.*;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int count = 0;
			
			try {
			    // 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName(driver);

			    // 2. Connection 얻어오기
				conn = DriverManager.getConnection(url, id, pw);

			    // 3. SQL문 준비 / 바인딩 / 실행
			    String query = " delete from book where book_id = ? ";
			    pstmt = conn.prepareStatement(query);
			    
			    pstmt.setInt(1, bookId);
			    
			    count = pstmt.executeUpdate();
			    
			    // 4.결과처리
			    
			    System.out.println(count + "건이 삭제되었습니다");
			    
			    
			} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
			    System.out.println("error:" + e);
			} finally {
			   
			    // 5. 자원정리
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
			return count;
		}
		
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		public List<BookVo> getBookList() {
			// 0. import java.sql.*;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			 bookList = new ArrayList<>();
			
			try {
			    // 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName(driver);

			    // 2. Connection 얻어오기
				conn = DriverManager.getConnection(url, id, pw);

			    // 3. SQL문 준비 / 바인딩 / 실행
				//SQL문
			    String query = "select 	book_id, ";
						   query += "			title, ";		
						   query += "			pubs, ";
						   query += "			pub_date, ";
						   query += "			b.author_id, ";
						   query += "			a.author_name, ";
						   query += "			a.author_desc ";
						   query += "from	book b, author a ";
						   query += "where b.author_id = a.author_id ";
				//바인딩
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					int bookId = rs.getInt("book_id");
					String title = rs.getString("title");
					String pubs = rs.getString("pubs");
					String pubDate = rs.getString("pub_date");
					int authorId = rs.getInt("author_id");
					String authorName = rs.getString("author_name");
					String authorDesc = rs.getString("author_desc");
					
					/* 확인용
					bookList.add(new BookVo( bookId, title,  pubs, pubDate, authorId, authorName, authorDesc));
					System.out.println(bookId + ", " + title+ ", "+pubs+ ", "+pubDate+ ", "+authorId + ", "+authorName + ", "+ authorDesc);
					*/
				}
						   
			    // 4.결과처리
			
				
			} catch (ClassNotFoundException e) {
			    System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
			    System.out.println("error:" + e);
			} finally {
			   
			    // 5. 자원정리
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
			return bookList;
		}
		

		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////	
		
		
		public List<BookVo> bookSearch(String keyword) {
			
			// 0. import java.sql.*;
						Connection conn = null;
						PreparedStatement pstmt = null;
						ResultSet rs = null;

						 bookList = new ArrayList<>();
						
						try {
						    // 1. JDBC 드라이버 (Oracle) 로딩
							Class.forName(driver);

						    // 2. Connection 얻어오기
							conn = DriverManager.getConnection(url, id, pw);

						    // 3. SQL문 준비 / 바인딩 / 실행
							//SQL문
						    String query = "select 	book_id, ";
									   query += "			title, ";		
									   query += "			pubs, ";
									   query += "			pub_date, ";
									   query += "			b.author_id, ";
									   query += "			a.author_name, ";
									   query += "			a.author_desc ";
									   query += "from	book b left outer join author a ";
									   query += "on	    b.author_id = a.author_id ";
									   query += "where title like ?  or pubs like  ?   ";
									   query += " or author_name like  ?  or author_desc like  ?  ";
									   
							//바인딩
							pstmt = conn.prepareStatement(query);
							
							
							keyword = "%"+keyword+"%";
									
							pstmt.setString(1, keyword);
							pstmt.setString(2, keyword);
							pstmt.setString(3, keyword);
							pstmt.setString(4, keyword);
							rs = pstmt.executeQuery();
							
							while(rs.next()) {
								
								int bookId = rs.getInt("book_id");
								String title = rs.getString("title");
								String pubs = rs.getString("pubs");
								String pubDate = rs.getString("pub_date");
								int authorId = rs.getInt("author_id");
								String authorName = rs.getString("author_name");
								String authorDesc = rs.getString("author_desc");
								
								
								bookList.add(new BookVo( bookId, title,  pubs, pubDate, authorId, authorName, authorDesc));
								
								System.out.println(bookId + ", " + title+ ", "+pubs+ ", "+pubDate+ ", "+authorId + ", "+authorName + ", "+ authorDesc);
								
							}
									   
						    // 4.결과처리
						
							
						} catch (ClassNotFoundException e) {
						    System.out.println("error: 드라이버 로딩 실패 - " + e);
						} catch (SQLException e) {
						    System.out.println("error:" + e);
						} finally {
						   
						    // 5. 자원정리
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
						return bookList;
				
			
			
			
		}
		
		
		

		

}
