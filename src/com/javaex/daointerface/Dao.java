package com.javaex.daointerface;

import java.util.List;

public interface Dao {
	
	//데이터베이스에 값을 넣는 메소드
	int insert(Object obj);
	
	//데이터베이스에 값을 삭제하는 메소드
	int delete(int id);
	
	//데이터베이스의 값을 수정하는 메소드
	int update(int id, Object obj);
	
	//데이터베이스의 값을 리스트에 담아서 가져오는 메소드
	List getList();
	
	//키워드를 찾는 메소드
	void search(String keyword);
	
	
}
