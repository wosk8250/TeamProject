package com.kh.team.domain;

public class searchDto {
	private String camp_location;
	private String camp_area;
	
	public searchDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public searchDto(String camp_location, String camp_area) {
		super();
		this.camp_location = camp_location;
		this.camp_area = camp_area;
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
	
	@Override
	public String toString() {
		return "searchDto [camp_location=" + camp_location + ", camp_area=" + camp_area + "]";
	}
	
	

}