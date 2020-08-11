package com.kh.team.sjy.service;

import java.util.List;


import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.myReviewPagingDto;

public interface CampingReviewService {
	
	public List<ReviewVo> campingReviewList() throws Exception;
	
	//캠핑장 후기 글쓰기
	public void campingReviewInsertRun(ReviewVo reviewVo)throws Exception;
	
	// 캠핑후기 제목 검색
//	public int campingTitleSearch(String review_title) throws Exception;

	//캠핑장 후기 등록 파일 조회
	public List<FilesVo> filesList(String table_name) throws Exception;
	// (캠핑장 후기 내용)이미지 보여주기  filesNoFilsList(파일번호 조회)
	public List<FilesVo> filesNoFilesList(int files_no) throws Exception;
	
	//캠핑후기 수정 폼
	public ReviewVo campingReviewModifyForm(int review_no) throws Exception;
	//캠핑후기 수정 처리
	public void campingReviewModifyRun(ReviewVo reviewVo) throws Exception;
	//캠핑후기 삭제
	public void campingReviewDelete(int review_no) throws Exception;
	
	//캠핑장 후기 수정 파일 조회
	public List<FilesVo> modifyFileList(String table_name)throws Exception;
	
	//캠핑장 후기 게시물 개수 
	public int campingReviewListCount(myReviewPagingDto myReviewPagingDto) throws Exception;
	
	//캠핑장 후기 페이징
	public List<ReviewVo> campingReviewListPage(myReviewPagingDto myReviewPagingDto)throws Exception;
	


}
