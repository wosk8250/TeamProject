package com.kh.team.domain;

public class ReservationVo {
	private int camp_no;
	private String startdate;
	private String enddate;	
	private String user_id;
	private String camp_name;
	private String host;
	
	
	
	public ReservationVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ReservationVo(int camp_no, String startdate, String enddate, String user_id) {
		super();
		this.camp_no = camp_no;
		this.startdate = startdate;
		this.enddate = enddate;
		this.user_id = user_id;
	}


	public int getCamp_no() {
		return camp_no;
	}
	public void setCamp_no(int camp_no) {
		this.camp_no = camp_no;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getCamp_name() {
		return camp_name;
	}


	public void setCamp_name(String camp_name) {
		this.camp_name = camp_name;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	@Override
	public String toString() {
		return "ReservationVo [camp_no=" + camp_no + ", startdate=" + startdate + ", enddate=" + enddate + ", user_id="
				+ user_id + ", camp_name=" + camp_name + ", host=" + host + "]";
	}



	
	
}
