package com.kh.team.domain;

import java.sql.Date;

import javax.xml.crypto.Data;

public class DemeritVo {

	private int demerit_num;			
	private String demerit_code;		
	private String demerit_content;		
	private String user_id;				
	private int demerit_value;
	private String demerit_date;
	public DemeritVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DemeritVo(int demerit_num, String demerit_code, String demerit_content, String user_id, int demerit_value,
			String demerit_date) {
		super();
		this.demerit_num = demerit_num;
		this.demerit_code = demerit_code;
		this.demerit_content = demerit_content;
		this.user_id = user_id;
		this.demerit_value = demerit_value;
		this.demerit_date = demerit_date;
	}

	public int getDemerit_num() {
		return demerit_num;
	}
	public void setDemerit_num(int demerit_num) {
		this.demerit_num = demerit_num;
	}
	public String getDemerit_code() {
		return demerit_code;
	}
	public void setDemerit_code(String demerit_code) {
		this.demerit_code = demerit_code;
	}
	public String getDemerit_content() {
		return demerit_content;
	}
	public void setDemerit_content(String demerit_content) {
		this.demerit_content = demerit_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getDemerit_value() {
		return demerit_value;
	}
	public void setDemerit_value(int demerit_value) {
		this.demerit_value = demerit_value;
	}
	public String getDemerit_date() {
		return demerit_date;
	}
	public void setDemerit_date(String demerit_date) {
		this.demerit_date = demerit_date;
	}
	@Override
	public String toString() {
		return "DemeritVo [demerit_num=" + demerit_num + ", demerit_code=" + demerit_code + ", demerit_content="
				+ demerit_content + ", user_id=" + user_id + ", demerit_value=" + demerit_value + ", demerit_date="
				+ demerit_date + "]";
	}
	
	
	
}
