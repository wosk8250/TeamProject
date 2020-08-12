package com.kh.team.sjy.service;

import java.util.List;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.MyReviewPagingDto;

public interface CampingFaqService {
	
	

	//자주 묻는 질문 게시물 개수
	public int campingFaqListCount(MyReviewPagingDto myReviewPagingDto) throws Exception;
	
	//자주 묻는 질문 페이징
	public List<FaqVo> faqListPage(MyReviewPagingDto myReviewPagingDto) throws Exception;
}
