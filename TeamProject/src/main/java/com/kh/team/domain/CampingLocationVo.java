package com.kh.team.domain;

public class CampingLocationVo {
	
	private int camp_no;
	private String camp_area;
	private String camp_location;
	private String camp_address;	
	private String camp_phone;		
	private String camp_name;		
	private String camp_content;
	private int viewcnt;
	
	
	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
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

	public int getCamp_no() {
		return camp_no;
	}

	public void setCamp_no(int camp_no) {
		this.camp_no = camp_no;
	}

	public String getCamp_area() {
		return camp_area;
	}

	public void setCamp_area(String camp_area) {
		this.camp_area = camp_area;
	}

	public String getCamp_location() {
		return camp_location;
	}

	public void setCamp_location(String camp_location) {
		this.camp_location = camp_location;
	}

	@Override
	public String toString() {
		return "CampingLocationVo [camp_no=" + camp_no + ", camp_area=" + camp_area + ", camp_location=" + camp_location
				+ ", camp_address=" + camp_address + ", camp_phone=" + camp_phone + ", camp_name=" + camp_name
				+ ", camp_content=" + camp_content + ", viewcnt=" + viewcnt + "]";
	}

	
}
