package com.kh.team.domain;

import java.sql.Date;

public class CampingTalkVo {
	private int campingtalk_no;				
	private String campingtalk_title;		
	private Date ampingtalk_content;		
	private String campingtalk_date;		
	private String campingtalk_id;
	private String table_name;
	private String campingtalk_writer;
	private String campingtalk_img;
	private int campingtalk_admin;
	
	public CampingTalkVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CampingTalkVo(int campingtalk_no, String campingtalk_title, Date ampingtalk_content, String campingtalk_date,
			String campingtalk_id) {
		super();
		this.campingtalk_no = campingtalk_no;
		this.campingtalk_title = campingtalk_title;
		this.ampingtalk_content = ampingtalk_content;
		this.campingtalk_date = campingtalk_date;
		this.campingtalk_id = campingtalk_id;
	}
	
	
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getCampingtalk_writer() {
		return campingtalk_writer;
	}
	public void setCampingtalk_writer(String campingtalk_writer) {
		this.campingtalk_writer = campingtalk_writer;
	}
	public String getCampingtalk_img() {
		return campingtalk_img;
	}
	public void setCampingtalk_img(String campingtalk_img) {
		this.campingtalk_img = campingtalk_img;
	}
	public int getCampingtalk_admin() {
		return campingtalk_admin;
	}
	public void setCampingtalk_admin(int campingtalk_admin) {
		this.campingtalk_admin = campingtalk_admin;
	}
	public int getCampingtalk_no() {
		return campingtalk_no;
	}
	public void setCampingtalk_no(int campingtalk_no) {
		this.campingtalk_no = campingtalk_no;
	}
	public String getCampingtalk_title() {
		return campingtalk_title;
	}
	public void setCampingtalk_title(String campingtalk_title) {
		this.campingtalk_title = campingtalk_title;
	}
	public Date getAmpingtalk_content() {
		return ampingtalk_content;
	}
	public void setAmpingtalk_content(Date ampingtalk_content) {
		this.ampingtalk_content = ampingtalk_content;
	}
	public String getCampingtalk_date() {
		return campingtalk_date;
	}
	public void setCampingtalk_date(String campingtalk_date) {
		this.campingtalk_date = campingtalk_date;
	}
	public String getCampingtalk_id() {
		return campingtalk_id;
	}
	public void setCampingtalk_id(String campingtalk_id) {
		this.campingtalk_id = campingtalk_id;
	}
	@Override
	public String toString() {
		return "CampingTalkVo [campingtalk_no=" + campingtalk_no + ", campingtalk_title=" + campingtalk_title
				+ ", ampingtalk_content=" + ampingtalk_content + ", campingtalk_date=" + campingtalk_date
				+ ", campingtalk_id=" + campingtalk_id + "]";
	}		
	
	
}
