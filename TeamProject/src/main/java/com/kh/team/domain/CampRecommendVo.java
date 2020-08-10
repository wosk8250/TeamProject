package com.kh.team.domain;

public class CampRecommendVo {

	private int camp_no;
	private String user_id;
	private int check_num;

	public int getCamp_no() {
		return camp_no;
	}

	public void setCamp_no(int camp_no) {
		this.camp_no = camp_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getCheck_num() {
		return check_num;
	}

	public void setCheck_num(int check_num) {
		this.check_num = check_num;
	}

	@Override
	public String toString() {
		return "CampingRecommend [camp_no=" + camp_no + ", user_id=" + user_id + ", check_num=" + check_num + "]";
	}

}
