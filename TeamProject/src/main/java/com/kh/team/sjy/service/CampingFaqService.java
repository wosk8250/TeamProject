package com.kh.team.sjy.service;

import java.util.List;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;

public interface CampingFaqService {
	
	public FaqVo selectByFaq(int faq_no) throws Exception;

	//자주 묻는 질문 게시물 개수
	public int campingFaqListCount(myReviewPagingDto myReviewPagingDto) throws Exception;
	
	//자주 묻는 질문 페이징
	public List<FaqVo> faqListPage(myReviewPagingDto myReviewPagingDto) throws Exception;
}
