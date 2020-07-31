package com.kh.team.domain;

import java.sql.Date;
import java.util.Arrays;

public class CampingTipVo {

	private int campingtip_no;				
	private String campingtip_title;		
	private String campingtip_content;				
	private Date campingtip_date;			
	private String campingtip_writer;
	private int campingtip_view;
	private int campingtip_admin;
	private String[] files;
	private String campingtip_img;
	private String campingtip_listFile;
	private String table_name;
	public CampingTipVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CampingTipVo(int campingtip_no, String campingtip_title, String campingtip_content, Date campingtip_date,
			String campingtip_writer, int campingtip_view) {
		super();
		this.campingtip_no = campingtip_no;
		this.campingtip_title = campingtip_title;
		this.campingtip_content = campingtip_content;
		this.campingtip_date = campingtip_date;
		this.campingtip_writer = campingtip_writer;
		this.campingtip_view = campingtip_view;
	}

	
	
	public String getCampingtip_img() {
		return campingtip_img;
	}

	public void setCampingtip_img(String campingtip_img) {
		this.campingtip_img = campingtip_img;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public int getCampingtip_admin() {
		return campingtip_admin;
	}

	public void setCampingtip_admin(int campingtip_admin) {
		this.campingtip_admin = campingtip_admin;
	}

	
	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	
	public String getCampingtip_listFile() {
		return campingtip_listFile;
	}

	public void setCampingtip_listFile(String campingtip_listFile) {
		this.campingtip_listFile = campingtip_listFile;
	}

	public int getCampingtip_no() {
		return campingtip_no;
	}

	public void setCampingtip_no(int campingtip_no) {
		this.campingtip_no = campingtip_no;
	}

	public String getCampingtip_title() {
		return campingtip_title;
	}

	public void setCampingtip_title(String campingtip_title) {
		this.campingtip_title = campingtip_title;
	}

	public String getCampingtip_content() {
		return campingtip_content;
	}

	public void setCampingtip_content(String campingtip_content) {
		this.campingtip_content = campingtip_content;
	}

	public Date getCampingtip_date() {
		return campingtip_date;
	}

	public void setCampingtip_date(Date campingtip_date) {
		this.campingtip_date = campingtip_date;
	}

	public String getCampingtip_writer() {
		return campingtip_writer;
	}

	public void setCampingtip_writer(String campingtip_writer) {
		this.campingtip_writer = campingtip_writer;
	}

	public int getCampingtip_view() {
		return campingtip_view;
	}

	public void setCampingtip_view(int campingtip_view) {
		this.campingtip_view = campingtip_view;
	}

	@Override
	public String toString() {
		return "CampingTipVo [campingtip_no=" + campingtip_no + ", campingtip_title=" + campingtip_title
				+ ", campingtip_content=" + campingtip_content + ", campingtip_date=" + campingtip_date
				+ ", campingtip_writer=" + campingtip_writer + ", campingtip_view=" + campingtip_view
				+ ", campingtip_admin=" + campingtip_admin + ", files=" + Arrays.toString(files) + ", campingtip_img="
				+ campingtip_img + ", campingtip_listFile=" + campingtip_listFile + ", table_name=" + table_name + "]";
	}

	

	




	


	

	
	
}
