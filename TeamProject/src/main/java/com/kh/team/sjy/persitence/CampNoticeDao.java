package com.kh.team.sjy.persitence;

import java.util.List;

import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.MyReviewPagingDto;


public interface CampNoticeDao {

	//캠핑장 공지사항 목록
	public List<CampNoticeVo> campNoticeList()throws Exception;
	
	//캠핑장 공지사항 내용
	public CampNoticeVo singleContentsCampNotice(int notice_no)throws Exception;
	
	// 조회수 
	public void updateNoticeView(int notice_no ) throws Exception;
	
	//캠핑장 공지사항 게시물 개수 
	public int campingNoticeListCount(MyReviewPagingDto myReviewPagingDto)throws Exception;
	//캠핑장 수칙 페이징
	public List<CampNoticeVo> noticeListPage(MyReviewPagingDto myReviewPagingDto)throws Exception;

	

}
