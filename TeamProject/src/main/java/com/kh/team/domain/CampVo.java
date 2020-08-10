package com.kh.team.domain;

import java.util.Arrays;

public class CampVo {
	
	private int camp_no;			
	private String camp_address;	
	private String camp_phone;		
	private String camp_name;		
	private String camp_content;	
	private String camp_http;		
	private int camp_admin;
	private String camp_location;
	private String camp_area;
	private String table_name;
	private String[] files;
	private String thumbnail;
	private int recommend;
	private int viewcnt;
	private String operatingday;
	private String inclination;
	private String latitude;
	private String user_id;
	private String user_email;
	private String camp_operation;
	private String camp_weekdays;
	private String camp_weekend;
	private String camp_peakweekdays;
	private String camp_peakweekend;
	
	public CampVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CampVo(int camp_no, String camp_address, String camp_phone, String camp_name, String camp_content,
			String camp_http, String camp_location, String camp_area) {
		super();
		this.camp_no = camp_no;
		this.camp_address = camp_address;
		this.camp_phone = camp_phone;
		this.camp_name = camp_name;
		this.camp_content = camp_content;
		this.camp_http = camp_http;
	}
	
	

	public String getCamp_peakweekdays() {
		return camp_peakweekdays;
	}


	public void setCamp_peakweekdays(String camp_peakweekdays) {
		this.camp_peakweekdays = camp_peakweekdays;
	}


	public String getCamp_peakweekend() {
		return camp_peakweekend;
	}


	public void setCamp_peakweekend(String camp_peakweekend) {
		this.camp_peakweekend = camp_peakweekend;
	}


	public String getCamp_weekdays() {
		return camp_weekdays;
	}


	public void setCamp_weekdays(String camp_weekdays) {
		this.camp_weekdays = camp_weekdays;
	}


	public String getCamp_weekend() {
		return camp_weekend;
	}


	public void setCamp_weekend(String camp_weekend) {
		this.camp_weekend = camp_weekend;
	}


	public String getCamp_operation() {
		return camp_operation;
	}


	public void setCamp_operation(String camp_operation) {
		this.camp_operation = camp_operation;
	}


	public String getOperatingday() {
		return operatingday;
	}

	public void setOperatingday(String operatingday) {
		this.operatingday = operatingday;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public int getCamp_no() {
		return camp_no;
	}

	public void setCamp_no(int camp_no) {
		this.camp_no = camp_no;
	}

	public String getCamp_address() {
		return camp_address;
	}

	public void setCamp_address(String camp_address) {
		this.camp_address = camp_address;
	}

	public String getCamp_phone() {
		return camp_phone;
	}

	public void setCamp_phone(String camp_phone) {
		this.camp_phone = camp_phone;
	}

	public String getCamp_name() {
		return camp_name;
	}

	public void setCamp_name(String camp_name) {
		this.camp_name = camp_name;
	}

	public String getCamp_content() {
		return camp_content;
	}

	public void setCamp_content(String camp_content) {
		this.camp_content = camp_content;
	}

	public String getCamp_http() {
		return camp_http;
	}

	public void setCamp_http(String camp_http) {
		this.camp_http = camp_http;
	}

	public int getCamp_admin() {
		return camp_admin;
	}

	public void setCamp_admin(int camp_admin) {
		this.camp_admin = camp_admin;
	}

	public String getCamp_location() {
		return camp_location;
	}

	public void setCamp_location(String camp_location) {
		this.camp_location = camp_location;
	}

	public String getCamp_area() {
		return camp_area;
	}

	public void setCamp_area(String camp_area) {
		this.camp_area = camp_area;
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

	public String getInclination() {
		return inclination;
	}

	public void setInclination(String inclination) {
		this.inclination = inclination;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	@Override
	public String toString() {
		return "CampVo [camp_no=" + camp_no + ", camp_address=" + camp_address + ", camp_phone=" + camp_phone
				+ ", camp_name=" + camp_name + ", camp_content=" + camp_content + ", camp_http=" + camp_http
				+ ", camp_admin=" + camp_admin + ", camp_location=" + camp_location + ", camp_area=" + camp_area
				+ ", table_name=" + table_name + ", files=" + Arrays.toString(files) + ", thumbnail=" + thumbnail
				+ ", recommend=" + recommend + ", viewcnt=" + viewcnt + ", operatingday=" + operatingday
				+ ", inclination=" + inclination + ", latitude=" + latitude + ", user_id=" + user_id + ", user_email="
				+ user_email + ", camp_operation=" + camp_operation + ", camp_weekdays=" + camp_weekdays
				+ ", camp_weekend=" + camp_weekend + ", camp_peakweekdays=" + camp_peakweekdays + ", camp_peakweekend="
				+ camp_peakweekend + "]";
	}


}
