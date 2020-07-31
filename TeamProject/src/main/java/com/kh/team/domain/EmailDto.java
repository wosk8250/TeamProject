package com.kh.team.domain;

public class EmailDto {
	private String from = "rlatkdrl321@gmail.com";
	private String to;
	private String subject ="안녕하세요 camp Club 입니다.";
	private String contents;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	@Override
	public String toString() {
		return "EmailDto [from=" + from + ", to=" + to + ", subject=" + subject + ", contents=" + contents + "]";
	}
	
	
	
	
}
