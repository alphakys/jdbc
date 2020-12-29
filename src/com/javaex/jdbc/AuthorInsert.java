package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorInsert {

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
		    //insert into author values(seq_author_id.nextval, '이문열', '경북 영양' )
			
			//한건 처리
			String query = "insert into author values(seq_author_id.nextval, ?, ? )";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "");
			pstmt.setString(2, "");
			
			int count = pstmt.executeUpdate();
			
			System.out.println(count+"건이 저장되었습니다");
			
			//여러건 처리
			/*
			pstmt.setString(1, "이문열");
			pstmt.setString(2, "경북 영양");
			
			count += pstmt.executeUpdate();
			System.out.println(count);
			
			pstmt.setString(1, "박경리");
			pstmt.setString(2, "경상남도 통영");
			
			count += pstmt.executeUpdate();
			System.out.println(count);
			
			pstmt.setString(1, "유시민");
			pstmt.setString(2, "17대 국회의원");
			
			count += pstmt.executeUpdate();
			System.out.println(count);
			
			pstmt.setString(1, "기안84");
			pstmt.setString(2, "기안동에서 산 84년생");
			
			count += pstmt.executeUpdate();
			System.out.println(count);
			
			pstmt.setString(1, "강풀");
			pstmt.setString(2, "온라인 만화가 1세대");
			
			count += pstmt.executeUpdate();
			System.out.println(count);
			
			pstmt.setString(1, "김영하");
			pstmt.setString(2, "알쓸신잡");
			
			count += pstmt.executeUpdate();
			
			System.out.println(count+"건이 저장되었습니다");
			
			
			
			String query = "";
			query += " insert into author ";
			query += " values (seq_author_id2.nextval, '박경리', '경상남도 통영' )";
			
			System.out.println(query);
			
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.execute(query);
			
			*/
			
			
			
			
			
			
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
