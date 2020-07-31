package com.kh.team.domain;

public class AreaCampingNameVo {
	private int area_camping_no;
	private String area_si;
	private String area_gu;
	private String area_camping;
	
	
	public AreaCampingNameVo() {
		super();
	}





	public AreaCampingNameVo(int area_camping_no, String area_si, String area_gu, String area_camping) {
		super();
		this.area_camping_no = area_camping_no;
		this.area_si = area_si;
		this.area_gu = area_gu;
		this.area_camping = area_camping;
	}





	public int getArea_camping_no() {
		return area_camping_no;
	}


	public void setArea_camping_no(int area_camping_no) {
		this.area_camping_no = area_camping_no;
	}


	public String getArea_si() {
		return area_si;
	}


	public void setArea_si(String area_si) {
		this.area_si = area_si;
	}


	public String getArea_camping() {
		return area_camping;
	}


	public void setArea_camping(String area_camping) {
		this.area_camping = area_camping;
	}
	


	public String getArea_gu() {
		return area_gu;
	}


	public void setArea_gu(String area_gu) {
		this.area_gu = area_gu;
	}





	@Override
	public String toString() {
		return "AreaCampingNameVo [area_camping_no=" + area_camping_no + ", area_si=" + area_si + ", area_gu=" + area_gu
				+ ", area_camping=" + area_camping + "]";
	}








	
	
}
