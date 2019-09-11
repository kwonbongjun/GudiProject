package com.java.web;

public class Bean {
	private int no;
	private String title;
	private String val;
	private String writer;

	public void update(String no,String title, String val) {
		this.no=Integer.parseInt(no);
		this.val=val;
		this.title=title;
	}
	public Bean(String title, String val, String writer) {
		this.val=val;
		this.title=title;
		this.writer=writer;
	}

	public Bean() {
		// TODO Auto-generated constructor stub
	}
	public void setNo(int no) {
		this.no=no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getNo() {
		return no;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val=val;
	}
	
}
