package com.kh.team.domain;

public class AmenitiesVo {

	private String power = "0";	
	private String wifi = "0";	
	private String hotwater = "0";
	private String trail = "0";	
	private String mart = "0";	
	private String park = "0";	
	private int camp_no;
	public AmenitiesVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AmenitiesVo(String power, String wifi, String hotwater, String trail, String mart, String park,
			int camp_no) {
		super();
		this.power = power;
		this.wifi = wifi;
		this.hotwater = hotwater;
		this.trail = trail;
		this.mart = mart;
		this.park = park;
		this.camp_no = camp_no;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getHotwater() {
		return hotwater;
	}
	public void setHotwater(String hotwater) {
		this.hotwater = hotwater;
	}
	public String getTrail() {
		return trail;
	}
	public void setTrail(String trail) {
		this.trail = trail;
	}
	public String getMart() {
		return mart;
	}
	public void setMart(String mart) {
		this.mart = mart;
	}
	public String getPark() {
		return park;
	}
	public void setPark(String park) {
		this.park = park;
	}
	public int getCamp_no() {
		return camp_no;
	}
	public void setCamp_no(int camp_no) {
		this.camp_no = camp_no;
	}
	@Override
	public String toString() {
		return "AmenitiesVo [power=" + power + ", wifi=" + wifi + ", hotwater=" + hotwater + ", trail=" + trail
				+ ", mart=" + mart + ", park=" + park + ", camp_no=" + camp_no + "]";
	}

	
	
}
