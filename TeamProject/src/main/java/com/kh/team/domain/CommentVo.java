package com.kh.team.domain;

import java.sql.Date;

public class CommentVo {
	private int comment_no;
	private String comment_id;
	private Date comment_date;
	private String comment_content;
	private int review_no;
	
	public CommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVo(int comment_no, String comment_id, Date comment_date, String comment_content, int review_no) {
		super();
		this.comment_no = comment_no;
		this.comment_id = comment_id;
		this.comment_date = comment_date;
		this.comment_content = comment_content;
		this.review_no = review_no;
	}


	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	
	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	@Override
	public String toString() {
		return "CommentVo [comment_no=" + comment_no + ", comment_id=" + comment_id + ", comment_date=" + comment_date
				+ ", comment_content=" + comment_content + ", review_no=" + review_no + "]";
	}


	
	
	
}
