package com.kh.team.sjy.service;

import java.util.List;

import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.myReviewPagingDto;

public interface CampingTipService {

	//캠핑장 수칙 목록 
	public List<CampingTipVo> campingTipList()throws Exception;
	//파일 조회
	public List<FilesVo> filesList(String table_name )throws Exception;
	//(캠핑장 수칙 ) 이미지 보여주기  filesNoFilsList(파일번호 조회)
	public List<FilesVo> filesNoFilesList(int files_no) throws Exception;
	//캠핑장 수칙 게시물 개수 
	public int campingTipListCount(myReviewPagingDto myReviewPagingDto) throws Exception;
	//캠핑장 수칙 페이징
	public List<CampingTipVo> campingTipListPage (myReviewPagingDto myReviewPagingDto)throws Exception;

}
