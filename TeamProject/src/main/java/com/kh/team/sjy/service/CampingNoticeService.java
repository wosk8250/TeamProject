package com.kh.team.sjy.service;

import java.util.List;

import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.myReviewPagingDto;

public interface CampingNoticeService {

		//캠핑장 공지사항 게시물 개수
		public int campingNoticeListCount(myReviewPagingDto myReviewPagingDto)throws Exception;
		//캠핑장 공지사항 페이징
		public List<CampNoticeVo> noticeListPage(myReviewPagingDto myReviewPagingDto)throws Exception;
}
