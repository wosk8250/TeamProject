package com.kh.team.domain;

public class DemeritCodeVo {
	
	
	private String demerit_code;		
	private String demerit_content;		
	private int demerit_value;
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
	public int getDemerit_value() {
		return demerit_value;
	}
	public void setDemerit_value(int demerit_value) {
		this.demerit_value = demerit_value;
	}
	@Override
	public String toString() {
		return "DemeritCodeVo [demerit_code=" + demerit_code + ", demerit_content=" + demerit_content
				+ ", demerit_value=" + demerit_value + "]";
	}			

	
	
}
