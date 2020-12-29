package com.javaex.daointerface;

public class BookVo {
		
	//필드
	public int bookId, authorId;
	public String title, pubs, pubDate;
	
	//생성자
	public BookVo( String title, String pubs, String pubDate, int authorId) {
		
		
		this.authorId = authorId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}

	public BookVo(int bookId,  String title, String pubs, String pubDate, int authorId) {
		
		this.bookId = bookId;
		this.authorId = authorId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
	}
	
	
	
	//g/s
	
	//메서드
	
	
	
	
}
