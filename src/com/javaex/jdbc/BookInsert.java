package com.javaex.jdbc;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInsert {

	public static void main(String[] args) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			/*insert into 		book
				values(seq_book_id2.nextval,'우리들의 일그러진 영웅', '다림', to_char('1998-02-22'), '1');
			*/
			
			String query = "";
			query += " insert into 		book "; 
			query += " values(seq_book_id2.nextval, ? , ? , ? , ?";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "우리들의 일그러진 영웅");
			pstmt.setString(2, "다림");
			
			String day = "1998-02-22";
			java.sql.Date d = java.sql.Date.valueOf(day);
			pstmt.setDate(3, d);
			pstmt.setInt(4, 1);
			
			int count = 0;
			
			count += pstmt.executeUpdate();
			
			pstmt.setString(1, "삼국지");
			pstmt.setString(2, "민음사");
			String day1 = "2002-03-01";
			java.sql.Date d1 = java.sql.Date.valueOf(day1);
			pstmt.setDate(3, d1);
			pstmt.setInt(4, 1);
			
			count += pstmt.executeUpdate();
			
			pstmt.setString(1, "토지");
			pstmt.setString(2, "마로니에북스");
			String day2 = "2012-08-15";
			java.sql.Date d2 = java.sql.Date.valueOf(day2);
			pstmt.setDate(3, d2);
			pstmt.setInt(4, 2);
			
			count += pstmt.executeUpdate();
			
			pstmt.setString(1, "유시민의 글쓰기 특강");
			pstmt.setString(2, "생각의 길");
			String day3 = "2015-04-01";
			java.sql.Date d3 = java.sql.Date.valueOf(day3);
			pstmt.setDate(3, d3);
			pstmt.setInt(4, 3);
			
			count += pstmt.executeUpdate();
			
			pstmt.setString(1, "패션왕");
			pstmt.setString(2, "중앙북스(books)");
			String day4 = "2012-02-22";
			java.sql.Date d4 = java.sql.Date.valueOf(day4);
			pstmt.setDate(3, d4);
			pstmt.setInt(4, 4);
			
			count += pstmt.executeUpdate();
			
			pstmt.setString(1, "순정만화");
			pstmt.setString(2, "재미주의");
			String day5 = "2011-08-03";
			java.sql.Date d5 = java.sql.Date.valueOf(day5);
			pstmt.setDate(3, d5);
			pstmt.setInt(4, 5);
			
			count += pstmt.executeUpdate();
			
			pstmt.setString(1, "오직두사람");
			pstmt.setString(2, "문학동네");
			String day6 = "2017-05-04";
			java.sql.Date d6 = java.sql.Date.valueOf(day6);
			pstmt.setDate (3, d6);
			pstmt.setInt(4, 6);
			
			count += pstmt.executeUpdate();
			
			pstmt.setString(1, "26년");
			pstmt.setString(2, "재미주의");
			String day3 = "2015-04-01";
			java.sql.Date d3 = java.sql.Date.valueOf(day3);
			pstmt.setString(3, "2012-02-04");
			pstmt.setInt(4, 5);
			
			count += pstmt.executeUpdate();
			
			System.out.println(count+"건이 저장되었습니다");
			
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


	}



}
