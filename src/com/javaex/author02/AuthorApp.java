package com.javaex.author02;


import java.util.ArrayList;

public class AuthorApp {

	public static void main(String[] args) {
	
		ArrayList<AuthorVo> aList;
		
		AuthorVo av1 = new AuthorVo("이문열", "경북 영양");
		AuthorVo av2 = new AuthorVo("박경리", "경상남도 통영");
		AuthorVo av3 = new AuthorVo("유시민", "17대 국회의원");
		AuthorVo av4 = new AuthorVo("기안 84", "기안동에서 산 84년생");
		AuthorVo av5 = new AuthorVo("강풀", "온라인 만화가 1세대");
		AuthorVo av6 = new AuthorVo("김영하", "알쓸신잡");
		
		
		AuthorDao aDao = new AuthorDao();
		
		aDao.authorInsert(av1);
		aDao.authorInsert(av2);
		aDao.authorInsert(av3);
		aDao.authorInsert(av4);
		aDao.authorInsert(av5);
		aDao.authorInsert(av6);
		
		aList = aDao.getAuthorList();
		
		for(int i=0; i<aList.size(); i++) {
			
			System.out.println(aList.get(i).authorId + ", " + aList.get(i).authorName + ", " 
			+ aList.get(i).authorDesc);
		
		}
		
		
		
		
		
		/*
			AuthorVo av1 = new AuthorVo("강용수","부산");
			AuthorVo av2 = new AuthorVo("강정수", "김해");
			AuthorVo av3 = new AuthorVo("윤미순", "김해");
			
			aDao.authorInsert(av1);
			aDao.authorInsert(av2);
			
			aDao.authorUpdate(1, av3);
			
			
			aList = aDao.getAuthorList();
			
			System.out.println(aList.toString());
			
			
			
			for(int i=0; i<aList.size(); i++) {
				
				System.out.println(aList.get(i).authorId + ", " + aList.get(i).authorName + ", " 
				+ aList.get(i).authorDesc);
			
			}
			
			aDao.authorDelete(1);
			
			aList = aDao.getAuthorList();
			
			
			System.out.println(aList.toString());
			
			
			AuthorVo av3 = new AuthorVo("윤미순", "김해");
			AuthorVo av4 = new AuthorVo("강철", "김해");
			
			aDao.authorInsert(av3);
			aList = aDao.getAuthorList();
			
			aDao.authorUpdate(3, av4);
			aList = aDao.getAuthorList();
			
			System.out.println(aList.toString());
			
		*/
		
	}

}
