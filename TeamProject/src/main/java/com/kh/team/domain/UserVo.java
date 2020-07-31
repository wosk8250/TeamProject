package com.kh.team.domain;

public class UserVo {

	private String user_id;			
	private String user_pw;			
	private String user_phone;		
	private String user_name;		
	private String admin;
	private String user_stopdate;
	private String user_email;
	private int user_demerit;
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVo(String user_id, String user_pw, String user_phone, String user_name, String admin) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_phone = user_phone;
		this.user_name = user_name;
		this.admin = admin;
	}
	
	public String getUser_stopdate() {
		return user_stopdate;
	}
	public void setUser_stopdate(String user_stopdate) {
		this.user_stopdate = user_stopdate;
	}
	public int getUser_demerit() {
		return user_demerit;
	}
	public void setUser_demerit(int user_demerit) {
		this.user_demerit = user_demerit;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", user_pw=" + user_pw + ", user_phone=" + user_phone + ", user_name="
				+ user_name + ", admin=" + admin + ", user_stopdate=" + user_stopdate + ", user_email=" + user_email
				+ ", user_demerit=" + user_demerit + "]";
	}

	
	
	
	
	
}
