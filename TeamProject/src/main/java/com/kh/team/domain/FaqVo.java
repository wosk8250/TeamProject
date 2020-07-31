package com.kh.team.domain;

import java.sql.Date;

public class FaqVo {

	
	private String faq_title;	
	private String faq_content;	
	private String faq_writer;	
	private String table_name;	
	private Date faq_date;		
	private int faq_no;			
	private int faq_view;
	private int faq_admin;
	public FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqVo(String faq_title, String faq_content, String faq_writer, Date faq_date, int faq_no, int faq_view) {
		super();
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_writer = faq_writer;
		this.faq_date = faq_date;
		this.faq_no = faq_no;
		this.faq_view = faq_view;
	}
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public int getFaq_admin() {
		return faq_admin;
	}
	public void setFaq_admin(int faq_admin) {
		this.faq_admin = faq_admin;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public String getFaq_writer() {
		return faq_writer;
	}
	public void setFaq_writer(String faq_writer) {
		this.faq_writer = faq_writer;
	}
	public Date getFaq_date() {
		return faq_date;
	}
	public void setFaq_date(Date faq_date) {
		this.faq_date = faq_date;
	}
	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public int getFaq_view() {
		return faq_view;
	}
	public void setFaq_view(int faq_view) {
		this.faq_view = faq_view;
	}
	@Override
	public String toString() {
		return "FaqVo [faq_title=" + faq_title + ", faq_content=" + faq_content + ", faq_writer=" + faq_writer
				+ ", faq_date=" + faq_date + ", faq_no=" + faq_no + ", faq_view=" + faq_view + "]";
	}
	
	
	
}
