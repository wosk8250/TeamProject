package com.kh.team.domain;

import java.sql.Date;

public class campingToolVo {
	int tool_no;
	String tool_title;
	String tool_content;
	String tool_writer;
	Date tool_date;
	int tool_view;
	int tool_damin;
	
	public campingToolVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public campingToolVo(int tool_no, String tool_title, String tool_content, String tool_writer, Date tool_date,
			int tool_view, int tool_damin) {
		super();
		this.tool_no = tool_no;
		this.tool_title = tool_title;
		this.tool_content = tool_content;
		this.tool_writer = tool_writer;
		this.tool_date = tool_date;
		this.tool_view = tool_view;
		this.tool_damin = tool_damin;
	}
	public int getTool_no() {
		return tool_no;
	}
	public void setTool_no(int tool_no) {
		this.tool_no = tool_no;
	}
	public String getTool_title() {
		return tool_title;
	}
	public void setTool_title(String tool_title) {
		this.tool_title = tool_title;
	}
	public String getTool_content() {
		return tool_content;
	}
	public void setTool_content(String tool_content) {
		this.tool_content = tool_content;
	}
	public String getTool_writer() {
		return tool_writer;
	}
	public void setTool_writer(String tool_writer) {
		this.tool_writer = tool_writer;
	}
	public Date getTool_date() {
		return tool_date;
	}
	public void setTool_date(Date tool_date) {
		this.tool_date = tool_date;
	}
	public int getTool_view() {
		return tool_view;
	}
	public void setTool_view(int tool_view) {
		this.tool_view = tool_view;
	}
	public int getTool_damin() {
		return tool_damin;
	}
	public void setTool_damin(int tool_damin) {
		this.tool_damin = tool_damin;
	}
	@Override
	public String toString() {
		return "campingToolVo [tool_no=" + tool_no + ", tool_title=" + tool_title + ", tool_content=" + tool_content
				+ ", tool_writer=" + tool_writer + ", tool_date=" + tool_date + ", tool_view=" + tool_view
				+ ", tool_damin=" + tool_damin + "]";
	}
	
	
}
