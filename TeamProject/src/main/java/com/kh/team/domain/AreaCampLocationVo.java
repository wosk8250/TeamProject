package com.kh.team.domain;

public class AreaCampLocationVo {

	private int camp_no;
	private String camp_area;
	private String camp_location;

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
		return "AreaCampLocationVo [camp_no=" + camp_no + ", camp_area=" + camp_area + ", camp_location="
				+ camp_location + "]";
	}

	

}
