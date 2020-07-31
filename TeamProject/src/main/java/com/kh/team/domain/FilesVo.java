package com.kh.team.domain;

public class FilesVo {

	
	private int files_no;	
	private String files;	
	private String table_name;
	private String orgFileName;
	private String thumbnailName;
	
	
	public FilesVo(int files_no, String files, String table_name) {
		super();
		this.files_no = files_no;
		this.files = files;
		this.table_name = table_name;
	}
	
	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}



	public String getThumbnailName() {
		return thumbnailName;
	}

	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	public FilesVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFiles_no() {
		return files_no;
	}
	public void setFiles_no(int files_no) {
		this.files_no = files_no;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	@Override
	public String toString() {
		return "FilesVo [files_no=" + files_no + ", files=" + files + ", table_name=" + table_name + ", orgFileName="
				+ orgFileName + ", thumbnailName=" + thumbnailName + "]";
	}


	
	
	
}
