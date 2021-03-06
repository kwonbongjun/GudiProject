package com.java.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
 @Autowired
 NoticeDao nd;
	
	public List<Login> loginRead(Login login){
		return nd.loginselect(login); 
	}
	 
 	public int contentReadAll(){
 		return nd.contentselectAll();
 	}
 	public List<Bean> contentRead(int pageNum){
 		return nd.contentselect(pageNum);
 	}
 	public void createContent(Bean bean) {
 		nd.insertContent(bean);
 	}

	public void updateContent(Bean bean) {
 		nd.updateContent(bean);
 	}
	public void deleteContent(Bean bean) {
 		nd.deleteContent(bean);
 	}
	
	public Bean detailRead(int no){
		return nd.detailselect(no);
	}
	
	public void updateDetail(Bean bean){
		nd.updateDetail(bean);
	}
	public void deleteDetail(int no){
		nd.deleteDetail(no);
	}
// 	public void createContent(String val) {
// 		nd.insertContent(val);
// 	}
}
