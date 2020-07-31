
package com.kh.team.domain;

import java.sql.Date;


public class CampNoticeVo {
	private String notice_no;     //  공지사항 번호
	private String notice_title;  // 제목
	private String notice_content;  // 내용
	private String notice_writer; // 작성자
	private String table_name; // 작성자
	private Date notice_date; // 날짜 
	private int notice_view; //조회수
	private int notice_admin;
	
	public CampNoticeVo() {
		super();
	}



	public CampNoticeVo(String notice_no, String notice_title, String notice_content, String notice_writer,
			Date notice_date, int notice_view) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_writer = notice_writer;
		this.notice_date = notice_date;
		this.notice_view = notice_view;
	}



	public String getTable_name() {
		return table_name;
	}



	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}



	public int getNotice_admin() {
		return notice_admin;
	}



	public void setNotice_admin(int notice_admin) {
		this.notice_admin = notice_admin;
	}



	public String getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_writer() {
		return notice_writer;
	}

	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_data) {
		this.notice_date = notice_data;
	}
	

	public int getNotice_view() {
		return notice_view;
	}



	public void setNotice_view(int notice_view) {
		this.notice_view = notice_view;
	}



	@Override
	public String toString() {
		return "CampNoticeVo [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_writer=" + notice_writer + ", notice_date=" + notice_date
				+ ", notice_view=" + notice_view + "]";
	}





	

	
	
	
	
}


	
	
	
	
	

