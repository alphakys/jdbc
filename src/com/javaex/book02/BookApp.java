package com.javaex.book02;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BookDao bd = new BookDao();
		
		
		bd.getBookList();

		
		String search = sc.nextLine();
		
		bd.bookSearch(search);
		
		
		/*
				ArrayList<BookVo> bList;	
		
		
		
		BookVo bv1 = new BookVo("우리들의 일그러진 영웅", "다림" , "1998-02-22" , 1);
		BookVo bv2 = new BookVo("삼국지", "민음사" , "2002-03-01" , 1);
		BookVo bv3 = new BookVo("토지", "마로니에북스" , "2012-08-15" , 2);
		BookVo bv4 = new BookVo("유시민의 글쓰기 특강", "생각의 길" , "2015-04-01" , 3);
		BookVo bv5 = new BookVo("패션왕", "중앙북스(books)" , "2012-02-22" , 4);
		BookVo bv6 = new BookVo("순정만화", "재미주의" , "2011-08-03" , 5);
		BookVo bv7 = new BookVo("오직두사람", "문학동네" , "2017-05-04" , 6);
		BookVo bv8 = new BookVo("26년", "재미주의" , "2012-02-04" , 5);
		
		bd.bookInsert(bv1);
		bd.bookInsert(bv2);
		bd.bookInsert(bv3);
		bd.bookInsert(bv4);
		bd.bookInsert(bv5);
		bd.bookInsert(bv6);
		bd.bookInsert(bv7);
		bd.bookInsert(bv8);
		
		bList = bd.getBookList();
		bd.bookInsert(bv1);
		bd.bookInsert(bv2);
		
		bList = bd.getBookList();
		
		
		BookVo bv3 = new BookVo("용수지", "민음사" , "2002-03-01" , 1);
		bd.bookUpdate(1, bv3);
		
		bList = bd.getBookList();
	
		
		bd.bookDelete(1);
		
		bList = bd.getBookList();
		
		*/
		
		
	}

}
