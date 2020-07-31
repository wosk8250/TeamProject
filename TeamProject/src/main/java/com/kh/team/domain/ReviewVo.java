package com.kh.team.domain;

import java.sql.Date;
import java.util.Arrays;

public class ReviewVo {

	private String review_title; // 후기 제목
	private String review_content; // 내용
	private String review_id; // 아이디
	private int review_no; // 리뷰번호
	private Date review_date; // 날짜
	private int review_camp_no; // 캠핌장 번호
	private String review_campingname; // 캠핌장 이름
	private String 	review_area;
	private String review_location;
	private int review_admin;
	private String table_name;
	private String[] files;
	private String camp_listFile; //조회
	private String review_view; //조회수
	private String review_img;
	

	public ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReviewVo(String review_title, String review_content, String review_id, int review_no, Date review_date,
			int review_camp_no, String review_campingname, String review_area, String review_location, int review_admin,
			String table_name, String[] files, String camp_listFile, String review_view, String review_img) {
		super();
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_id = review_id;
		this.review_no = review_no;
		this.review_date = review_date;
		this.review_camp_no = review_camp_no;
		this.review_campingname = review_campingname;
		this.review_area = review_area;
		this.review_location = review_location;
		this.review_admin = review_admin;
		this.table_name = table_name;
		this.files = files;
		this.camp_listFile = camp_listFile;
		this.review_view = review_view;
		this.review_img = review_img;
	}




	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public int getReview_camp_no() {
		return review_camp_no;
	}

	public void setReview_camp_no(int review_camp_no) {
		this.review_camp_no = review_camp_no;
	}

	public String getReview_campingname() {
		return review_campingname;
	}

	public void setReview_campingname(String review_campingname) {
		this.review_campingname = review_campingname;
	}

	public String getReview_area() {
		return review_area;
	}

	public void setReview_area(String review_area) {
		this.review_area = review_area;
	}

	public String getReview_location() {
		return review_location;
	}

	public void setReview_location(String review_location) {
		this.review_location = review_location;
	}

	public int getReview_admin() {
		return review_admin;
	}

	public void setReview_admin(int review_admin) {
		this.review_admin = review_admin;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public String getCamp_listFile() {
		return camp_listFile;
	}

	public void setCamp_listFile(String camp_listFile) {
		this.camp_listFile = camp_listFile;
	}

	public String getReview_view() {
		return review_view;
	}

	public void setReview_view(String review_view) {
		this.review_view = review_view;
	}
	public String getReview_img() {
		return review_img;
	}

	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}

	@Override
	public String toString() {
		return "ReviewVo [review_title=" + review_title + ", review_content=" + review_content + ", review_id="
				+ review_id + ", review_no=" + review_no + ", review_date=" + review_date + ", review_camp_no="
				+ review_camp_no + ", review_campingname=" + review_campingname + ", review_area=" + review_area
				+ ", review_location=" + review_location + ", review_admin=" + review_admin + ", table_name="
				+ table_name + ", files=" + Arrays.toString(files) + ", camp_listFile=" + camp_listFile
				+ ", review_view=" + review_view + ", review_img=" + review_img + "]";
	}







}
