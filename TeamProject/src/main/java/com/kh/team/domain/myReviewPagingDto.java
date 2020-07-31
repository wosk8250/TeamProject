package com.kh.team.domain;

public class myReviewPagingDto {
	private int page =1;//보여지는 페이지(현제 페이지)
	private int perPage = 10;//보여지는 리뷰 목록의 갯수
	private int startRow =1; //맨 첫페이지
	private int endRow = 10;//맨 끝 페이지
	private int startPage;//보여지는 페이지의 첫페이지(1,11,21,31)
	private int endPage;//보여지는 페이지의 끝페이지(10,20,30)
	private int totalPage;//총 페이지
	private int totalCount;//전체 게시글 수
	private String user_id;
	private String location;
	private String area;
	
	
	public myReviewPagingDto() {
		super();
	}
	
	public void setmyReviewPageInfo() {
		// perPage : 5
		// 1번째장, 1, 5
		// 2번째장, 6, 10
		// 3번째장, 11, 15
		this.endRow = page * perPage;
		this.startRow = this.endRow - this.perPage + 1;
		//현제 페이지 7 : 첫 5 ~ 끝 10
		this.endPage = (int) (Math.ceil((double)page / 10) * 10);
		this.startPage = this.endPage - 10 + 1;
	}
	
	public myReviewPagingDto(int page, int perPage, int startRow, int endRow, int startPage, int endPage, int totalPage,
			int totalCount) {
		super();
		this.page = page;
		this.perPage = perPage;
		this.startRow = startRow;
		this.endRow = endRow;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//perPage : 10
		//게시글 수 -> 페이지 수
		//	500		->	 50
		//	501		->	 51
		//	499		->	 50
		//Math.ceil 소수점 올리기
		this.totalPage = (int)Math.ceil((double)totalCount / perPage);
		
		//페이징 블럭에서 표현할 시작 페이지, 끝페이지
		//페이징 블럭에서 끝페이지 정리
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "myReviewPagingDto [page=" + page + ", perPage=" + perPage + ", startRow=" + startRow + ", endRow="
				+ endRow + ", startPage=" + startPage + ", endPage=" + endPage + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", user_id=" + user_id + "]";
	}
	

	
	
}
