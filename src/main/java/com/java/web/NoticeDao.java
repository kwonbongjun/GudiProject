package com.java.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {
	@Autowired
	SqlSession s;

	
	public List<Login> loginselect(Login login) {
		List<Login> list=new ArrayList<Login>(); 
		Map<String,Login> map=new HashMap<String, Login>();
		System.out.println("1");
//		System.out.println(s.selectList("test.login").get(0));

	  	return s.selectList("test.login", login); 
	}
	public int contentselectAll() {
		return s.selectOne("test.contentall");
	}
	public List<Bean> contentselect(int pageNum) {
		return s.selectList("test.content",pageNum);
	}
	public void insertContent(Bean bean ) {
		System.out.println("2");
		s.insert("test.insert",bean);
		System.out.println("2");
	}

	public void updateContent(Bean bean ) {
		s.update("test.update",bean);
	}
	public void deleteContent(Bean bean ) {
		s.update("test.delete",bean);
	}
	
	public Bean detailselect(int no){
		return s.selectOne("test.detail",no);
	}
	public void updateDetail(Bean bean) {
		s.update("test.updateDetail",bean);	
	}
	public void deleteDetail(int no) {
		s.update("test.deleteDetail",no);
	}
//	public void insertContent(String val ) {
//		s.insert("test.insert",val);
//	}


}
