package com.javaex.book01;

public class BookVo {
		
	//필드
	public int bookId, authorId;
	public String title, pubs, pubDate, authorName, authorDesc;
	
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

	public BookVo(int bookId, String title, String pubs, String pubDate, int authorId , String authorName,
			String authorDesc) {
	
		this.bookId = bookId;
		this.authorId = authorId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	
	
	
	//g/s
	
	//메서드
	
	
	
	
}
